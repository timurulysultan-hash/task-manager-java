public class Task {
    private String taskName;
    private boolean finished;

    public Task(String taskName){
        this.taskName = taskName;
        this.finished = false;
    }

    public void markAsFinished(){
        this.finished = true;
    }
    public String getTaskName(){return this.taskName;}
    public boolean isFinished(){return this.finished;}
}
