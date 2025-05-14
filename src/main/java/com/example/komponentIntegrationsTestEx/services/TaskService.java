package com.example.komponentIntegrationsTestEx.services;

import com.example.komponentIntegrationsTestEx.models.Task;

import com.example.komponentIntegrationsTestEx.repositorys.TaskRepository;
import com.example.komponentIntegrationsTestEx.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }


    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = getTaskById(id);
        existingTask.setTaskTitle(updatedTask.getTaskTitle());
        existingTask.setTaskComment(updatedTask.getTaskComment());
        existingTask.setDone(updatedTask.isDone());
        return taskRepository.save(existingTask);
    }
}
