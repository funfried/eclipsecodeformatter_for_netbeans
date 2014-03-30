/*
 * Copyright (c) 2013 markiewb.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    markiewb - initial API and implementation and/or initial documentation
 */
package de.markiewb.netbeans.plugins.eclipse.formatter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import de.markiewb.netbeans.plugins.eclipse.formatter.xml.ConfigReadException;
import de.markiewb.netbeans.plugins.eclipse.formatter.xml.ConfigReader;
import de.markiewb.netbeans.plugins.eclipse.formatter.xml.Profile;
import java.util.List;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.xml.sax.SAXException;

public final class EclipseFormatter {

    private final String formatterFile;
    private final String formatterProfile;

    EclipseFormatter(String formatterFile, String formatterProfile) {
        this.formatterFile = formatterFile;
        this.formatterProfile = formatterProfile;
    }

    public class ProfileNotFoundException extends RuntimeException {

        public ProfileNotFoundException(String message) {
            super(message);
        }
    }

//     NotificationDisplayer.getDefault().notify("Using the Global Eclipse formatter", icon, message, null);
    private Map getFormattingOptions() {
        Map options = DefaultCodeFormatterConstants.getJavaConventionsSettings();
        options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_6);
        options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_6);
        options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_6);
//      For checking whether the Eclipse formatter works,
//      without needing an Eclipse formatter XML file:
//        options.put(
//		DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_ENUM_CONSTANTS,
//		DefaultCodeFormatterConstants.createAlignmentValue(
//		true,
//		DefaultCodeFormatterConstants.WRAP_ONE_PER_LINE,
//		DefaultCodeFormatterConstants.INDENT_ON_COLUMN));

        return options;
    }

    // returns null if format resulted in no change
    private String format(final String code, int startOffset, int endOffset) throws MalformedTreeException, BadLocationException {
        final int opts =
                CodeFormatter.K_COMPILATION_UNIT + CodeFormatter.F_INCLUDE_COMMENTS;
        Map allConfig = new HashMap();
        final Map configFromStatic = getFormattingOptions();
        try {
            List<Profile> profiles = new ConfigReader().read(FileUtil.normalizeFile(new File(formatterFile)));

            String name = formatterProfile;
            Map<String, String> configFromFile;

            if (profiles.isEmpty()) {
                //no config found
                throw new ProfileNotFoundException("No profiles found in " + formatterFile);
            }

            Profile profile = getProfileByName(profiles, name);

            if (null == profile) {
                throw new ProfileNotFoundException("profile " + name + " not found in " + formatterFile);
            }

            configFromFile = profile.getSettings();

            allConfig.putAll(configFromStatic);
            allConfig.putAll(configFromFile);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SAXException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ConfigReadException ex) {
            Exceptions.printStackTrace(ex);
        }
        CodeFormatter formatter = ToolFactory.createCodeFormatter(allConfig);
        final TextEdit te = formatter.format(opts, code, startOffset, endOffset - startOffset, 0, null);
        final IDocument dc = new Document(code);
        String formattedCode = null;
        if ((te != null) && (te.getChildrenSize() > 0)) {
            te.apply(dc);
            formattedCode = dc.get();
        }
        return formattedCode;
    }

    public String forCode(final String code, int startOffset, int endOffset) {
        String result = null;
        try {
            if (code != null) {
                result = this.format(code, startOffset, endOffset);
            }
        } catch (BadLocationException ex) {
            System.out.println(ex);
            Logger.getLogger(EclipseFormatter.class.getName()).log(Level.SEVERE,
                    "code could not be formatted!", ex);
        } catch (MalformedTreeException ex) {
            System.out.println(ex);
            Logger.getLogger(EclipseFormatter.class.getName()).log(Level.SEVERE,
                    "code could not be formatted!", ex);
        }
        return result;
    }

    /**
     * 
     * @return profile of <code>null</code> if profile with name not found
     */
    private Profile getProfileByName(List<Profile> profiles, String name) {
        if (null == name) {
            return null;
        }
        for (Profile profile : profiles) {
            if (null != profile && name.equals(profile.getName())) {
                return profile;
            }
        }
        return null;
    }

}
