/*
 * LeaderBoard.java
 * CS 321 Team 9 Fall 2020
 * Creates the LeaderBoard class for score calculation
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;
import java.util.Scanner;


public class Leaderboard {
	Player players[]= new Player[10];
	
	public Player EnterPlayer(int score) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter name: ");
		String id=input.nextLine();
		Player player1=new Player();
		player1.setName(id);
		player1.changeScore(score);
		return player1;
	}
	
	public Player FindMin(Player[] array) {
		Player min=new Player();
		int minscore=array[0].getScore();
		for (int i=0; i<array.length; i++) {
			if (array[i].getScore()<minscore){
				minscore= array[i].getScore();
				min=array[i];
				min.setIndex(i);
			}	
		}
		return min;
	}
	
	
	public void AddPlayer(Player player1) {
		Player min=FindMin(players);
		for (int i=0; i<players.length; i++) {
			if (players[i]==null) {
				players[i]=player1;
				player1.setIndex(i);
			}
			if (player1.getScore()<=min.getScore()){
				players[min.getIndex()]=player1;
			}
		}
	}
	
	public void PrintLeaderboard() {
		System.out.println("Leaderboard");
		System.out.printf("%-4s %30s\n", "Name()", "Score()");
		for (int i=0; i<players.length; i++) {
			System.out.printf("%-4s %30i\n", players[i].getName(), players[i].getScore());
		} 
	}
}
