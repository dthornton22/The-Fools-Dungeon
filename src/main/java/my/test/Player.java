/*
 * @author David Thornton
 * Player.java
 * CS 321 Team 9 Fall 2020
 * Creates the Player class
 * and its actions.
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;


/**
 * Extends Entity to create an instance of player (the end user)
 */
public class Player extends Entity
{
	/**
	 * Player's function getName returns the player's name
	 *
	 * @return name
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
	 * @return index
	 */
	public int getIndex()
	{
            return index;
	}
	/**
	 * Player's function setIndex modifies the player's position on the leaderboard
	 *
	 * @param newIndex
	 */
	public void setIndex(int newIndex)
	{
            index = newIndex;
	}
        /**
	 * Player's function usePotion increases the player's health and
	 * removes the potion from the array of potions
         *
	 * @param index
	 */
        public void usePotion(int index)
        {
            if(maxArray >= 1)
            {
                this.setHealth(this.getHealth() + potions[index].getHealthIncrease());
                maxArray -= 1;
            }
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
	 * Player's field sword represents the sword the player holds
	 */
        private Item sword = new Item();
        /**
	 * Player's field potions represents the potions (up to MAX_INV) the player has
	 */
        private Item potions[] = new Item[MAX_INV];
        /**
	 * Player's constant field MAX_INV represents how many potions the player can hold
	 */
        private static final int MAX_INV = 10;
        /**
	 * Player's field maxArray represents how many potions the player currently has
	 */
        private int maxArray;
}
