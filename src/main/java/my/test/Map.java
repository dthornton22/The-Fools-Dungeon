/*
 * @author Will Osborne
 * Map.java
 * CS 321 Team 9 Fall 2020
 * Creates the Map class
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

/**
 * Runner class, also contains implementation for how the player can interact
 * with the map
 */
public class Map
{

	public static void main(String[] args)
	{
		/**
		 * Creates Frame and Panel instances to construct application on run
		 */
		Frame dungeonWindow = new Frame();

		Player user = new Player();
		user.setScore(0);
		user.setHealth(100);
		Enemy guard = new Enemy();
		Item object = new Item();
		ContentPanel dungeonPanel = new ContentPanel(user, guard, object);
		dungeonWindow.add(dungeonPanel);
		dungeonWindow.pack();
		dungeonWindow.setVisible(true);
	}

	/**
	 * Constructs the map of the game with its grid
	 */
	public Map()
	{
		/**
		 * Initializes map grid with arbitrary constant square boundaries
		 */
		//mapMatrix = new int[MAPBOUNDS][MAPBOUNDS];
	}

	/**
	 * Map size to keep player within grid boundaries
	 *
	 * @return
	 */
	public int getSize()
	{
		return (MAPBOUNDS);
	}

	/**
	 * Create obstacles at specific locations for map according to grid
	 *
	 * @param x
	 * @param y
	 * @return based on grid value
	 */
	public boolean isWall(int x, int y)
	{
		if ((mapMatrix[x][y]) == 1)
		{
			return true;
		} else
		{
			return false;
		}
	}
	/**
	 * Map Grid for playable area with obstacles
	 */
	private final int[][] mapMatrix =
	{
		{
			0, 0, 1, 0, 1, 0, 0, 1
		},
		{
			1, 0, 1, 0, 0, 0, 1, 0
		},
		{
			1, 0, 0, 1, 0, 0, 1, 0
		},
		{
			1, 0, 0, 0, 0, 1, 1, 0
		},
		{
			1, 0, 1, 0, 0, 0, 0, 0
		},
		{
			1, 0, 0, 1, 1, 0, 0, 1
		},
		{
			1, 0, 0, 0, 1, 1, 0, 1
		},
		{
			0, 0, 1, 0, 0, 1, 0, 0
		}
	};

	/**
	 * Map grid constraint constant for map size
	 */
	private final int MAPBOUNDS = 8;
}
