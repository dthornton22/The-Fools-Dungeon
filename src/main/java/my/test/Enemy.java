/*
 * @author David Thornton
 * Enemy.java
 * CS 321 Team 9 Fall 2020
 * Creates the Enemy class
 */
package main.java.my.test;

/**
 * Entends entity to create an instance of an enemy
 */
public class Enemy extends Entity
{

    /**
     * Enemy's field UUID represents the enemy's unique ID
     */
    private int UUID;

    /**
     * Enemy's field activated represents whether or not the enemy is in combat
     */
    private boolean activated;

    /**
     * Enemy's function getUUID returns the enemy's UUID
     *
     * @return UUID
     */
    public int getUUID()
	{
		return UUID;
	}
}
