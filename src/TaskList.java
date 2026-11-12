import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
    }

    public boolean addTask(Task task){
        if (taskExists(task.getTaskName())){
            return  false;
        }
        tasks.add(task);

        return true;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void printTasks(){
        for(Task task : tasks){
            if(!task.isFinished()){
                System.out.println("[ ] "  + task.getTaskName());
            }else {
                System.out.println("[x] "  +task.getTaskName());
            }
        }
    }
    public boolean isTaskComplete(String taskName){
        for(Task task : tasks){
            if (task.getTaskName().equals(taskName)){
                if (task.isFinished()){
                    return true;
                }
            }

        }
        return false;
    }
    public boolean setTaskCompleted(String taskName){
        for(Task task : tasks){
            if (task.getTaskName().equals(taskName)){
                task.markAsFinished();
                return true;
            }

        }
        return false;
    }

    public boolean taskExists(String taskName){
        for(Task task : tasks){
            if (task.getTaskName().equals(taskName)){
                return true;
            }
        }
        return false;
    }
}
