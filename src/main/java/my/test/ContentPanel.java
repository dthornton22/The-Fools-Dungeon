/*
 * ContentPanel.java
 * CS 321 Team 9 Fall 2020
 * Creates the ContentPanel class for the Map Class to build GUI
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

/**
 * Import statements that allow graphical content and 
 * functionality in class
 */
import java.io.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Extends JPanel to represent panel for GUI items
 * Implements ActionListener to allow action based on user button click
 */
public class ContentPanel extends JPanel implements ActionListener{
 
	/**
	 * Constructs the panel of the application where the
	 * GUI items will be and the user will interact with
	 */
	public ContentPanel(){
		/**
		 * Panel dimensions and attributes
		 * layout null so items determine placement 
		 * individually
		 * arbitrary initial dimensions on personal computer
		 */
		Dimension dim = new Dimension(900, 600);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setLayout(null);
		setBackground(Color.white);
		
                /**
                 * Try-Catch block for file read by ImageIO in case of 
                 * exception throw
                 */
                try{
                    backgroundImage = ImageIO.read(new File("assets/map silhouette.png"));
                } catch (IOException e) {
                    System.out.println("Incorect Image");
                }
                
		/**
		 * Label1 placement and attributes
		 * add to panel for display
		 * arbitrary initial dimensions on personal computer
		 */
		label1 = new JLabel("Dungeon Crawler");
		Dimension size = label1.getPreferredSize();
		label1.setBounds(80, 240, size.width, size.height);
		add(label1);
                
                /**
		 * Label2 placement and attributes
		 * add to panel for display
		 * arbitrary initial dimensions on personal computer
		 */
		label2 = new JLabel("Welcome to the Dungeon.");
		size = label2.getPreferredSize();
		label2.setBounds(45, 255, size.width, size.height);
		add(label2);
                
                /**
		 * Label3 placement and attributes
		 * add to panel for display
		 * arbitrary initial dimensions on personal computer
		 */
                label3 = new JLabel("Enter your name for the scoreboard.");
		size = label3.getPreferredSize();
		label3.setBounds(10, 270, size.width, size.height);
		add(label3);
		/**
		 * Button placement and attributes
		 * add to panel for display
		 * arbitrary initial dimensions on personal computer
                 * left in for possible later use
		 */
                /*enter = new JButton("Enter");
                enter.setBounds(80, 315, size.width, size.height);
                enter.addActionListener(this);
                add(enter);*/
                
                /**
                 * Text Field placement and attributes
                 * add to panel for display and function to take user
                 * input and save to file
                 * arbitrary initial dimensions on personal computer
                 */
		nameEntry = new JTextField(20);
		nameEntry.addActionListener(this);
		size = nameEntry.getPreferredSize();
		nameEntry.setBounds(25, 285, size.width, size.height);
		add(nameEntry);
	}
        
	/**
         * References super method and overrides functionality
         * Draws the image onto screen with dimensions
         * parameter drawer uses Graphics class to draw image
         */
        @Override
        public void paintComponent(Graphics drawer) {
            super.paintComponent(drawer);
            drawer.drawImage(backgroundImage, 300, 0, 600, 600, this);
        }
        
	/**
	 * Method for actions to be performed on text field enter
	 * Has to be overridden from ActionListener interface
	 * parameter e is input action
	 */
        @Override
	public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nameEntry){
                String input = nameEntry.getText();
                nameEntry.selectAll();
                nameSave = new Save();
                nameSave.write(input);
            }
	}
        
        //private final JButton enter;
	/**
	 * Panel button to nameEntry the game when clicked
	 */
	private final JTextField nameEntry;
        
	/**
	 * Panel labels to display
	 */
	private final JLabel label1;
        private final JLabel label2;
        private final JLabel label3;
        
        /**
	 * Image variable to hold background Image
	 */
        private Image backgroundImage;
        
        /**
	 * Save variable to allow save of user names
	 */
        Save nameSave;
}