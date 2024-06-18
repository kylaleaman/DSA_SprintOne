import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to To-Do List");
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String userName = scanner.nextLine();
                    if (findUser(userName) != null) {
                        System.out.println("User already exists");
                    } else {
                        users.add(new User(userName));
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    User user = findUser(userName);
                    if (user != null) {
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        user.addTask(description);
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    user = findUser(userName);
                    if (user != null) {
                        System.out.print("Enter task index: ");
                        int index = scanner.nextInt();
                        user.markTaskAsComplete(index);
                    } else {
                        System.out.print("User not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    user = findUser(userName);
                    if (user != null) {
                        user.printTasks();
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    user = findUser(userName);
                    if (user != null) {
                        System.out.print("Enter task index: ");
                        int location = scanner.nextInt();
                        user.deleteTask(location);
                    } else {
                        System.out.print("User not found");
                    }
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }

    private static User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
