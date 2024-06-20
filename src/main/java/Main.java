import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "users.dat";

    public static void main(String[] args) {
        ArrayList<User> users = loadUsers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to To-Do List");
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String userName = scanner.nextLine();
                    if (findUser(users, userName) != null) {
                        System.out.println("User already exists");
                    } else {
                        users.add(new User(userName));
                        saveUsers(users);
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    User user = findUser(users, userName);
                    if (user != null) {
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        user.addTask(description);
                        saveUsers(users);
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    user = findUser(users, userName);
                    if (user != null) {
                        user.printTasks();
                        System.out.print("Enter task index: ");
                        int index = scanner.nextInt();
                        user.markTaskAsComplete(index);
                        saveUsers(users);
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    user = findUser(users, userName);
                    if (user != null) {
                        user.printTasks();
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 5:
                    saveUsers(users);
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static User findUser(ArrayList<User> users, String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    private static void saveUsers(ArrayList<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

