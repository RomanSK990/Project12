package part2_todolist;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Part2ToDoList {
    public static void showAllTasks(List<String> lines) {
        if (lines.isEmpty()) {
            System.out.println("No tasks found");
            return;
        }
        int i = 1;
        for (String line : lines) {
            System.out.println("Task " + i + ": " + line);
            i++;
        }
    }
    public static void addTask(List<String> lines) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter task: ");
        String name = in.nextLine();
        lines.add(name);
        System.out.println("Task has been successfully added.");
    }
    public static void saveTask(List<String> lines, Path preferedpath) {
        try {
            Files.write(preferedpath, lines, StandardCharsets.UTF_8);
            System.out.println("Tasks have been successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Path preferedpath = Path.of("todo.txt");
        boolean running = true;

        List<String> lines = new ArrayList<>();
        try {
            if (Files.exists(preferedpath)) {
                lines = Files.readAllLines(preferedpath, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (running) {
            System.out.println("What would you like to do?");
            System.out.println("1. Show all tasks");
            System.out.println("2. Add task");
            System.out.println("3. Save and exit.");
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    showAllTasks(lines);
                    break;
                case 2:
                    addTask(lines);
                    break;
                case 3:
                    saveTask(lines, preferedpath);
                    System.out.println("Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}