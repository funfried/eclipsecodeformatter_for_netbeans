/*
 * Copyright (c) 2020 bahlef.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * Contributors:
 * bahlef - initial API and implementation and/or initial documentation
 */

package de.funfried.netbeans.plugins.external.formatter.java.google;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

import com.google.googlejavaformat.java.JavaFormatterOptions;

import de.funfried.netbeans.plugins.external.formatter.ui.options.AbstractFormatterOptionsPanel;

/**
 *
 * @author bahlef
 */
public class GoogleJavaFormatterOptionsPanel extends AbstractFormatterOptionsPanel {
	/** Creates new form GoogleJavaFormatterOptionsPanel. */
	public GoogleJavaFormatterOptionsPanel() {
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

        googleCodeStyleBtnGrp = new ButtonGroup();
        googleCodeStyleRdBtn = new JRadioButton();
        aospRdBtn = new JRadioButton();
        googleCodeStyleLbl = new JLabel();

        googleCodeStyleBtnGrp.add(googleCodeStyleRdBtn);
        googleCodeStyleRdBtn.setSelected(true);
        Mnemonics.setLocalizedText(googleCodeStyleRdBtn, NbBundle.getMessage(GoogleJavaFormatterOptionsPanel.class, "GoogleJavaFormatterOptionsPanel.googleCodeStyleRdBtn.text")); // NOI18N
        googleCodeStyleRdBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                googleCodeStyleRdBtnActionPerformed(evt);
            }
        });

        googleCodeStyleBtnGrp.add(aospRdBtn);
        Mnemonics.setLocalizedText(aospRdBtn, NbBundle.getMessage(GoogleJavaFormatterOptionsPanel.class, "GoogleJavaFormatterOptionsPanel.aospRdBtn.text")); // NOI18N
        aospRdBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aospRdBtnActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(googleCodeStyleLbl, NbBundle.getMessage(GoogleJavaFormatterOptionsPanel.class, "GoogleJavaFormatterOptionsPanel.googleCodeStyleLbl.text")); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(googleCodeStyleLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(googleCodeStyleRdBtn)
                .addGap(18, 18, 18)
                .addComponent(aospRdBtn)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(googleCodeStyleRdBtn)
                    .addComponent(aospRdBtn)
                    .addComponent(googleCodeStyleLbl))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void googleCodeStyleRdBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_googleCodeStyleRdBtnActionPerformed
        fireChangedListener();
    }//GEN-LAST:event_googleCodeStyleRdBtnActionPerformed

    private void aospRdBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_aospRdBtnActionPerformed
        fireChangedListener();
    }//GEN-LAST:event_aospRdBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JRadioButton aospRdBtn;
    private ButtonGroup googleCodeStyleBtnGrp;
    private JLabel googleCodeStyleLbl;
    private JRadioButton googleCodeStyleRdBtn;
    // End of variables declaration//GEN-END:variables

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void load(Preferences preferences) {
		String googleFormatterCodeStyle = preferences.get(GoogleJavaFormatterSettings.GOOGLE_FORMATTER_CODE_STYLE, JavaFormatterOptions.Style.GOOGLE.name());

		if (JavaFormatterOptions.Style.AOSP.name().equals(googleFormatterCodeStyle)) {
			googleCodeStyleBtnGrp.setSelected(aospRdBtn.getModel(), true);
		} else {
			googleCodeStyleBtnGrp.setSelected(googleCodeStyleRdBtn.getModel(), true);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setActive(boolean active) {
		googleCodeStyleLbl.setEnabled(active);
		googleCodeStyleRdBtn.setEnabled(active);
		aospRdBtn.setEnabled(active);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(Preferences preferences) {
		preferences.put(GoogleJavaFormatterSettings.GOOGLE_FORMATTER_CODE_STYLE, googleCodeStyleRdBtn.isSelected() ? JavaFormatterOptions.Style.GOOGLE.name() : JavaFormatterOptions.Style.AOSP.name());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean valid() {
		return googleCodeStyleBtnGrp.getSelection() != null;
	}
}
