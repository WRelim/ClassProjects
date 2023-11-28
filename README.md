# PlannerFinal

## Synopsis
This was a final for a chapter where I was required to use an object class.
It's a planner with ADHD accessibilty in mind. It reminds you of tasks you have assigned to a day of the week to complete.

## Motivation
I personally have ADHD and have found having one day a week dedicated to chores was difficult to balance. I created this to remind myself of a couple chores each day that I can complete.

## How to Run
It's set up to run on my schools computer and has a specific file path. I suggest either changing or creating a file path of "/Users/student/Documents/jetbrains-workspace/PlannerFinal/src/ADHDPlanner". Open the "PlannerFinal.java" to run the code.
(Pictured below is the example files reminding you of your Monday chores)

[Test Text](image.png)

## Code Example
This is the method I wrote to create a new object.
```
public static Task newTask() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the task: ");
        String taskName = input.nextLine();
        System.out.print("Enter a description of the task: ");
        String taskDescription = input.nextLine();
        System.out.print("Enter any notes/reminders about the task: ");
        String taskNotes = input.nextLine();
        System.out.print("What day would you like to be reminded about this task?(If not applicable enter 'None'): ");
        String taskWeekday = input.nextLine();
        taskName = taskName.replace(" ", "");
        taskName = capitalize(taskName);
        taskWeekday = capitalize(taskWeekday);
        Task newTask = new Task(taskName, taskWeekday, taskDescription, taskNotes);

        return newTask;
    }
```
