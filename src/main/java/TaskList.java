public class TaskList {
    private static class Node {
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
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markTaskAsComplete(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.task.markAsComplete();
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Task not found");
    }

    public void printTasks() {
        Node current = head;
        int count = 0;
        while (current != null) {
            System.out.println(count + ": " + current.task);
            current = current.next;
            count++;
        }
    }
}
