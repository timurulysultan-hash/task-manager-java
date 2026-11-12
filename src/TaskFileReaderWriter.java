import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskFileReaderWriter {

    public String taskToString(Task task){
       return task.isFinished() + ";"+ task.getTaskName();
    }

    public Task readTaskFromFileString(String fileString){
        String[] strings = fileString.split(";",2);
        if(strings.length != 2){
            return null;
        }
        if (strings[1].equals("")) {
            return null;
        }
        Task task = new Task(strings[1]);
        if (strings[0].equals("true")){
            task.markAsFinished();
        }
        return task;
    }

    public ArrayList<String> tasksToString(ArrayList<Task> tasks){
        ArrayList<String> strings = new ArrayList<>();
        for (Task task : tasks){
            strings.add(taskToString(task));
        }
        return strings;
    }

    public void writeToFile(ArrayList<Task> tasks, String fileString) throws IOException {
        Path path = Paths.get(fileString);
        Files.write(path,tasksToString(tasks));
    }

    public ArrayList<Task> readTasksFromFile(String fileString) throws IOException {
        Path path = Paths.get(fileString);
        ArrayList<Task> tasks = new ArrayList<>();
        if (!Files.exists(path)){
            return tasks;
        }
        List<String> strings = Files.readAllLines(path);
        for (String string : strings){
            Task taskObj = readTaskFromFileString(string);
            if (taskObj != null){
                tasks.add(taskObj);
            }
        }
        return tasks;
    }
}
