/*
 * @author Will Osborne
 * Frame.java
 * CS 321 Team 9 Fall 2020
 * Creates the Frame class
 */
package main.java.my.test;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.Toolkit;

/**
 * Extends JFrame to create application window
 */
public class Frame extends JFrame
{

	/**
	 * Constructs the application frame
	 */
	public Frame()
	{
		/**
		 * adds title and closing functionality to window
		 */
		super("The Fool's Dungeon");
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
		setLayout(flowLayout);
                setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 950) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 680) / 2);    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
