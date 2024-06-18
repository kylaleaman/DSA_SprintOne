public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        Task task = new Task(description);
        taskList.insertTask(task);
    }

    public void markTaskAsComplete(int index) {
        taskList.markTaskAsComplete(index);
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.traverseTaskList();
    }

    public void deleteTask(int location) {
        taskList.deleteTask(location);
    }
}
