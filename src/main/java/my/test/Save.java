/*
 * Save.java
 * CS 321 Team 9 Fall 2020
 * Creates the Save class
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

/**
 * Imports to allow file reading and writing and ArrayList to store read
 * contents
 */
import java.io.*;
import java.util.*;

public class Save {
    /**
     * Save Constructor to allow object creation for other classes
     */
    public Save() {

    }
    
    /**
     * Writes input name to names.txt file in main directory
     * Will create if file does not exist and append if it does
     * parameter name string to write
     */
    public void write(String name) {
        /**
        * Try-Catch block for file read by FileWriter in case of 
        * exception throw
        * if successful name will be written to file and closed
        */
        try {
            FileWriter fWriter = new FileWriter(namesFile, true);
            BufferedWriter writer = new BufferedWriter(fWriter);
            writer.write(name + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating or using names.txt file");
        }

    }
    
    /**
     * Reads names.txt file for all listed names and copies into ArrayList
     * for later use
     * parameter name string to write
     */
    public void read() {
        /**
        * Try-Catch block for file read by FileReaderr in case of 
        * exception throw
        * if successful names will be read and copied to ArrayList then closed
        */
        try {
            FileReader fReader = new FileReader(namesFile);
            BufferedReader bReader = new BufferedReader(fReader);
            String readLine = "";
            while ((readLine = bReader.readLine()) != null) {
                readNames.add(readLine);
            }
            bReader.close();
        } catch (IOException e) {
            System.out.println("Error reading names.txt file");
        }
    }
    
     /**
     * Clears names from names.txt file
     * parameter name string to write
     */
    public void clear() {
        /**
        * Try-Catch block for file read by FileWriter in case of 
        * exception throw
        * if successful names will be deleted from file and closed
        */
        try {
            FileWriter fReader = new FileWriter(namesFile, false);
            fReader.write(" ");
            fReader.close();
        } catch (IOException e) {
            System.out.println("Error reading names.txt file");
        }
    }
    
    /**
     * File path for where the names should be stored
     */
    private File namesFile = new File("names.txt");
    
    /**
     * ArrayList to store read names
     */
    private ArrayList<String> readNames = new ArrayList<>();
}
