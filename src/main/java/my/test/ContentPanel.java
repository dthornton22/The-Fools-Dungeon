/*
 * ContentPanel.java
 * CS 321 Team 9 Fall 2020
 * Creates the ContentPanel class for the Map Class to build GUI
 */
package main.java.my.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Extends JPanel to represent panel for GUI items
 * Implements ActionListener to allow action based on user button click
 */
public class ContentPanel extends JPanel implements ActionListener{
 
	/**
	 * Constructs the panel of the application where the
	 * GUI items will be and the user will interact with
	 */
	public ContentPanel() {
		/**
		 * Panel dimensions and attributes
		 * layout null so items determine placement 
		 * individually
		 * arbitrary initial dimensions on personal computer
		 */
		Dimension dim = new Dimension(1200, 600);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setLayout(null);
		setBackground(Color.white);
		
		/**
		 * Label placement and attributes
		 * add to panel for display
		 * arbitrary initial dimensions on personal computer
		 */
		contentLabel = new JLabel("Splash Screen");
		Dimension size = contentLabel.getPreferredSize();
		contentLabel.setBounds(540, 260, size.width, size.height);
		add(contentLabel);
		
		/**
		 * Button placement and attributes
		 * add to panel for display
		 * arbitrary initial dimensions on personal computer
		 */
		start = new JButton("Start Game");
		start.addActionListener(this);
		size = start.getPreferredSize();
		start.setBounds(535, 285, size.width, size.height);
		add(start);
	}
	/**
	 * Method for actions to be performed on button click
	 * Has to be overridden from ActionListener interface
	 * parameter e is input action click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	/**
	 * Panel button to start the game when clicked
	 */
	private final JButton start;
	
	/**
	 * Panel label to display
	 */
	private final JLabel contentLabel;

}