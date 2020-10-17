/*
 * Player.java
 * CS 321 Team 9 Fall 2020
 * Creates the Player class
 * and its actions.
 */

import java.util.*;
import java.io.*;

public class Player 
{
    /**
     * Player's function Move changes the location of the player
     * by 1 increment given a direction from 0 to 3, corresponding
     * to north (0), east (1), south (2), and west (3)
     * function makes the assumptions that Map has a function
     * getSize(), which returns the size of the map
     */
    public void Move(int dir)
    {
        switch(dir)
        {
            //case north
            case 0:
                if((location[0] + 1) < Map.getSize())
                {
                    location[0] += 1;
                }
                break;
            //case east
            case 1:
                if((location[1] + 1) < Map.getSize())
                {
                    location[1] += 1;
                }
                break;
            //case south
            case 2:
                if((location[0] - 1) > 0)
                {
                    location[0] -= 1;
                }
                break;
            //case west
            case 3:
                if((location[1] - 1) > 0)
                {
                    location[1] -= 1;
                }
                break;
        }
    }
    
    public void Description()
    {
        
    }
    
    public void Fight()
    {
        
    }
    
    public void Use()
    {
        
    }
    
    /**
     * Player's function getHealth returns how much health the player has
     */
    public int getHealth()
    {
       return health;
    }
    
    /**
     * Player's function changeHealth adds or subtracts health
     * from the player based on the parameter amount
     */
    public void changeHealth(int amount)
    {
        health += amount;
    }
    
    public void Appearance()
    {
        
    }
    
    /**
     * Player's function getScore returns the player's score
     */
    public int getScore()
    {
        return score;
    }
    
    public void changeScore()
    {
        
    }
    
    /**
     * Player's field location stores the location of
     * the player in the format {vertical, horizontal} 
     * north and east are positive, south and west are
     * negative
     */
    private int location[] = new int[2];
    /**
     * Player's field health represents how much health the player has
     */
    private int health;
    /**
     * Player's field score represents the player's score
     */
    private int score;
}
