public class TaskList {
    private TaskNode head;
    private TaskNode tail;
    private int size;

    public TaskNode createLinkedList(Task task) {
        head = new TaskNode(task);
        tail = head;
        size = 1;
        return head;
    }

    public void insertTask(Task task) {
        TaskNode node = new TaskNode(task);
        if (head == null) {
            createLinkedList(task);
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void traverseTaskList() {
        if (head == null) {
            System.out.println("Task list doesn't exist");
        } else {
            TaskNode tempNode = head;
            while (tempNode != null) {
                System.out.println(tempNode.task);
                tempNode = tempNode.next;
            }
        }
    }

    public void markTaskAsComplete(int index) {
        if (head == null) {
            System.out.println("Task list doesn't exist");
            return;
        }
        TaskNode tempNode = head;
        for (int i = 0; i < index; i++) {
            if (tempNode.next == null) {
                System.out.println("Task couldn't be found at index " + index);
                return;
            }
            tempNode = tempNode.next;
        }
        tempNode.task.markAsComplete();
    }

    public void deleteTask(int location) {
        if (head == null) {
            System.out.println("Task list doesn't exist");
            return;
        }
        if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else {
            TaskNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                if (tempNode.next == null) {
                    System.out.println("Task couldn't be found at " + location);
                    return;
                }
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            if (tempNode.next == null) {
                tail = tempNode;
            }
            size--;
        }
    }
}
