public class TaskNode {
    public Task task;
    public TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}
