/*
 * Player.java
 * CS 321 Team 9 Fall 2020
 * Creates the Player class
 * and its actions.
 */

import java.util.*;
import java.io.*;

public class Player 
{
	/**
	 * Player's function Move changes the location of the player
	 * by 1 increment given a direction from 0 to 3, corresponding
	 * to east (0), north (1), west (2), and south (3)
	 * function makes the assumptions that Map has a function
	 * isWall(int vert, int hor), which returns whether the block at the
	 * location is a wall or in some other way restricted
	 */
	public void Move(int dir)
	{
		switch(dir)
		{
			//case east
			case 0:
				if(!isWall(location[0], (location[1] + 1)))
				{
					location[1] += 1;
				}
				break;
			//case north
			case 1:
				if(!isWall((location[0] - 1), location[1]))
				{
					location[0] += 1;
				}
				break;
			//case west
			case 2:
				if(!isWall(location[0], (location[1] + 1)))
				{
					location[1] += 1;
				}
				break;
			//case south
			case 3:
				if(!isWall((location[0] - 1), location[1]))
				{
					location[0] -= 1;
				}
				break;
		}
	}
	
	public void Description()
	{
		
	}
	
	public void Fight()
	{
		
	}
	
	public void Use()
	{
		
	}
	
	/**
	 * Player's function getHealth returns how much health the player has
	 */
	public int getHealth()
	{
	   return health;
	}
	
	/**
	 * Player's function changeHealth adds or subtracts health
	 * from the player based on the parameter amount
	 */
	public void changeHealth(int amount)
	{
		health += amount;
	}
	
	public void Appearance()
	{
		
	}
	
	/**
	 * Player's function getScore returns the player's score
	 */
	public int getScore()
	{
		return Score;
	}
	
	public void changeScore()
	{
		
	}
        
        /**
	 * Player's function getName returns the player's name
	 */
        public String getName()
        {
            return Name;
        }
	
	/**
	 * Player's field location stores the location of
	 * the player in the format {vertical, horizontal} 
	 * west and south are positive directions, in accordance
	 * with the representation of the map as a matrix
	 */
	private int location[] = new int[2];
	/**
	 * Player's field health represents how much health the player has
	 */
	private int health;
	/**
	 * Player's field Score represents the player's score
	 */
	private int Score;
        /**
	 * Player's field Name represents the player's name
	 */
        private String Name;
        /**
	 * Player's field index represents ??? what is this hannah
	 */
        private int Index;
}
