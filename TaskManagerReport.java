/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanagerreport;

import javax.swing.JOptionPane;

/**
 *
 * @author Confidence
 */
public class TaskManagerReport {

    static String[] developers;
    static String[] taskNames;
    static int[] taskIDs;
    static int[] taskDurations;
    static String[] taskStatuses;

    public static void main(String[] args) {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks: "));

        developers = new String[numTasks];
        taskNames = new String[numTasks];
        taskIDs = new int[numTasks];
        taskDurations = new int[numTasks];
        taskStatuses = new String[numTasks];

        for (int i = 0; i < numTasks; i++) {
            JOptionPane.showMessageDialog(null, "Enter details for Task " + (i + 1));

            developers[i] = JOptionPane.showInputDialog("Developer Name:");
            taskNames[i] = JOptionPane.showInputDialog("Task Name:");
            taskIDs[i] = Integer.parseInt(JOptionPane.showInputDialog("Task ID:"));
            taskDurations[i] = Integer.parseInt(JOptionPane.showInputDialog("Task Duration (in hours):"));
            taskStatuses[i] = JOptionPane.showInputDialog("Task Status:");
        }

        // Display tasks with status "done"
        displayTasksWithStatus("done");

        // Display developer and duration of the task with longest duration
        displayTaskWithLongestDuration();

        // Search for a task by name and display its details
        String searchTaskName = JOptionPane.showInputDialog("Enter the task name to search:");
        displayTaskByName(searchTaskName);

        // Search for tasks assigned to a developer and display their details
        String searchDeveloper = JOptionPane.showInputDialog("Enter the developer name to search:");
        displayTasksByDeveloper(searchDeveloper);

        // Delete a task by name
        String deleteTaskName = JOptionPane.showInputDialog("Enter the task name to delete:");
        deleteTaskByName(deleteTaskName);

        // Display the full task report
        displayFullTaskReport();
    }

    static void displayTasksWithStatus(String status) {
        StringBuilder report = new StringBuilder("Tasks with status '" + status + "':\n");
        for (int i = 0; i < taskStatuses.length; i++) {
            if (taskStatuses[i].equalsIgnoreCase(status)) {
                report.append("Task Name: ").append(taskNames[i]).append("\n");
                report.append("Developer: ").append(developers[i]).append("\n");
                report.append("Duration: ").append(taskDurations[i]).append(" hours\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    static void displayTaskWithLongestDuration() {
        int maxDurationIndex = 0;
        for (int i = 1; i < taskDurations.length; i++) {
            if (taskDurations[i] > taskDurations[maxDurationIndex]) {
                maxDurationIndex = i;
            }
        }
        JOptionPane.showMessageDialog(null, "Task with longest duration:\n"
                + "Developer: " + developers[maxDurationIndex] + "\n"
                + "Duration: " + taskDurations[maxDurationIndex] + " hours");
    }

    static void displayTaskByName(String taskName) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNames[i] + "\n"
                        + "Developer: " + developers[i] + "\n"
                        + "Status: " + taskStatuses[i]);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found!");
    }

    static void displayTasksByDeveloper(String developer) {
        StringBuilder report = new StringBuilder("Tasks assigned to " + developer + ":\n");
        boolean foundTasks = false;
        for (int i = 0; i < developers.length; i++) {
            if (developers[i].equalsIgnoreCase(developer)) {
                report.append("Task Name: ").append(taskNames[i]).append("\n");
                report.append("Status: ").append(taskStatuses[i]).append("\n\n");
                foundTasks = true;
            }
        }
        if (foundTasks) {
            JOptionPane.showMessageDialog(null, report.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for " + developer);
        }
    }

    static void deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                developers[i] = "";
                taskNames[i] = "";
                taskIDs[i] = 0;
                taskDurations[i] = 0;
taskStatuses[i] = "";
            }
        }
        JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted!");
    }

    static void displayFullTaskReport() {
        StringBuilder report = new StringBuilder("Full Task Report:\n");
        for (int i = 0; i < developers.length; i++) {
            if (!developers[i].isEmpty()) {
                report.append("Task Name: ").append(taskNames[i]).append("\n");
                report.append("Developer: ").append(developers[i]).append("\n");
                report.append("Task ID: ").append(taskIDs[i]).append("\n");
                report.append("Duration: ").append(taskDurations[i]).append(" hours\n");
                report.append("Status: ").append(taskStatuses[i]).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}

