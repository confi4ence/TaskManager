/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanagerreport;

/**
 *
 * @author Confidence
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TaskManagerReportTest {

    @BeforeEach
    void setUp() {
        TaskManagerReport.developers = new String[]{"John", "Jane", "Bob"};
        TaskManagerReport.taskNames = new String[]{"Task 1", "Task 2", "Task 3"};
        TaskManagerReport.taskIDs = new int[]{1, 2, 3};
        TaskManagerReport.taskDurations = new int[]{8, 4, 12};
        TaskManagerReport.taskStatuses = new String[]{"done", "in progress", "done"};
    }

    @Test
    void testDisplayTasksWithStatus() {
        TaskManagerReport.displayTasksWithStatus("done");
        // Assertions to check the displayed tasks
        Assertions.assertTrue(
                TaskManagerReport.taskNames[0].contains("Task 1") &&
                TaskManagerReport.developers[0].contains("John") &&
                TaskManagerReport.taskDurations[0] == 8
        );
        Assertions.assertTrue(
                TaskManagerReport.taskNames[2].contains("Task 3") &&
                TaskManagerReport.developers[2].contains("Bob") &&
                TaskManagerReport.taskDurations[2] == 12
        );
    }

    @Test
    void testDisplayTaskWithLongestDuration() {
        TaskManagerReport.displayTaskWithLongestDuration();
        // Assertions to check the displayed task with the longest duration
        Assertions.assertTrue(
                TaskManagerReport.developers[2].contains("Bob") &&
                TaskManagerReport.taskDurations[2] == 12
        );
    }

    @Test
    void testDisplayTaskByName() {
        TaskManagerReport.displayTaskByName("Task 2");
        // Assertions to check the displayed task details
        Assertions.assertTrue(
                TaskManagerReport.taskNames[1].contains("Task 2") &&
                TaskManagerReport.developers[1].contains("Jane") &&
                TaskManagerReport.taskStatuses[1].contains("in progress")
        );
    }

    @Test
    void testDisplayTasksByDeveloper() {
        TaskManagerReport.displayTasksByDeveloper("John");
        // Assertions to check the displayed tasks for the given developer
        Assertions.assertTrue(
                TaskManagerReport.taskNames[0].contains("Task 1") &&
                TaskManagerReport.taskStatuses[0].contains("done")
        );
    }

    @Test
    void testDeleteTaskByName() {
        TaskManagerReport.deleteTaskByName("Task 2");
        // Assertions to check that the task has been deleted
        Assertions.assertFalse(
                Arrays.asList(TaskManagerReport.taskNames).contains("Task 2")
        );
    }

    @Test
    void testDisplayFullTaskReport() {
        TaskManagerReport.displayFullTaskReport();
        // Assertions to check the full task report
        Assertions.assertTrue(
                Arrays.asList(TaskManagerReport.taskNames).contains("Task 1") &&
                Arrays.asList(TaskManagerReport.developers).contains("John") &&
                Arrays.asList(TaskManagerReport.taskStatuses).contains("done")
        );
        Assertions.assertTrue(
                Arrays.asList(TaskManagerReport.taskNames).contains("Task 2") &&
                Arrays.asList(TaskManagerReport.developers).contains("Jane") &&
                Arrays.asList(TaskManagerReport.taskStatuses).contains("in progress")
        );
        Assertions.assertTrue(
                Arrays.asList(TaskManagerReport.taskNames).contains("Task 3") &&
                Arrays.asList(TaskManagerReport.developers).contains("Bob") &&
                Arrays.asList(TaskManagerReport.taskStatuses).contains("done")
        );
    }
}