/*
 * Player.java
 * CS 321 Team 9 Fall 2020
 * Creates the Player class
 * and its actions.
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

public class Player
{

	/**
	 * Player's function Move changes the location of the player by 1 increment
	 * given a direction from 0 to 3, corresponding to east (0), north (1), west
	 * (2), and south (3) function makes the assumptions that Map has a function
	 * map1.isWall(int vert, int hor), which returns whether the block at the
	 * location is a wall or in some other way restricted
	 *
	 * @param dir
	 */
	public void Move(int dir)
	{
		Map map1 = new Map();
		switch (dir)
		{
			//case east
			case 0:
				if (!map1.isWall(location[0], (location[1] + 1)))
				{
					location[1] += 1;
				}
				break;
			//case north
			case 1:
				if (!map1.isWall((location[0] - 1), location[1]))
				{
					location[0] += 1;
				}
				break;
			//case west
			case 2:
				if (!map1.isWall(location[0], (location[1] + 1)))
				{
					location[1] += 1;
				}
				break;
			//case south
			case 3:
				if (!map1.isWall((location[0] - 1), location[1]))
				{
					location[0] -= 1;
				}
				break;
		}
	}

	/**
	 * Player's function getHealth returns how much health the player has
	 *
	 * @return
	 */
	public int getHealth()
	{
		return health;
	}

	/**
	 * Player's function changeHealth adds or subtracts health from the player
	 * based on the parameter amount
	 *
	 * @param amount
	 */
	public void changeHealth(int amount)
	{
		health += amount;
	}

	/**
	 * Player's function getScore returns the player's score
	 *
	 * @return
	 */
	public int getScore()
	{
		return Score;
	}

	public void changeScore(int newScore)
	{
		Score = newScore;
	}

	/**
	 * Player's function getName returns the player's name
	 *
	 * @return
	 */
	public String getName()
	{
		return Name;
	}

	/**
	 * Player's function setName modifies the player's name
	 *
	 * @param newName
	 */
	public void setName(String newName)
	{
		Name = newName;
	}

	/**
	 * Player's function getIndex returns the player's index
	 *
	 * @return
	 */
	public int getIndex()
	{
		return Index;
	}

	/**
	 * Player's function setIndex modifies the player's index
	 *
	 * @param newIndex
	 */
	public void setIndex(int newIndex)
	{
		Index = newIndex;
	}
	/**
	 * Player's field location stores the location of the player in the format
	 * {vertical, horizontal} west and south are positive directions, in
	 * accordance with the representation of the map as a matrix
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
