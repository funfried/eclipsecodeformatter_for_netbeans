/*
 * Copyright (c) 2020 bahlef.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * Contributors:
 * markiewb - initial API and implementation and/or initial documentation
 * bahlef
 */
package de.funfried.netbeans.plugins.external.formatter.ui.options;

import java.util.prefs.Preferences;

import javax.swing.text.Document;

import org.apache.commons.lang3.StringUtils;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.util.NbPreferences;

/**
 * Settings utility class.
 *
 * @author markiewb
 * @author bahlef
 */
public class Settings {
	/**
	 * Property key prefix for the enabled formatter per mime type.
	 *
	 * @since 1.14
	 */
	public static final String ENABLED_FORMATTER_PREFIX = Settings.ENABLED_FORMATTER + ".";

	/**
	 * Property key which defines the enabled formatter.
	 *
	 * @since 1.13
	 *
	 * @deprecated Use {@link #ENABLED_FORMATTER_PREFIX} instead
	 */
	@Deprecated
	public static final String ENABLED_FORMATTER = "enabledFormatter";

	/**
	 * Property value of the default formatter to use (NetBeans internal formatter).
	 *
	 * @since 1.13
	 */
	public static final String DEFAULT_FORMATTER = "netbeans-formatter";

	/** Property key which defines whether or not to use the settings of the external formatter in the NetBeans editor. */
	public static final String ENABLE_USE_OF_INDENTATION_SETTINGS = "enableIndentationSettings";

	/** Property key which defines whether or not to use the {@link #OVERRIDE_TAB_SIZE_VALUE} instead of the one inside the external formatter configuration. */
	public static final String OVERRIDE_TAB_SIZE = "overrideTabSize";

	/** Property key which defines the tab size which is used when {@link #OVERRIDE_TAB_SIZE} is actived. */
	public static final String OVERRIDE_TAB_SIZE_VALUE = "overrideTabSizeValue";

	/** Property key which defines whether or not to show notifications after each formatting. */
	public static final String SHOW_NOTIFICATIONS = "showNotifications";

	/** Property key which defines whether or not to use project specific settings instead of global formatter settings. */
	public static final String USE_PROJECT_SETTINGS = "useProjectSettings";

	/** Property key for current project directory in case of project specific configuration. */
	public static final String PROJECT_DIRECTORY = "projectDirectory";

	/**
	 * Private contructor because of static methods only.
	 */
	private Settings() {
	}

	/**
	 * Returns the active {@link Preferences} object for the given {@link Document}, either the global
	 * preferences are returned or if the {@link Project} has a separate configuration it will return
	 * the project specific {@link Preferences}.
	 *
	 * @param document the document to get the {@link Preferences} for
	 *
	 * @return the active {@link Preferences} object for the given {@link Document}, either the global
	 *         preferences are returned or if the {@link Project} has a separate configuration it will return
	 *         the project specific {@link Preferences}
	 */
	public static Preferences getActivePreferences(Document document) {
		Preferences globalPreferences = NbPreferences.forModule(ExternalFormatterPanel.class);
		if (document != null) {
			DataObject dataObj = NbEditorUtilities.getDataObject(document);
			if (dataObj != null) {
				FileObject primaryFile = dataObj.getPrimaryFile();
				if (primaryFile != null) {
					Project project = FileOwnerQuery.getOwner(primaryFile);
					if (null != project) {
						Preferences projectPreferences = ProjectUtils.getPreferences(project, ExternalFormatterPanel.class, true);
						if (projectPreferences.getBoolean(USE_PROJECT_SETTINGS, false)) {
							return projectPreferences;
						}
					}
				}
			}
		}

		return globalPreferences;
	}

	/**
	 * Returns the real line feed characters for the given escaped line feed characters.
	 *
	 * @param lineFeedSetting escaped line feed characters, e.g. {@code \\n}
	 * @param fallback        if the escaped line feed characters could not be matched to a real line feed setting
	 *
	 * @return the real line feed characters for the given escaped line feed characters, or the given
	 *         {@code fallback} if the escaped characters could not be matched to a real line feed setting
	 */
	public static String getLineFeed(String lineFeedSetting, String fallback) {
		String linefeed = fallback;

		boolean usePlatformLinefeed = StringUtils.isBlank(lineFeedSetting);
		if (!usePlatformLinefeed) {
			switch (lineFeedSetting) {
				case "\\n":
					linefeed = BaseDocument.LS_LF;
					break;
				case "\\r":
					linefeed = BaseDocument.LS_CR;
					break;
				case "\\r\\n":
					linefeed = BaseDocument.LS_CRLF;
					break;
				default:
					linefeed = null;
					break;
			}
		}

		return linefeed;
	}
}
