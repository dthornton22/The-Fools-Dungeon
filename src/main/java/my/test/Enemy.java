/*
 * @author Laura Estep
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

	private int UUID, level_number;
	private boolean activated;

    /**
     *
     * @return
     */
    public int getUUID()
	{
		return UUID;
	}
}
