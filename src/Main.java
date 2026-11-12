import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final String FileName = "tasks.txt";
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        TaskFileReaderWriter taskFileReaderWriter = new TaskFileReaderWriter();
        try {
            ArrayList<Task> tasksFromFile = taskFileReaderWriter.readTasksFromFile(FileName);
            for (Task task : tasksFromFile) {
                taskList.addTask(task);
            }
            if (taskList.getTasks().size() == 0) {
                System.out.println("No tasks found");
            } else {
            taskList.printTasks();
            }
        } catch (IOException e) {
            System.out.println("Error reading tasks from file " + e.getMessage());
        }
        Scanner input = new Scanner(System.in);
        boolean programRunning = true;
        while (programRunning) {
            System.out.println("Enter action: ");
            System.out.println("1. Add task");
            System.out.println("2. Set task completed");
            System.out.println("3. Show all tasks");
            System.out.println("4. Exit");
            String actionName = input.nextLine();
            switch (actionName){
                case "1": {
                    System.out.println("Enter task name: ");
                    String taskName = input.nextLine();
                    if (taskNameIsBlank(taskName)){
                        System.out.println("Invalid task name");
                    } else {
                        boolean taskAddedOrNot = taskList.addTask(new Task(taskName));
                        if (taskAddedOrNot) {
                            System.out.println("Added task: " + taskName);
                            writeToFile(taskList.getTasks(),FileName,taskFileReaderWriter);
                        } else {
                            System.out.println("Task already exists: " + taskName);
                        }
                    }
                    break;
                }
                case "2": {System.out.println("Enter task name: ");
                    String taskName = input.nextLine();
                    if (taskNameIsBlank(taskName)){
                        System.out.println("Invalid task name");
                    } else {
                    if (completeTask(taskName, taskList)){
                        System.out.println("Task completed successfully");
                        writeToFile(taskList.getTasks(),FileName,taskFileReaderWriter);
                    } else  {
                        System.out.println("Task already completed");
                    }
                    }
                    break;}
                case "3": {taskList.printTasks();
                    break;}
                case "4": {programRunning = false;
                    break;}
                default:
                    System.out.println("Invalid input");

            }
        }
    }
    static boolean completeTask(String taskName,TaskList taskList){
        if (taskList.setTaskCompleted(taskName)){
            System.out.println("Task completed successfully");
            return true;
        }
        return false;
    }
    static boolean taskNameIsBlank(String taskName){
        return taskName.isBlank();
    }
    static void writeToFile(ArrayList<Task> tasks, String fileName, TaskFileReaderWriter taskFileReaderWriter){
        try {
           taskFileReaderWriter.writeToFile(tasks,fileName);
        } catch (IOException e) {
            System.out.println("Error writing tasks to file " + e.getMessage());
        }
    }
}

