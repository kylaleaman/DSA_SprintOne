public class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;  // Corrected spelling mistake
        this.isComplete = false;
    }

    public void markAsComplete() {
        this.isComplete = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public String toString() {
        return description + " [" + (isComplete ? "Completed" : "Pending") + "]";
    }
}

