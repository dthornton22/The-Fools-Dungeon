/*
 * Enemy.java
 * CS 321 Team 9 Fall 2020
 * Creates the Enemy class
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

public class Enemy extends Entity
{
    private int UUID, level_number;
    private boolean activated;

    public int getUUID()
    {
	return UUID;
    }
}
