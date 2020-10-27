/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leaderboard1;
import java.util.Scanner;

/**
 *
 * @author hannahwallace
 */
public class Leaderboard {
    Player players[]= new Player[10];
    
    public Player EnterPlayer(int score) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter name: ");
        String id=input.nextLine();
        Player player1=new Player();
        player1.Name=id;
        player1.Score=score;
        return player1;
    }
    
    public Player FindMin(Player[] array) {
        Player min=new Player();
        int minscore=array[0].Score;
        for (int i=0; i<array.length; i++) {
            if (array[i].Score<minscore){
                minscore= array[i].Score;
                min=array[i];
                min.Index=i;
            }    
        }
        return min;
    }
    
    
    public void AddPlayer(Player player1) {
        Player min=FindMin(players);
        for (int i=0; i<players.length; i++) {
            if (players[i]==null) {
                players[i]=player1;
                player1.Index=i;
            }
            if (player1.Score<=min.Score){
                players[min.Index]=player1;
            }
        }
    }
    
    public void PrintLeaderboard() {
        System.out.println("Leaderboard");
        System.out.printf("%-4s %30s\n", "Name", "Score");
        for (int i=0; i<players.length; i++) {
            System.out.printf("%-4s %30i\n", players[i].Name, players[i].Score);
        } 
    }
}
