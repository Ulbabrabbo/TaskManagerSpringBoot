package com.example.TaskManagerREST.service;

import com.example.TaskManagerREST.repository.TaskRepository;
import com.example.TaskManagerREST.data.Status;
import com.example.TaskManagerREST.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository myRepository;

    TaskService(TaskRepository repository){
        this.myRepository = repository;
        repository.populateList();
    }

    public List<Task> showAllTasks() {
        return myRepository.showAllTasks();
    }

    public Task showTaskById(int id) {
        return myRepository.showTaskById(id);
    }

    public List<Task> showFilteredTasks(Status status) {
        return myRepository.showFilteredTasks(status);
    }

    public Task createTask(Task newTask) {
        return myRepository.createTask(newTask);
    }

    public Task modifyTaskById(Task task, int id){
        return myRepository.modifyTaskById(task, id);
    }

    public void deleteTaskById(int id){
        myRepository.deleteTaskById(id);
    }

}
