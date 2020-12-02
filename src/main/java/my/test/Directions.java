/*
 * @author ???, move() by Laura Estep
 * Directions.java
 * CS 321 Team 9 Fall 2020
 * Creates the Directions class
 */
package main.java.my.test;

/**
 * Handles interacting with the map
 */
public class Directions
{

    /**
     * Directions' enum Direction provides a shortcut for the 4 directions
     */
    public enum Direction
    {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * Direction's function getAnyDirection returns the direction
     *
     * @return anyDirection
     */
    public Direction getAnyDirection()
    {
	return anyDirection;
    }

    /**
     * Direction's function setAnyDirection sets the direction to the parameter
     *
     * @param anyDirection
     */
    public void setAnyDirection(Direction anyDirection)
    {
	this.anyDirection = anyDirection;
    }

    /**
     * Direction's function move handles movement given a direction
     *
     * @param newDirection
     */
    public void move(Direction newDirection)
    {
	int mylocation[] = new int[2];
	Map anyMap = new Map();
	switch (newDirection)
	{
            case RIGHT: // East (D)
		if (!anyMap.isWall(mylocation[0], (mylocation[1] + 1)))
		{
                    mylocation[1] += 1;
		}
		break;
            case UP: // North (W)
		if (!anyMap.isWall((mylocation[0] - 1), mylocation[1]))
		{
                    mylocation[0] += 1;
		}
		break;
            case LEFT: // West (A)
		if (!anyMap.isWall(mylocation[0], (mylocation[1] + 1)))
		{
                    mylocation[1] += 1;
		}
		break;
            case DOWN: // South (S)
		if (!anyMap.isWall((mylocation[0] - 1), mylocation[1]))
		{
                    mylocation[0] += 1;
		}
		break;
	}
    }
    
    /*
     * Directions' field anyDirection represents the current direction
     */
    private Direction anyDirection;
}
