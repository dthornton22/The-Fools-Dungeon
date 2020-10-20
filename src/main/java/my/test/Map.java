/*
 * Map.java
 * CS 321 Team 9 Fall 2020
 * Creates the Map class
 */
package main.java.my.test;	   

public class Map {
	
	public static void main (String[] args){
		/**
		 * Creates Frame and Panel instances to construct
		 * application on run
		 */
		Frame dungeonWindow = new Frame();
		ContentPanel dungeonPanel = new ContentPanel();
		dungeonWindow.add(dungeonPanel);
		dungeonWindow.pack();
		dungeonWindow.setVisible(true);
	}
	
	/**
	 * Constructs the map of the game with its grid
	 */
	public Map(){
		/**
		 * Initializes map grid with arbitrary constant square boundaries
		 */
		mapMatrix = new int[MAPBOUNDS][MAPBOUNDS];
	}
	
	/**
	 * Map size to keep player within grid boundaries
	 */
	public int getSize(){
		return(MAPBOUNDS);
	}
	
	/**
	 * Create obstacles at specific locations for map
	 */
	public boolean obstacle(){
		return false;
	}
	/**
	 * Map Grid for playable area
	 */
	private final int[][] mapMatrix;
	
	/**
	 * Map grid constraint constant for map size
	 */
	private final int MAPBOUNDS = 10;
}