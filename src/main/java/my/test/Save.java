/*
 * @author Will Osborne 
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
         * @param name Entered name of user from GUI
         * @param user copies GUI player instance to use Player methods
	 */
	public void write(String name, Player user)
	{
            player = user;
		/**
		 * Try-Catch block for file read by FileWriter in case of exception
		 * throw if successful name and score will be written to file 
                 * then closed
		 */
		try
		{
			FileWriter fWriter = new FileWriter(namesFile, true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write(name + ", " + player.getScore() +"\n");
			bWriter.close();
		} catch (IOException e)
		{
			System.out.println("Error creating or using scores.txt file");
		}
                numbersList.add(player.getScore());
                read();
	}

        /**
         * Updates scores.txt with sorted leaderboard
         * @param user 
         */
        public void update(Player user)
        {
            String playerName = "";
            String line = "";
            int splitIndex = 0;
            int score1 = 0;
            int score2 = 0;
            player = user;
            
            /**
             * Try-Catch block for file read and write to copy unsorted file to 
             * fileList ArrayList and sort
             */
            try
            {
                FileReader fReader = new FileReader(namesFile);
                BufferedReader bReader = new BufferedReader(fReader);
                        
                int lineCount = 0;
                String readLine = "";
                while ((readLine = bReader.readLine()) != null)
                {
                    splitIndex = readLine.indexOf(",");
                    fileList.add(readLine + "\n");
                    if (splitIndex != -1)
                    {
                        playerName = readLine.substring(0,splitIndex);
                    }
                    lineCount++;
                }
                bReader.close();
                
                String name = "";
                
                /**
                 * Parses fileList for int values solely into numbersList
                 */
                for (int index = 0; index < fileList.size(); index++)
                {
                    line = fileList.get(index);
                    splitIndex = line.indexOf(",");
                    if (splitIndex != -1)
                    {
                        name = line.substring(0,splitIndex);
                        numbersList.add(Integer.parseInt(line.substring(splitIndex+2).replace("\n", "")));
                    }
                    if(name.equals(playerName))
                    {
                        fileList.remove(fileList.size()-1);
                        fileList.add(name + ", " + player.getScore() +"\n");
                    }
                }
                
                /**
                 * Sorts int values in decreasing order
                 */
                Collections.sort(numbersList, Collections.reverseOrder());
                
                FileWriter fWriter = new FileWriter(namesFile, false);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                
                /**
                 * Compares sorted int values to whole score entries in order to sort 
                 * scores.txt based on scores
                 */
                for (int indexSorted = 0; indexSorted < numbersList.size(); indexSorted++)
                {
                    score1 = numbersList.get(indexSorted);
                    for (int indexUnsorted = 0; indexUnsorted < (fileList.size()); indexUnsorted++)
                    {
                        line = fileList.get(indexUnsorted);
                        splitIndex = line.indexOf(",");
                        if (splitIndex != -1)
                        {
                            score2 = (Integer.parseInt(line.substring(splitIndex+2).replace("\n","")));
                        }
                        if (score1 == score2)
                        {
                            bWriter.write(fileList.get(indexUnsorted));
                            break;
                        }
                    }
                    if (score1 == 0)
                    {
                        bWriter.write(fileList.get(fileList.size()-1));
                        break;
                    }
                }
                bWriter.close();
            } 
            catch (IOException e)
            {
                System.out.println("Error reading scores.txt file");
            }
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
			fReader.write("");
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
	private ArrayList<String> namesList = new ArrayList<>();
        
        /**
	 * ArrayList to store read scores as Strings for output
	 */
        private ArrayList<String> scoresList = new ArrayList<>();
        
        /**
         * ArrayList to store old file in order to update
         */
        private ArrayList<String> fileList = new ArrayList<>();
        
        /**
	 * ArrayList to store read scores as int for values
	 */
        private ArrayList<Integer> numbersList = new ArrayList<>();
        
        private Player player;
}