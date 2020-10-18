/*
 * Frame.java
 * CS 321 Team 9 Fall 2020
 * Creates the Frame class
 */
package main.java.my.test;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 * Extends JFrame to create application window
 */
public class Frame extends JFrame {

    /**
    * Constructs the application frame
    */
    public Frame() {
        /**
         * adds title and closing functionality to window
         */
        super("Dungeon Crawler");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
