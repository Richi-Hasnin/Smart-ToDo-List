import java.io.*;
import java.util.ArrayList;

public class StorageManager {
    public static void saveTasks(String filename, ArrayList<Task> tasks) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(tasks);
            System.out.println("Tasks saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    
    public static ArrayList<Task> loadTasks(String filename) {
        ArrayList<Task> tasks;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            tasks = (ArrayList<Task>) in.readObject();
        } catch (FileNotFoundException e) {
            // File not found; start fresh.
            tasks = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
            tasks = new ArrayList<>();
        }
        return tasks;
    }
}