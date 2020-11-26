/*
 * @author Hannah Wallace
 * Leaderboard.java
 * CS 321 Team 9 Fall 2020
 * Creates the LeaderBoard class for score calculation
 */
package main.java.my.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Displays the leaderboard from the saved file
 */
public class Leaderboard
{

	private Player playersArray[] = new Player[10];
	private ArrayList<Player> players = new ArrayList();

	/**
	 * Leaderboard's function addPlayerArray receives a new player and sorts
	 * them into the leaderboard based on their score
	 */
	public void addPlayer(Player player1)
	{
		int score = player1.getScore();
		Player min = findMin();
		if (score > min.getScore())
		{
			for (int i = 0; i < players.size(); i++)
			{
				Player temp = players.get(i);
				if (score > temp.getScore())
				{
					for (int j = i; j < (players.size() - i); j++)
					{
						swapPlayers(player1, (players.get(j)), j);
					}
					break;
				}
			}
		} else
		{
			players.add(player1);
		}
	}

	/**
	 * Leaderboard's function addPlayerArray receives a new player and sorts
	 * them into the leaderboard based on their score (uses array instead of
	 * ArrayList)
	 */
	public void addPlayerArray(Player player1)
	{
		int score = player1.getScore();
		Player min = findMinArray(playersArray);
		if (score > min.getScore())
		{
			for (int i = 0; i < playersArray.length; i++)
			{
				if (playersArray[i] == null)
				{
					playersArray[i] = player1;
					player1.setIndex(i);
					break;
				}
				if (score >= playersArray[i].getScore())
				{
					for (int j = i; j < (playersArray.length - i); j++)
					{
						swapPlayersArray(player1, playersArray[j]);
						playersArray[j].setIndex(j);
					}
					break;
				}
			}
		}
		if (score == min.getScore())
		{
			playersArray[min.getIndex()] = player1;
			player1.setIndex(min.getIndex());
			min = player1;
		} else
		{
			System.out.println("Score was not high enough for leaderboard.");
		}
	}

	/**
	 * Leaderboard's function enterPlayer asks for the user's name and sets
	 * their name to the user's input
	 */
	public void enterPlayer(Player player1)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name: ");
		String id = input.nextLine();
		player1.setName(id);
	}

	/**
	 * Leaderboard's function swapPlayersArray swaps the places of two players
	 * in the playersArray
	 */
	private void swapPlayersArray(Player x, Player y)
	{
		Player temp = y;
		x.setIndex(y.getIndex());
		playersArray[y.getIndex()] = x;
		x = temp;
	}

	/**
	 * Leaderboard's function swapPlayers swaps the places of two players in the
	 * players ArrayList
	 */
	private void swapPlayers(Player x, Player y, int index)
	{
		Player temp = y;
		x.setIndex(y.getIndex());
		players.set(y.getIndex(), x);
		x = temp;
		y.setIndex(index);
	}

	/**
	 * Leaderboard's function findMinArray takes an array of players and returns
	 * the player with the lowest score
	 */
	private Player findMinArray(Player[] array)
	{
		Player min = new Player();
		int minscore = array[0].getScore();
		for (int i = 0; i < array.length; i++)
		{
			if (array[i].getScore() < minscore)
			{
				minscore = array[i].getScore();
				min = array[i];
				min.setIndex(i);
			}
		}
		return min;
	}

	/**
	 * Leaderboard's function findMin takes looks through the ArrayList of
	 * Players and returns the player with the lowest score
	 */
	private Player findMin()
	{
		Player min = players.get(0);
		for (int i = 0; i < players.size(); i++)
		{
			Player temp = players.get(i);
			if (temp.getScore() < min.getScore())
			{
				min = temp;
			}
		}
		return min;
	}

	/**
	 * Leaderboard's function printLeaderboardArray prints the array of players
	 * on the leaderboard
	 */
	public void printLeaderboardArray()
	{
		System.out.println("Leaderboard");
		System.out.printf("%-4s %30s\n", "Name", "Score");
		for (int i = 0; i < playersArray.length; i++)
		{
			System.out.printf("%-4s %30i\n", playersArray[i].getName(), playersArray[i].getScore());
		}
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers()
	{
		return playersArray;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players)
	{
		this.players = players;
	}
}
