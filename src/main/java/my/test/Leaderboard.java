/*
 * LeaderBoard.java
 * CS 321 Team 9 Fall 2020
 * Creates the LeaderBoard class for score calculation
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;
import java.util.Scanner;


public class Leaderboard 
{
        Player players[] = new Player[10];
        
	/**
	 * Leaderboard's function findMin takes an array of players and returns
         * the player with the lowest score
	 */
	private Player findMin(Player[] array) 
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
	 * Leaderboard's function addPlayer asks for the user's name and sorts
         * their Player into the leaderboard based on their score
	 */
	public void addPlayer(Player player1) 
        {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter name: ");
                String id = input.nextLine();
                player1.setName(id);
                int score=player1.getScore();
		Player min = findMin(players);
                if (score>min.getScore()) 
                {
                        for (int i = 0; i < players.length; i++) 
                        {
                                if (players[i]==null) 
                                {
                                        players[i] = player1;
                                        player1.setIndex(i);
                                        break;
                                }
                                if (score>=players[i].getScore())
                                {       
                                        for (int j = i; j < (players.length-i); j++)
                                        {
                                                swapPlayers(player1, players[j], players);
                                                players[j].setIndex(j);
                                        }
                                        break;
                                }
                        }
		}
                if (score == min.getScore())
                {
			players[min.getIndex()] = player1;
                        player1.setIndex(min.getIndex());
                        min = player1;
                }
                else 
                {
                        System.out.println("Score was not high enough for leaderboard.");
                }
	}
        
        private void swapPlayers(Player x, Player y) 
        {
                Player temp = y;
                x.setIndex(y.getIndex());
                players[y.getIndex()] = x;
                x = temp;
        }
	
	public void printLeaderboard() 
        {
		System.out.println("Leaderboard");
		System.out.printf("%-4s %30s\n", "Name", "Score");
		for (int i = 0; i < players.length; i++) 
                {
			System.out.printf("%-4s %30i\n", players[i].getName(), players[i].getScore());
		} 
	}
        
        public void loadLeaderboard()
        {
            
        }
        
        public void saveLeaderboard()
        {
                
        }
}
