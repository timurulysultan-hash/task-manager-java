import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
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
                    completeTask(taskName, taskList);}
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
    static void completeTask(String taskName,TaskList taskList){
        if (taskList.setTaskCompleted(taskName)){
            System.out.println("Task completed successfully");
        }else {
            System.out.println("Task " + taskName +" not found");
        }
    }
    static boolean taskNameIsBlank(String taskName){
        return taskName.isBlank();
    }
}

