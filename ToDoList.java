import java.util.ArrayList;
import java.util.Comparator;

public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = StorageManager.loadTasks("tasks.ser");
    }
    
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!\n");
    }
    
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.\n");
            return;
        }
        System.out.println("Normal To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println();
    }
    
    public void completeTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index - 1).markCompleted();
            System.out.println("Task marked as completed!\n");
        } else {
            System.out.println("Invalid task number!\n");
        }
    }
    
    public void removeTask(int index) {
        if (isValidIndex(index)) {
            tasks.remove(index - 1);
            System.out.println("Task removed successfully!\n");
        } else {
            System.out.println("Invalid task number!\n");
        }
    }
    
    public void editTask(int index, String newTitle, String newPriority) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index - 1);
            task.setTitle(newTitle);
            task.setPriority(newPriority);
            System.out.println("Task edited successfully!\n");
        } else {
            System.out.println("Invalid task number!\n");
        }
    }
    
    public void sortByPriority() {
        tasks.sort(Comparator
            .comparing(Task::isCompleted)
            .thenComparing(task -> getPriorityValue(task.getPriority()))
        );
        System.out.println("Tasks sorted by priority!\n");
    }
    
    public void saveTasks() {
        StorageManager.saveTasks("tasks.ser", tasks);
    }
    
    private boolean isValidIndex(int index) {
        return index >= 1 && index <= tasks.size();
    }
    
    private int getPriorityValue(String priority) {
        return switch (priority) {
            case "High" -> 1;
            case "Medium" -> 2;
            case "Low" -> 3;
            default -> 4;
        };
    }
}