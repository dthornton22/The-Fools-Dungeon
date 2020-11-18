/*
 * Entities.java
 * CS 321 Team 9 Fall 2020
 * Creates the Enemy class
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

public abstract class Entity
{
        /**
	 * Entity's function getHealth gets the entity's health
         *
         * @return health
	 */
	public int getHealth()
	{
		return health;
	}
        /**
	 * Entity's function getScore gets the entity's score
         *
         * @return score
	 */
	public int getScore()
	{
		return score;
	}
        /**
	 * Entity's function getLocation gets the entity's location
         *
         * @return location
	 */
	public int[] getLocation()
	{
		return location;
	}
        /**
	 * Entity's function move changes the location of the entity by 1 increment
	 * given a direction from 0 to 3, corresponding to east (0), north (1), west
	 * (2), and south (3) function makes the assumptions that Map has a function
	 * map1.isWall(int vert, int hor), which returns whether the block at the
	 * location is a wall or in some other way restricted
	 *
	 * @param dir
	 */
	public boolean move(int dir)
	{
		Map map1 = new Map();
		switch (dir)
		{
			//case east
			case 0:
                            if (location[1] == 7)
                            {
                                return false;
                            }
                            else if (!map1.isWall(location[0], (location[1] + 1)))
                            {
				location[1] += 1;
                                return true;
                            }
                            break;
			//case north
			case 1:
				if (location[0] == 0)
                                {
                                    return false;
                                }
                                else if (!map1.isWall((location[0] - 1), location[1]))
				{
                                    location[0] -= 1;
                                    return true;
				}
				break;
			//case west
			case 2:
				if (location[1] == 0)
                                {
                                    return false;
                                }
                                else if (!map1.isWall(location[0], (location[1] - 1)))
				{
					location[1] -= 1;
                                        return true;
				}
				break;
			//case south
			case 3:
                                if (location[0] == 7)
                                {
                                    return false;
                                }
                                else if (!map1.isWall((location[0] + 1), location[1]))
                                {
                                    location[0] += 1;
                                    return true;
                                }
				break;
		}
                return false;
	}
        /**
	 * Entity's setScore sets the entity's score
         *
         * @param newScore
	 */
	public void setScore(int newScore)
	{
		score = newScore;
	}
        /**
	 * Entity's setHealth sets the entity's health
         *
         * @param newHealth
	 */
	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
        /**
	 * Entity's fields health and score
	 */
	private int health, score;
        /**
	 * Entity's field location (first entry is vertical, second is horizontal)
	 */
	private int location[] = new int[2];
}
