package com.example.TaskManagerREST.controller;

import com.example.TaskManagerREST.data.Status;
import com.example.TaskManagerREST.data.Task;
import com.example.TaskManagerREST.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService service){
        this.taskService = service;
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> getTasks(
            @RequestParam(required = false) Status status) {

        if (status == null) {
            return ResponseEntity.ok(taskService.showAllTasks());
        }

        return ResponseEntity.ok(taskService.showFilteredTasks(status));
    }

    @GetMapping("/api/tasks/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable int id){
        Task taskById = taskService.showTaskById(id);
        return ResponseEntity.ok(taskById);
    }

    @PostMapping("/api/tasks")
    ResponseEntity<Task> postTask(@Valid @RequestBody Task newTask){
        Task taskCreated = taskService.createTask(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @PutMapping("/api/tasks/{id}")
    Task putTask(@RequestBody Task taskModified, @PathVariable int id){
        return taskService.modifyTaskById(taskModified, id);
    }

    @DeleteMapping("/api/tasks/{id}")
    ResponseEntity deleteTask(@PathVariable int id){
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
