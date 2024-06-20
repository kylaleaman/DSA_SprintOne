import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
    private class Node implements Serializable {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskList() {
        head = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markAsComplete(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.task.markAsComplete();
                return;
            }
            count++;
            current = current.next;
        }
    }

    public void printTasks() {
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println(index + ": " + current.task);
            index++;
            current = current.next;
        }
    }
}
