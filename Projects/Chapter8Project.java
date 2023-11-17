package com.company;
import java.awt.*;
import java.util.*;

public class Chapter8Project {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        String result = "";
        int computer = 0;
        computer = (int)(Math.random() * 5);

        System.out.println("Please enter your choice (Rock, Paper, Scissors, Lizard, or Spock): ");
        userInput = input.nextLine();
        result = checkWin(userInput, computer);

        System.out.println(result);
    }
    public static String checkWin (String a, int computer) {
        String[][] arr1 = {{"Rock", "Lizard", "Scissors"}, {"Paper", "Spock", "Rock"}, {"Scissors", "Lizard", "Paper"},
                {"Lizard", "Spock", "Paper"},{"Spock", "Scissors", "Rock"}};
        String result = "";
        int user = -1;
        for (int i = 0; i < 5; i++) {
            if (a.equalsIgnoreCase(arr1[i][0]))
                user = i;
        }
        System.out.println(arr1[computer][0]);
        for (int k = 1; k < 3; k++) {
            if (arr1[computer][0] == arr1[user][k]) {
                result = "You win. " + arr1[user][0] + " beats " + arr1[computer][0] + ".";
            }
            if (arr1[user][0] == arr1[computer][k]) {
                result = "You lose. " + arr1[computer][0] + " beats " + arr1[user][0] + ".";
            }
        }
        if (computer == user)
            result = "Sorry, it's a tie.";
        return result;
    }
}
