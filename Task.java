import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String priority; // High, Medium, Low
    private boolean isCompleted;

    public Task(String title, String priority) {
        this.title = title;
        this.priority = capitalize(priority);
        this.isCompleted = false;
    }

    public String getTitle() { return title; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }

    public void setTitle(String title) { this.title = title; }
    public void setPriority(String priority) { this.priority = capitalize(priority); }

    public void markCompleted() { this.isCompleted = true; }

    public String getType() {
        return "General";
    }

    @Override
    public String toString() {
        return "[ " + (isCompleted ? "✔" : "✗") + " ] " 
             + title + " (Priority: " + priority + ", Type: " + getType() + ")";
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}