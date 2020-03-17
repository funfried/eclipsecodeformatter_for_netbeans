/*
 * Copyright (c) 2020 bahlef.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * Contributors:
 * bahlef - initial API and implementation and/or initial documentation
 */

package de.funfried.netbeans.plugins.external.formatter.xml.revelc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.commons.lang3.StringUtils;
import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

import de.funfried.netbeans.plugins.external.formatter.ui.options.AbstractFormatterOptionsPanel;
import de.funfried.netbeans.plugins.external.formatter.xml.revelc.RevelcXmlFormatterSettings;
import net.revelc.code.formatter.xml.lib.FormattingPreferences;

/**
 *
 * @author bahlef
 */
public class RevelcXmlFormatterOptionsPanel extends AbstractFormatterOptionsPanel {
	/** Creates new form {@link RevelcXmlFormatterOptionsPanel}. */
	public RevelcXmlFormatterOptionsPanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linefeedLbl = new JLabel();
        linefeedCmbBox = new JComboBox<>();
        rightMarginLbl = new JLabel();
        rightMarginSpn = new JSpinner();
        wrapLongLinesChkBox = new JCheckBox();
        wellFormedValidationLbl = new JLabel();
        wellFormedValidationCmbBox = new JComboBox<>();
        expandTabsToSpacesChkBox = new JCheckBox();
        splitMultiAttrsChkBox = new JCheckBox();
        tabWidthLbl = new JLabel();
        tabWidthSpn = new JSpinner();

