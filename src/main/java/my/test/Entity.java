/*
 * Entities.java
 * CS 321 Team 9 Fall 2020
 * Creates the Enemy class
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

public abstract class Entity
{

	private int health, score, UUID, index, level_number;
	private int location[] = new int[2];
	private boolean activated;
	private String name;

	public int getHealth()
	{
		return health;
	}

	public int getScore()
	{
		return score;
	}

	public int getIndex()
	{
		return index;
	}

	public String getName()
	{
		return name;
	}

	public int getUUID()
	{
		return UUID;
	}

	public int[] getLocation()
	{
		return location;
	}

	public void setName(String newName)
	{
		name = newName;
	}

	public void setScore(int delta)
	{
		score += delta;
	}

	public void setHealth(int delta)
	{
		health += delta;
	}

	public void setIndex(int newIndex)
	{
		index = newIndex;
	}
}
