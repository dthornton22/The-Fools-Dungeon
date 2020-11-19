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

public class Save
{
	/**
	 * Save Constructor to allow object creation for other classes
	 */
	public Save()
	{
            
	}

	/**
	 * Writes input name to scores.txt file in main directory Will create if file
	 * does not exist and append if it does parameter name string to write
	 */
	public void write(String name, Player user)
	{
            Player player = user;
		/**
		 * Try-Catch block for file read by FileWriter in case of exception
		 * throw if successful name and score will be written to file 
                 * then closed
		 */
		try
		{
			FileWriter fWriter = new FileWriter(namesFile, true);
			BufferedWriter writer = new BufferedWriter(fWriter);
			writer.write(name + ", " + player.getScore() +"\n");
			writer.close();
		} catch (IOException e)
		{
			System.out.println("Error creating or using scores.txt file");
		}
                numbersList.add(player.getScore());
                read();
	}

	/**
	 * Reads scores.txt file for all listed names and copies into ArrayList for
	 * later use parameter name string to write
	 */
	public void read()
	{
		/**
		 * Try-Catch block for file read by FileReader in case of exception
		 * throw if successful names will be read and copied to names 
		 * ArrayList then scores will copied to scores ArrayList closed
		 */
		try
		{
			FileReader fReader = new FileReader(namesFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String readLine = "";
			while ((readLine = bReader.readLine()) != null)
			{
                            int splitIndex = readLine.indexOf(",");
                            String name = "";
                            String score = "";
                            if (splitIndex != -1)
                            {
                                name = readLine.substring(0,splitIndex);
                                score  = readLine.substring(splitIndex+2);
                            }
                            namesList.add(name);
                            scoresList.add(score);
			}
			bReader.close();
		} catch (IOException e)
		{
			System.out.println("Error reading scores.txt file");
		}
	}
        /**
         * Reads scores.txt to return name at given index
         * @param index
         * @return name at index
         */
        public String getName(int index)
        {
            Save newSave = new Save();
            newSave.read();
            return namesList.get(index);
        }
        
        public int namesSize()
        {
            return namesList.size();
        }
        
        /**
         * Reads scores.txt to return score at given index
         * @param index
         * @return score at index
         */
        public String getScore(int index)
        {
            Save newSave = new Save();
            newSave.read();
            return scoresList.get(index);
        }
        /**
         * Checks number of lines in scores.txt 
         * and clears file if greater than or equal to 6
         */
        public void lineCheck()
        {
                /**
		 * Try-Catch block for file read by FileReaderr in case of exception
		 * throw if successful scores.txt will be cleared out if more than
		 * 6 lines then closed
		 */
                try
		{
                    BufferedReader lineCheck = new BufferedReader(new FileReader(namesFile));
                    int lines = 0;
                    while(lineCheck.readLine() != null)
                    {
                        lines++;
                    }
                    if (lines >= 6)
                    {
                        clear();
                    }
                    lineCheck.close();
		} catch (IOException e)
		{
			System.out.println("Error checking scores.txt file");
		}
        }
        
        /**
	 * Clears names from scores.txt file parameter name string to write
	 */
	private void clear()
	{
		/**
		 * Try-Catch block for file read by FileWriter in case of exception
		 * throw if successful names will be deleted from file and closed
		 */
		try
		{
			FileWriter fReader = new FileWriter(namesFile, false);
			fReader.write(" ");
			fReader.close();
		} catch (IOException e)
		{
			System.out.println("Error clearing scores.txt file");
		}
	}
        
	/**
	 * File path for where the names should be stored
	 */
	private final File namesFile = new File("src/main/resources/scores.txt");

	/**
	 * ArrayList to store read names
	 */
	private final ArrayList<String> namesList = new ArrayList<>();
        
        /**
	 * ArrayList to store read scores as Strings for output
	 */
        private final ArrayList<String> scoresList = new ArrayList<>();
        
        /**
	 * ArrayList to store read scores as int for values
	 */
        private final ArrayList<Integer> numbersList = new ArrayList<>();
}