        Mnemonics.setLocalizedText(linefeedLbl, NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.linefeedLbl.text")); // NOI18N
        linefeedLbl.setToolTipText(NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.linefeedLbl.toolTipText")); // NOI18N

        linefeedCmbBox.setModel(new DefaultComboBoxModel<>(new String[] { "System", "\\n", "\\r\\n", "\\r" }));
        linefeedCmbBox.setToolTipText(NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.linefeedCmbBox.toolTipText")); // NOI18N
        linefeedCmbBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                linefeedCmbBoxActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(rightMarginLbl, NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.rightMarginLbl.text")); // NOI18N

        rightMarginSpn.setModel(new SpinnerNumberModel(120, 10, null, 10));
        rightMarginSpn.setToolTipText(NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.rightMarginSpn.toolTipText")); // NOI18N
        rightMarginSpn.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                rightMarginSpnStateChanged(evt);
            }
        });

        wrapLongLinesChkBox.setSelected(true);
        Mnemonics.setLocalizedText(wrapLongLinesChkBox, NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.wrapLongLinesChkBox.text")); // NOI18N
        wrapLongLinesChkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                wrapLongLinesChkBoxActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(wellFormedValidationLbl, NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.wellFormedValidationLbl.text")); // NOI18N

        wellFormedValidationCmbBox.setModel(new DefaultComboBoxModel<>(new String[] { "IGNORE", "WARN", "FAIL" }));
        wellFormedValidationCmbBox.setSelectedIndex(1);
        wellFormedValidationCmbBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                wellFormedValidationCmbBoxActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(expandTabsToSpacesChkBox, NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.expandTabsToSpacesChkBox.text")); // NOI18N
        expandTabsToSpacesChkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                expandTabsToSpacesChkBoxActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(splitMultiAttrsChkBox, NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.splitMultiAttrsChkBox.text")); // NOI18N
        splitMultiAttrsChkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                splitMultiAttrsChkBoxActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(tabWidthLbl, NbBundle.getMessage(RevelcXmlFormatterOptionsPanel.class, "RevelcXmlFormatterOptionsPanel.tabWidthLbl.text")); // NOI18N

        tabWidthSpn.setModel(new SpinnerNumberModel(4, null, null, 1));
        tabWidthSpn.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                tabWidthSpnStateChanged(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(expandTabsToSpacesChkBox)
                            .addComponent(splitMultiAttrsChkBox)
                            .addComponent(wrapLongLinesChkBox))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(wellFormedValidationLbl, GroupLayout.Alignment.TRAILING)
                            .addComponent(rightMarginLbl, GroupLayout.Alignment.TRAILING)
                            .addComponent(tabWidthLbl, GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(linefeedLbl)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(wellFormedValidationCmbBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(rightMarginSpn, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addComponent(tabWidthSpn))
                    .addComponent(linefeedCmbBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(tabWidthLbl)
                            .addComponent(tabWidthSpn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(rightMarginLbl)
                            .addComponent(rightMarginSpn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(wellFormedValidationLbl)
                            .addComponent(wellFormedValidationCmbBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(linefeedLbl)
                            .addComponent(linefeedCmbBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(expandTabsToSpacesChkBox)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(splitMultiAttrsChkBox)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wrapLongLinesChkBox)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void linefeedCmbBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_linefeedCmbBoxActionPerformed
        fireChangedListener();
    }//GEN-LAST:event_linefeedCmbBoxActionPerformed

    private void expandTabsToSpacesChkBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_expandTabsToSpacesChkBoxActionPerformed
        fireChangedListener();
    }//GEN-LAST:event_expandTabsToSpacesChkBoxActionPerformed

    private void splitMultiAttrsChkBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_splitMultiAttrsChkBoxActionPerformed
        fireChangedListener();
    }//GEN-LAST:event_splitMultiAttrsChkBoxActionPerformed

    private void wrapLongLinesChkBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_wrapLongLinesChkBoxActionPerformed
        fireChangedListener();
    }//GEN-LAST:event_wrapLongLinesChkBoxActionPerformed

    private void tabWidthSpnStateChanged(ChangeEvent evt) {//GEN-FIRST:event_tabWidthSpnStateChanged
        fireChangedListener();
    }//GEN-LAST:event_tabWidthSpnStateChanged

    private void rightMarginSpnStateChanged(ChangeEvent evt) {//GEN-FIRST:event_rightMarginSpnStateChanged
        fireChangedListener();
    }//GEN-LAST:event_rightMarginSpnStateChanged

    private void wellFormedValidationCmbBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_wellFormedValidationCmbBoxActionPerformed
        fireChangedListener();
    }//GEN-LAST:event_wellFormedValidationCmbBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JCheckBox expandTabsToSpacesChkBox;
    private JComboBox<String> linefeedCmbBox;
    private JLabel linefeedLbl;
    private JLabel rightMarginLbl;
    private JSpinner rightMarginSpn;
    private JCheckBox splitMultiAttrsChkBox;
    private JLabel tabWidthLbl;
    private JSpinner tabWidthSpn;
    private JComboBox<String> wellFormedValidationCmbBox;
    private JLabel wellFormedValidationLbl;
    private JCheckBox wrapLongLinesChkBox;
    // End of variables declaration//GEN-END:variables

	private String getLinefeed() {
		if (0 == linefeedCmbBox.getSelectedIndex()) {
			return "";
		}
		return linefeedCmbBox.getSelectedItem().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void load(Preferences preferences) {
		boolean expandTabsToSpaces = !preferences.getBoolean(RevelcXmlFormatterSettings.TAB_INSTEAD_OF_SPACES, true);
		boolean splitMultiAttrs = preferences.getBoolean(RevelcXmlFormatterSettings.SPLIT_MULTI_ATTRIBUTES, false);
		boolean wrapLongLines = preferences.getBoolean(RevelcXmlFormatterSettings.WRAP_LONG_LINES, true);
		int tabWidth = preferences.getInt(RevelcXmlFormatterSettings.TAB_WIDTH, 4);
		int rightMargin = preferences.getInt(RevelcXmlFormatterSettings.MAX_LINE_LENGTH, 120);
		String wellFormedValidation = preferences.get(RevelcXmlFormatterSettings.WELL_FORMED_VALIDATION, FormattingPreferences.WARN);
		String lineFeed = preferences.get(RevelcXmlFormatterSettings.LINEFEED, "");

		expandTabsToSpacesChkBox.setSelected(expandTabsToSpaces);
		splitMultiAttrsChkBox.setSelected(splitMultiAttrs);
		wrapLongLinesChkBox.setSelected(wrapLongLines);
		tabWidthSpn.setValue(tabWidth);
		rightMarginSpn.setValue(rightMargin);
		wellFormedValidationCmbBox.setSelectedItem(wellFormedValidation);

		if (StringUtils.isBlank(lineFeed)) {
			//default = system-dependend LF
			linefeedCmbBox.setSelectedIndex(0);
		} else {
			linefeedCmbBox.setSelectedItem(lineFeed);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(Preferences preferences) {
		preferences.putBoolean(RevelcXmlFormatterSettings.TAB_INSTEAD_OF_SPACES, !expandTabsToSpacesChkBox.isSelected());
		preferences.putBoolean(RevelcXmlFormatterSettings.SPLIT_MULTI_ATTRIBUTES, splitMultiAttrsChkBox.isSelected());
		preferences.putBoolean(RevelcXmlFormatterSettings.WRAP_LONG_LINES, wrapLongLinesChkBox.isSelected());
		preferences.putInt(RevelcXmlFormatterSettings.TAB_WIDTH, (int) tabWidthSpn.getValue());
		preferences.putInt(RevelcXmlFormatterSettings.MAX_LINE_LENGTH, (int) rightMarginSpn.getValue());
		preferences.put(RevelcXmlFormatterSettings.WELL_FORMED_VALIDATION, (String) wellFormedValidationCmbBox.getSelectedItem());
		preferences.put(RevelcXmlFormatterSettings.LINEFEED, getLinefeed());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean valid() {
		return true;
	}
}
