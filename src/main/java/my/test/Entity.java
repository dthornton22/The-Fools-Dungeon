/*
 * Entities.java
 * CS 321 Team 9 Fall 2020
 * Creates the Enemy class
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

public abstract class Entity
{
	private int health, score;
	private int location[] = new int[2];
	private String name;

	public int getHealth()
	{
		return health;
	}

	public int getScore()
	{
		return score;
	}

	public int[] getLocation()
	{
		return location;
	}

        /**
	 * Entity's function Move changes the location of the entity by 1 increment
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

	public void setScore(int newScore)
	{
		score = newScore;
	}

	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
}
