import java.io.Serializable;

public class Task implements Serializable {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public void markAsComplete() {
        isComplete = true;
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

