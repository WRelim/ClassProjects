package com.company;

import java.util.*;
import java.lang.*;
import java.io.File;

public class PlannerFinal {
    static class Task {
        String name;
        String weekday;
        String description;
        String notes;

        Task() {
            name = "None";
            weekday = "";
            description = "None";
            notes = "None";
        }
        Task(String userName, String userWeekday, String userDescription, String userNotes) {
            this.name = userName;
            this.weekday = capitalize(userWeekday);
            this.description = userDescription;
            this.notes = userNotes;
        }
        String getName() {
            return name;
        }
        void setName(String userName) {
            this.name = capitalize(userName);
        }
        String getDescription() {
            return description;
        }
        void setDescription(String newDescription) {
            this.description = capitalize(newDescription);
        }
        String getNotes() {
            return notes;
        }
        void setNotes(String newNotes) {
            this.notes = capitalize(newNotes);
        }
        void setWeekday(String userWeekday) {
            this.weekday = capitalize(userWeekday);
        }
        public String toString() {
            return "Name: " + name + "\tDaily Task: " + weekday + "\nDescription: \n" + description + "\n Notes:\n" + notes;
        }
    }
    public static String capitalize(String str) {
        str = str.toLowerCase();
        String firstLetter = str.substring(0,1);
        String remainingLetters = str.substring(1, str.length());
        firstLetter = firstLetter.toUpperCase();
        return firstLetter + remainingLetters;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Task kitchen = new Task("Kitchen", "Thursday", "Clean sink", "");
        kitchen.setDescription("Dust top of cupboards");
        System.out.println(kitchen.toString());
    }
}
