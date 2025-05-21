import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList normalList = new ToDoList();
        HiddenToDoList hiddenList = new HiddenToDoList();
        
        while (true) {
            System.out.println("====== Smart To-Do List ======");
            System.out.println("1. Normal Tasks");
            System.out.println("2. Hidden Tasks");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int mainChoice;
            try {
                mainChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.next(); // clear invalid input
                continue;
            }
            scanner.nextLine(); // consume newline

            switch (mainChoice) {
                case 1:
                    normalTasksMenu(normalList, scanner);
                    break;
                case 2:
                    if (hiddenList.verifyPIN(scanner)) {
                        hiddenTasksMenu(hiddenList, scanner);
                    }
                    break;
                case 3:
                    normalList.saveTasks();
                    hiddenList.saveHiddenTasks();
                    System.out.println("Exiting program... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    
    private static void normalTasksMenu(ToDoList normalList, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Normal Tasks Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Remove Task");
            System.out.println("6. Sort Tasks by Priority");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.next();
                continue;
            }
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter task type (General/Work/Personal): ");
                    String type = scanner.nextLine();
                    
                    Task newTask;
                    switch(type.toLowerCase()){
                        case "work":
                            newTask = new WorkTask(title, priority);
                            break;
                        case "personal":
                            newTask = new PersonalTask(title, priority);
                            break;
                        default:
                            newTask = new Task(title, priority);
                    }
                    normalList.addTask(newTask);
                    break;
                case 2:
                    normalList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new priority (High/Medium/Low): ");
                    String newPriority = scanner.nextLine();
                    normalList.editTask(editIndex, newTitle, newPriority);
                    break;
                case 4:
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = scanner.nextInt();
                    normalList.completeTask(completeIndex);
                    break;
                case 5:
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt();
                    normalList.removeTask(removeIndex);
                    break;
                case 6:
                    normalList.sortByPriority();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    
    private static void hiddenTasksMenu(HiddenToDoList hiddenList, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Hidden Tasks Menu ---");
            System.out.println("1. Add Hidden Task");
            System.out.println("2. View Hidden Tasks");
            System.out.println("3. Edit Hidden Task");
            System.out.println("4. Mark Hidden Task as Completed");
            System.out.println("5. Remove Hidden Task");
            System.out.println("6. Sort Hidden Tasks by Priority");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.next();
                continue;
            }
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter hidden task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter task type (General/Work/Personal): ");
                    String type = scanner.nextLine();
                    
                    Task newTask;
                    switch(type.toLowerCase()){
                        case "work":
                            newTask = new WorkTask(title, priority);
                            break;
                        case "personal":
                            newTask = new PersonalTask(title, priority);
                            break;
                        default:
                            newTask = new Task(title, priority);
                    }
                    hiddenList.addHiddenTask(newTask);
                    break;
                case 2:
                    hiddenList.viewHiddenTasks();
                    break;
                case 3:
                    System.out.print("Enter hidden task number to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new priority (High/Medium/Low): ");
                    String newPriority = scanner.nextLine();
                    hiddenList.editHiddenTask(editIndex, newTitle, newPriority);
                    break;
                case 4:
                    System.out.print("Enter hidden task number to mark as completed: ");
                    int completeIndex = scanner.nextInt();
                    hiddenList.completeHiddenTask(completeIndex);
                    break;
                case 5:
                    System.out.print("Enter hidden task number to remove: ");
                    int removeIndex = scanner.nextInt();
                    hiddenList.removeHiddenTask(removeIndex);
                    break;
                case 6:
                    hiddenList.sortHiddenTasksByPriority();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}