/*
 * Copyright (c) 2020 bahlef.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * Contributors:
 * bahlef - initial API and implementation and/or initial documentation
 */

package de.funfried.netbeans.plugins.external.formatter.java.palantir.ui;

import java.util.prefs.Preferences;

import javax.swing.GroupLayout;

import org.netbeans.api.project.Project;

import de.funfried.netbeans.plugins.external.formatter.ui.options.AbstractFormatterOptionsPanel;

/**
 *
 * @author bahlef
 */
public class PalantirJavaFormatterOptionsPanel extends AbstractFormatterOptionsPanel {
	/**
	 * Creates new form {@link PalantirJavaFormatterOptionsPanel}.
	 *
	 * @param project the {@link Project} if the panel is used to modify project
	 *        specific settings, otherwise {@code null}
	 */
	public PalantirJavaFormatterOptionsPanel(Project project) {
		super(project);

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

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void load(Preferences preferences) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(Preferences preferences) {
	}
}