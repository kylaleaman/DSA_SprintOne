import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private ArrayList<Task> tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsComplete();
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index");
        }
    }
}

