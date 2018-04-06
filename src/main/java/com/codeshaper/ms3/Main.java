package com.codeshaper.ms3;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.codeshaper.ms3.util.Logger;

/**
 * Launches a window providing the user with some links, install instructions
 * and the version.
 */
public class Main implements ActionListener { // TODO This is launched when the jar is clicked, I think the manifest
												// needs to be edited.

	private static final String INSTALL_TEXT = "To install, drop the mod Jar (This file) into your     mods folder along with your downloaded jython.jar";
	private static final String SUPPORT_AND_HELP_URL = "https://www.google.com/";
	private static final String DOCUMENTATION_URL = "https://www.google.com/";

	private JButton b1;
	private JButton b2;

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
		JLabel l = new JLabel(Ms3.MOD_ID.toUpperCase() + " Version: " + Ms3.VERSION);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea ta = new JTextArea(5, 25);
		ta.setText(INSTALL_TEXT);
		ta.setLineWrap(true);
		p1.add(l);
		p1.add(ta);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 1, 10, 10));
		b1 = new JButton("Online Support & Feedback");
		b2 = new JButton("Online Documentation");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p2.add(b1);
		p2.add(b2);

		panel.add(p1);
		panel.add(p2);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getSource() == this.b1 ? SUPPORT_AND_HELP_URL : DOCUMENTATION_URL;
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URL(s).toURI());
			} catch (Exception e1) {
				Logger.err("Unable to launch web browser");
			}
		}
	}
}
