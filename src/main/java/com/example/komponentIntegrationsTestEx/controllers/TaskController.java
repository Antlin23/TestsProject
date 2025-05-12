
package com.example.komponentIntegrationsTestEx.controllers;

import com.example.komponentIntegrationsTestEx.models.Task;
import com.example.komponentIntegrationsTestEx.models.User;
import com.example.komponentIntegrationsTestEx.services.*;
        import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createNewUser(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void DeleteTaskById(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }
}