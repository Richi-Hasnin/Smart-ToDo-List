import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HiddenToDoList {
    private ArrayList<Task> hiddenTasks;
    private static final String PIN = "1234";

    public HiddenToDoList() {
        hiddenTasks = StorageManager.loadTasks("hidden_tasks.ser");
    }
    
    public boolean verifyPIN(Scanner scanner) {
        System.out.print("Enter PIN to access hidden tasks: ");
        String inputPIN = scanner.nextLine();
        if (inputPIN.equals(PIN)) {
            return true;
        } else {
            System.out.println("Incorrect PIN!");
            return false;
        }
    }
    
    public void addHiddenTask(Task task) {
        hiddenTasks.add(task);
        System.out.println("Hidden task added successfully!\n");
    }
    
    public void viewHiddenTasks() {
        if (hiddenTasks.isEmpty()) {
            System.out.println("No hidden tasks available.\n");
            return;
        }
        System.out.println("Hidden To-Do List:");
        for (int i = 0; i < hiddenTasks.size(); i++) {
            System.out.println((i + 1) + ". " + hiddenTasks.get(i));
        }
        System.out.println();
    }
    
    public void completeHiddenTask(int index) {
        if (isValidIndex(index)) {
            hiddenTasks.get(index - 1).markCompleted();
            System.out.println("Hidden task marked as completed!\n");
        } else {
            System.out.println("Invalid task number!\n");
        }
    }
    
    public void removeHiddenTask(int index) {
        if (isValidIndex(index)) {
            hiddenTasks.remove(index - 1);
            System.out.println("Hidden task removed successfully!\n");
        } else {
            System.out.println("Invalid task number!\n");
        }
    }
    
    public void editHiddenTask(int index, String newTitle, String newPriority) {
        if (isValidIndex(index)) {
            Task task = hiddenTasks.get(index - 1);
            task.setTitle(newTitle);
            task.setPriority(newPriority);
            System.out.println("Hidden task edited successfully!\n");
        } else {
            System.out.println("Invalid task number!\n");
        }
    }
    
    public void sortHiddenTasksByPriority() {
        hiddenTasks.sort(Comparator
            .comparing(Task::isCompleted)
            .thenComparing(task -> getPriorityValue(task.getPriority()))
        );
        System.out.println("Hidden tasks sorted by priority!\n");
    }
    
    public void saveHiddenTasks() {
        StorageManager.saveTasks("hidden_tasks.ser", hiddenTasks);
    }
    
    private boolean isValidIndex(int index) {
        return index >= 1 && index <= hiddenTasks.size();
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