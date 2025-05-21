# Smart To-Do List (Java Console Application)

A Java-based Smart To-Do List application that allows users to manage both **Normal** and **Hidden** tasks efficiently from the console. The application supports adding, editing, viewing, completing, removing, and sorting tasks, and uses a PIN-protected system to access hidden tasks.

## Features
### Normal Tasks
- Add, view, edit, and remove tasks
- Mark tasks as completed
- Sort tasks based on priority (High > Medium > Low)
- Task types: General, Work, Personal
### Hidden Tasks
- Protected by a PIN (prompted at runtime)
- Same functionality as Normal Tasks
- Stored separately with secure access
### Persistence
- All tasks are saved automatically before the program exits
- Tasks are loaded from storage on each run (based on your implementation)
## Technologies Used
- Java (Core + OOP)
- Console-based UI
- File I/O for persistent storage
- Exception handling for robust user input
## How to Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/smart-todo-list.git
   cd smart-todo-list
