package com.example.TaskManagerREST.repository;

import com.example.TaskManagerREST.data.Status;
import com.example.TaskManagerREST.data.Task;
import com.example.TaskManagerREST.exception.TaskNotFoundException;
import org.springframework.boot.task.ThreadPoolTaskSchedulerBuilder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TaskRepository {

    private static int maxId = 1;
    private List<Task> taskList = new ArrayList<>();

    public Task saveTask(Task newTask) {
        newTask.setId(maxId++);
        taskList.add(newTask);
        return newTask;
    }

    public void populateList(){
        saveTask(new Task("prova 1", "task di prova 1", Status.TODO));
        saveTask(new Task("prova 2", "task di prova 2", Status.IN_PROGRESS));
        saveTask(new Task("prova 3", "task di prova 3", Status.DONE));
    }

    public List<Task> showAllTasks(){
        return taskList;
    }

    public Task showTaskById(int id) {
        Task foundTask = taskList.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
        return foundTask;
    }

    public List<Task> showFilteredTasks(Status status) {
        List<Task> listFiltered = taskList.stream()
                .filter(task -> task.getStatus() == status)
                .toList();

        return listFiltered;
    }

    public Task createTask(Task newTask) {
        saveTask(newTask);
        return newTask;
    }

    public Task modifyTaskById(Task taskModified, int id) {
        Task foundTask = taskList.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));

        if(taskModified.getTitle() != null) foundTask.setTitle(taskModified.getTitle());
        if(taskModified.getDescription() != null) foundTask.setDescription(taskModified.getDescription());
        if(taskModified.getStatus() != null) foundTask.setStatus(taskModified.getStatus());

        return foundTask;
    }

    public void deleteTaskById(int id) {
        Task foundTask = taskList.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));

        taskList.remove(foundTask);
    }

}
