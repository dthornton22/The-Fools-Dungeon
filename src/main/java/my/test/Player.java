/*
 * Player.java
 * CS 321 Team 9 Fall 2020
 * Creates the Player class
 * and its actions.
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

public class Player extends Entity
{
	/**
	 * Player's function getName returns the player's name
	 *
	 * @return
	 */
	public String getName()
	{
            return name;
	}
	/**
	 * Player's function setName modifies the player's name
	 *
	 * @param newName
	 */
	public void setName(String newName)
	{
            name = newName;
	}
	/**
	 * Player's function getIndex returns the player's index
	 *
	 * @return
	 */
	public int getIndex()
	{
            return index;
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
	 * Player's field Name represents the player's name
	 */
	private String name;
	/**
	 * Player's field index represents the player's position on the leaderboard
	 */
	private int index;
        /**
	 * Player's field gear represents the armor and the sword the player holds
	 */
        private Item gear[] = new Item[2];
        /**
	 * Player's field potions represents the potions (up to 10) the player has
	 */
        private Item potions[] = new Item[10];
}
