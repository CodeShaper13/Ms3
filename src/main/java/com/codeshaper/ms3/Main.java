package com.codeshaper.ms3;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.codeshaper.ms3.debug.DebugRun;
import com.codeshaper.ms3.util.Logger;

/**
 * Launches a window providing the user with some links, install instructions
 * and the version.
 * 
 * @author CodeShaper
 */
public class Main implements ActionListener { // TODO This is launched when the jar is clicked, I think the manifest
												// needs to be edited.

	private static final String INSTALL_TEXT = "To install, drop the mod Jar (This file) into your     mods folder along with your downloaded jython.jar";
	private static final String SUPPORT_AND_HELP_URL = "https://www.google.com/";
	private static final String DOCUMENTATION_URL = "https://www.google.com/";

	private JButton webPageButton;
	private JButton docButton;
	private JButton debugBuildButton;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = (JPanel) frame.getContentPane();
		frame.setSize(300, 225);
		frame.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel p1 = new JPanel();
		
		JLabel versionLabel = new JLabel(Ms3.MOD_NAME + " Version: " + Ms3.MOD_VERSION);		
		//JLabel apiVersionLabel = new JLabel(Ms3.MOD_NAME + "API Version: " + Ms3.API_VERSION);
		
		JTextArea ta = new JTextArea(5, 25);
		ta.setText(INSTALL_TEXT);
		ta.setLineWrap(true);
		
		p1.add(versionLabel);
		//p1.add(apiVersionLabel);
		p1.add(ta);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 1, 10, 10));
		
		this.webPageButton = new JButton("Online Support & Feedback");
		this.webPageButton.addActionListener(this);
		p2.add(this.webPageButton);
		
		this.docButton = new JButton("Online Documentation");
		this.docButton.addActionListener(this);
		p2.add(this.docButton);

		this.debugBuildButton = new JButton("Debug Build");
		this.debugBuildButton.addActionListener(this);
		p2.add(this.debugBuildButton);
		
		panel.add(p1);
		panel.add(p2);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == this.debugBuildButton) {			
			String s = (String)JOptionPane.showInputDialog("Enter the path to build the API in, this will most likely\nbe the ms3 folder in your .minecraft directory ");
			try {
				DebugRun.build(s);
				JOptionPane.showMessageDialog(null, "API Built");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Directory \"" + s + "\" does not exist!");
			}			
		} else {
			String s = (source == this.webPageButton ? SUPPORT_AND_HELP_URL : DOCUMENTATION_URL);
			if (Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().browse(new URL(s).toURI());
				} catch (Exception e1) {
					Logger.err("Unable to launch web browser");
				}
			}	
		}
	}
}
