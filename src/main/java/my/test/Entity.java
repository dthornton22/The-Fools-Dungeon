/*
 * @author David Thornton
 * Entity.java
 * CS 321 Team 9 Fall 2020
 * Creates the Entity class
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

/**
 * Parent class for player and enemy
 */
public abstract class Entity
{
        /**
	 * Entity's function fight executes combat between the user and an enemy
         *
         * @param enemy, player
         * @return boolean
	 */
        /*public boolean fight(Enemy enemy, Player player)
        {       
            while(player.getHealth()!=0 && enemy.getHealth()!=0)
            {
                switch playerChoice:
                    case 0:
                        //fight
                        break;
                    case 1:
                        //heal
                        break;
            }

            if(enemy.getHealth() == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }*/
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
	private int health = 100;
        private int score = 0;
        /**
	 * Entity's field location (first entry is vertical, second is horizontal)
	 */
	private int location[] = new int[2];
        /**
	 * Entity's field playerChoice represents whether the player chose
         * to attack or to heal in a fight, with 0 being attack and 1 being heal
	 */
        private int playerChoice;
}
