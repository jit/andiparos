/*
 *
 * Paros and its related class files.
 * 
 * Paros is an HTTP/HTTPS proxy for assessing web application security.
 * Copyright (C) 2003-2004 Chinotec Technologies Company
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the Clarified Artistic License
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Clarified Artistic License for more details.
 * 
 * You should have received a copy of the Clarified Artistic License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.parosproxy.paros.view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.parosproxy.paros.Constant;
import org.parosproxy.paros.control.Control;
import org.parosproxy.paros.control.MenuFileControl;
import org.parosproxy.paros.control.MenuToolsControl;

/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MainMenuBar extends JMenuBar {
	private static final long serialVersionUID = 2161880506665813883L;
	
	private javax.swing.JMenu menuEdit = null;
	private javax.swing.JMenu menuTools = null;
	private javax.swing.JMenu menuView = null;
	private javax.swing.JMenuItem menuToolsOptions = null;
	private javax.swing.JMenu menuFile = null;
	private javax.swing.JMenuItem menuFileNewSession = null;
	private javax.swing.JMenuItem menuFileOpen = null;
	private javax.swing.JMenuItem menuFileSaveAs = null;
	private javax.swing.JMenuItem menuFileExit = null;
	private JMenuItem menuFileProperties = null;
	private JMenuItem menuFileSave = null;
	private JMenu menuHelp = null;
	private JMenuItem menuHelpAbout = null;
	private JMenu menuAnalyse = null;

	/**
	 * This method initializes
	 * 
	 */
	public MainMenuBar() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.add(getMenuFile());
		this.add(getMenuEdit());
		this.add(getMenuView());
		this.add(getMenuAnalyse());
		this.add(getMenuTools());
		this.add(getMenuHelp());

	}

	/**
	 * 
	 * This method initializes menuEdit
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenu
	 */
	public javax.swing.JMenu getMenuEdit() {
		if (menuEdit == null) {
			menuEdit = new javax.swing.JMenu();
			menuEdit.setText("Edit");
		}
		return menuEdit;
	}

	/**
	 * 
	 * This method initializes menuTools
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenu
	 */
	public javax.swing.JMenu getMenuTools() {
		if (menuTools == null) {
			menuTools = new javax.swing.JMenu();
			menuTools.setText("Tools");
			menuTools.addSeparator();
			menuTools.add(getMenuToolsOptions());
		}
		return menuTools;
	}

	/**
	 * 
	 * This method initializes menuView
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenu
	 */
	public javax.swing.JMenu getMenuView() {
		if (menuView == null) {
			menuView = new javax.swing.JMenu();
			menuView.setText("View");
		}
		return menuView;
	}

	/**
	 * 
	 * This method initializes menuToolsOptions
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuToolsOptions() {
		if (menuToolsOptions == null) {
			menuToolsOptions = new javax.swing.JMenuItem();
			menuToolsOptions.setText("Options...");
			menuToolsOptions
					.addActionListener(new java.awt.event.ActionListener() {

						public void actionPerformed(java.awt.event.ActionEvent e) {

							getMenuToolsControl().options();

						}
					});

		}
		return menuToolsOptions;
	}

	/**
	 * 
	 * This method initializes menuFile
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenu
	 */
	public javax.swing.JMenu getMenuFile() {
		if (menuFile == null) {
			menuFile = new javax.swing.JMenu();
			menuFile.setText("File");
			menuFile.setMnemonic(java.awt.event.KeyEvent.VK_F);
			menuFile.add(getMenuFileNewSession());
			menuFile.add(getMenuFileOpen());
			menuFile.addSeparator();
			menuFile.add(getMenuFileSave());
			menuFile.add(getMenuFileSaveAs());
			menuFile.addSeparator();
			menuFile.add(getMenuFileProperties());
			menuFile.addSeparator();
			menuFile.addSeparator();
			menuFile.add(getMenuFileExit());
		}
		return menuFile;
	}

	/**
	 * 
	 * This method initializes menuFileNewSession
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuFileNewSession() {
		if (menuFileNewSession == null) {
			menuFileNewSession = new javax.swing.JMenuItem();
			menuFileNewSession.setText("New Session");
			menuFileNewSession
					.addActionListener(new java.awt.event.ActionListener() {

						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								getMenuFileControl().newSession(true);
								getMenuFileSave().setEnabled(false);
							} catch (Exception e1) {
								View.getSingleton().showWarningDialog(
										"Error creating new session");
								e1.printStackTrace();
							}
						}
					});

		}
		return menuFileNewSession;
	}

	/**
	 * 
	 * This method initializes menuFileOpen
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuFileOpen() {
		if (menuFileOpen == null) {
			menuFileOpen = new javax.swing.JMenuItem();
			menuFileOpen.setText("Open Session...");
			menuFileOpen.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					getMenuFileControl().openSession();
					getMenuFileSave().setEnabled(true);

				}
			});

		}
		return menuFileOpen;
	}

	/**
	 * 
	 * This method initializes menuFileSaveAs
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuFileSaveAs() {
		if (menuFileSaveAs == null) {
			menuFileSaveAs = new javax.swing.JMenuItem();
			menuFileSaveAs.setText("Save As...");
			menuFileSaveAs
					.addActionListener(new java.awt.event.ActionListener() {

						public void actionPerformed(java.awt.event.ActionEvent e) {
							getMenuFileControl().saveAsSession();

						}
					});

		}
		return menuFileSaveAs;
	}

	/**
	 * 
	 * This method initializes menuFileExit
	 * 
	 * 
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuFileExit() {
		if (menuFileExit == null) {
			menuFileExit = new javax.swing.JMenuItem();
			menuFileExit.setText("Exit");
			menuFileExit.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					getMenuFileControl().exit();
				}
			});

		}
		return menuFileExit;
	}

	/**
	 * This method initializes menuFileControl
	 * 
	 * @return com.proofsecure.paros.view.MenuFileControl
	 */
	public MenuFileControl getMenuFileControl() {
		return Control.getSingleton().getMenuFileControl();
	}

	/**
	 * This method initializes menuToolsControl
	 * 
	 * @return com.proofsecure.paros.view.MenuToolsControl
	 */
	private MenuToolsControl getMenuToolsControl() {
		return Control.getSingleton().getMenuToolsControl();
	}

	/**
	 * This method initializes menuFileProperties
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuFileProperties() {
		if (menuFileProperties == null) {
			menuFileProperties = new JMenuItem();
			menuFileProperties.setText("Properties...");
			menuFileProperties
					.addActionListener(new java.awt.event.ActionListener() {

						public void actionPerformed(java.awt.event.ActionEvent e) {
							getMenuFileControl().properties();
						}
					});

		}
		return menuFileProperties;
	}

	/**
	 * This method initializes menuFileSave
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getMenuFileSave() {
		if (menuFileSave == null) {
			menuFileSave = new JMenuItem();
			menuFileSave.setText("Save");
			menuFileSave.setEnabled(false);
			menuFileSave.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {

					getMenuFileControl().saveSession();

				}
			});

		}
		return menuFileSave;
	}

	/**
	 * This method initializes menuHelp
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuHelp() {
		if (menuHelp == null) {
			menuHelp = new JMenu();
			menuHelp.setText("Help");
			menuHelp.add(getMenuHelpAbout());
		}
		return menuHelp;
	}

	/**
	 * This method initializes menuHelpAbout
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuHelpAbout() {
		if (menuHelpAbout == null) {
			menuHelpAbout = new JMenuItem();
			menuHelpAbout.setText("About " + Constant.PROGRAM_NAME);
			menuHelpAbout.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AboutDialog dialog = new AboutDialog(View.getSingleton().getMainFrame(), true);
					dialog.setVisible(true);
				}
			});
		}
		return menuHelpAbout;
	}

	/**
	 * This method initializes jMenu1
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getMenuAnalyse() {
		if (menuAnalyse == null) {
			menuAnalyse = new JMenu();
			menuAnalyse.setText("Analyse");
		}
		return menuAnalyse;
	}
}
