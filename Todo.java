import java.util.ArrayList;
import java.util.Scanner;

public class Todo {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            displayMenu();
            input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":
                    addTask(tasks, scanner);
                    break;
                case "2":
                    removeTask(tasks, scanner);
                    break;
                case "3":
                    markTaskAsComplete(tasks, scanner);
                    break;
                case "4":
                    displayTasks(tasks);
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n---- To-Do List Menu ----");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Display Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(ArrayList<String> tasks, Scanner scanner) {
        System.out.print("Enter the task name: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void removeTask(ArrayList<String> tasks, Scanner scanner) {
        displayTasks(tasks);
        System.out.print("Enter the index of the task to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task \"" + removedTask + "\" removed successfully!");
        } else {
            System.out.println("Invalid index. No task removed.");
        }
    }

    private static void markTaskAsComplete(ArrayList<String> tasks, Scanner scanner) {
        displayTasks(tasks);
        System.out.print("Enter the index of the task to mark as complete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            String completedTask = tasks.get(index);
            tasks.set(index, "[X] " + completedTask);
            System.out.println("Task \"" + completedTask + "\" marked as complete!");
        } else {
            System.out.println("Invalid index. No task marked as complete.");
        }
    }

    private static void displayTasks(ArrayList<String> tasks) {
        System.out.println("\n---- Task List ----");

        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}
