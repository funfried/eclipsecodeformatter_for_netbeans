/*
 * Copyright (c) 2020 bahlef.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * Contributors:
 * bahlef - initial API and implementation and/or initial documentation
 */
package de.funfried.netbeans.plugins.external.formatter.strategies.google;

import java.util.SortedSet;
import java.util.prefs.Preferences;

import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import org.apache.commons.lang3.tuple.Pair;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.openide.awt.NotificationDisplayer;
import org.openide.awt.StatusDisplayer;

import com.google.googlejavaformat.java.JavaFormatterOptions;

import de.funfried.netbeans.plugins.external.formatter.Utils;
import de.funfried.netbeans.plugins.external.formatter.exceptions.FileTypeNotSupportedException;
import de.funfried.netbeans.plugins.external.formatter.strategies.AbstractFormatterRunnable;
import de.funfried.netbeans.plugins.external.formatter.ui.Icons;
import de.funfried.netbeans.plugins.external.formatter.ui.options.Settings;

/**
 * Google formatter implementation of the {@link AbstractFormatterRunnable} to
 * format a given document using the {@link GoogleFormatter}.
 *
 * @author bahlef
 */
class GoogleFormatterRunnable extends AbstractFormatterRunnable {
	/** The {@link EclipGoogleFormatterseFormatter} implementation. */
	private final GoogleFormatter formatter;

	/**
	 * Package private constructor to create a new instance of {@link GoogleFormatterRunnable}.
	 *
	 * @param document        the {@link StyledDocument} which sould be formatted
	 * @param formatter       the {@link GoogleFormatter} to use
	 * @param changedElements the ranges which should be formatted
	 */
	GoogleFormatterRunnable(StyledDocument document, GoogleFormatter formatter, SortedSet<Pair<Integer, Integer>> changedElements) {
		super(document, changedElements);

		this.formatter = formatter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		boolean isJava = Utils.isJava(document);
		if (!isJava) {
			throw new FileTypeNotSupportedException("The file type '" + NbEditorUtilities.getMimeType(document) + "' is not supported by the Goolge Java Code Formatter");
		}

		Preferences pref = Settings.getActivePreferences(document);

		String codeStylePref = pref.get(Settings.GOOGLE_FORMATTER_CODE_STYLE, JavaFormatterOptions.Style.GOOGLE.name());

		String code = getCode(null);

		try {
			SortedSet<Pair<Integer, Integer>> regions = getFormatableSections(code);

			String formattedContent = formatter.format(code, JavaFormatterOptions.Style.valueOf(codeStylePref), regions);
			if (setFormattedCode(code, formattedContent)) {
				SwingUtilities.invokeLater(() -> {
					if (pref.getBoolean(Settings.SHOW_NOTIFICATIONS, false)) {
						NotificationDisplayer.getDefault().notify("Format using Goolge formatter", Icons.ICON_GOOGLE, null, null);
					}

					StatusDisplayer.getDefault().setStatusText("Format using Goolge formatter");
				});
			}
		} catch (BadLocationException ex) {
			throw new RuntimeException(ex);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
}