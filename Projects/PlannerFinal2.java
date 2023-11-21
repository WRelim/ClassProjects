package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * The code read from the folder and makes a text file
 *
 * The code needs to store a list of files to print the reminders of each day
 */
public class PlannerFinal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File plannerFolder = new File("/Users/student/Documents/jetbrains-workspace/ProjectFinal/src/ADHDPlanner");
        boolean folderBoolean = plannerFolder.mkdirs();
        if (folderBoolean) {
            System.out.println("Folder created: " + plannerFolder.getName());
        } else {
            System.out.println("Folder already exists.");
        }
        //print reminder file
        for (int endProgram = 1; endProgram > 0; ) {
            System.out.println("Choose an option:\n1: Create new task\n2: Look at a previous task\n0: End program");
            endProgram = input.nextInt();
            switch (endProgram) {
                case 0:
                    break;
                case 1:
                    Task task1 = newTask();
                    String fileName = task1.getName();
                    try {
                        FileWriter myWriter = new FileWriter("/Users/student/Documents/jetbrains-workspace/ProjectFinal/src/ADHDPlanner/" + fileName + ".txt");
                        myWriter.write(task1.toString());
                        myWriter.close();
                        System.out.println("Successfully wrote toString to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred with the myWriter.");
                        e.printStackTrace();
                    }
                    if (task1.getWeekday() != "None") {
                        String reminderNote = task1.getWeekday() + task1.getName();
                        try {
                            FileWriter myWriter = new FileWriter("/Users/student/Documents/jetbrains-workspace/ProjectFinal/src/ADHDPlanner/UserReminderList.txt");
                            myWriter.write(reminderNote);
                            myWriter.close();
                            System.out.println("Successfully wrote reminder to the file.");
                        } catch (IOException e) {
                            System.out.println("An error occurred with the myWriter.");
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    //List the files in directory
                    File[] listOfFiles = plannerFolder.listFiles();
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                            System.out.println("File " + listOfFiles[i].getName());
                        } else if (listOfFiles[i].isDirectory()) {
                            System.out.println("Directory " + listOfFiles[i].getName());
                        }
                    }

                    System.out.print("Which file would you like to open?: ");
                    String userFileChoice = input.next();
                    if (!userFileChoice.contains(".txt")) {
                        userFileChoice = userFileChoice + ".txt";
                        System.out.println();
                    }
                    //find file in directory and print it to the console
                    try {
                        File myObj = new File("/Users/student/Documents/jetbrains-workspace/ProjectFinal/src/ADHDPlanner/"+ userFileChoice);
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred with myReader.");
                        e.printStackTrace();
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("There is no option assigned to that number.");
            }
        }
    }

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
        String getWeekday() {
            return weekday;
        }
        void setWeekday(String userWeekday) {
            this.weekday = capitalize(userWeekday);
        }

        public String toString() {
            return "Name: " + name + "\tDaily Task: " + weekday + "\nDescription: " + description + "\n Notes: " + notes;
        }
    }

    public static String capitalize(String str) {
        str = str.toLowerCase();
        String firstLetter = str.substring(0, 1);
        String remainingLetters = str.substring(1, str.length());
        firstLetter = firstLetter.toUpperCase();
        return firstLetter + remainingLetters;
    }

    public static Task newTask() {
        Scanner input = new Scanner(System.in);
        String taskName;
        String taskDescription;
        String taskNotes;
        String taskReminder;

        System.out.print("Enter the name of the task: ");
        taskName = input.nextLine();
        System.out.print("Enter a description of the task: ");
        taskDescription = input.nextLine();
        System.out.print("Enter any notes/reminders about the task: ");
        taskNotes = input.nextLine();
        System.out.print("What day would you like to be reminded about this task?(If not applicable enter 'None'): ");
        taskReminder = input.nextLine();
        switch (capitalize(taskReminder)) {
            case "Monday":
                taskReminder = "Monday";
                break;
            case "Tuesday":
                taskReminder = "Tuesday";
                break;
            case "Wednesday":
                taskReminder = "Wednesday";
                break;
            case "Thursday":
                taskReminder = "Thursday";
                break;
            case "Friday":
                taskReminder = "Monday";
                break;
            case "Saturday":
                taskReminder = "Saturday";
                break;
            case "Sunday":
                taskReminder = "Sunday";
                break;
            default:
                taskReminder = "None";
        }
        Task newTask = new Task(taskName, taskReminder, taskDescription, taskNotes);

        return newTask;
    }
}
