package com.example.komponentIntegrationsTestEx.services;

import com.example.komponentIntegrationsTestEx.models.Task;
import com.example.komponentIntegrationsTestEx.models.User;
import com.example.komponentIntegrationsTestEx.models.Task;
import com.example.komponentIntegrationsTestEx.repositorys.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;


import static org.mockito.Mockito.times;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TaskServiceUnitTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void deleteTask_ShouldCallRepository() {
        long taskId = 1L;
        taskService.deleteTask(taskId);

        verify(taskRepository, times(1)).deleteById(taskId);
    }
    @Test
    void testGetTaskByIdReturnsTask () {
        long taskId = 1L;

        Task task = new Task();
        task.setId(taskId);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        //act
        Task result = taskService.getTaskById(1L);

        //assert
        assertEquals(1L, result.getId());
        verify(taskRepository).findById(1L);


    }

    @Test
    void updateTask_ShouldUpdateAndReturnTask() {
        long taskId = 1L;
        Task existingTask = new Task(taskId, "Clean the kitchen.", "Do dishes, clean the table.", false);
        Task updatedTask = new Task(taskId, "Clean the kitchen.", "Do dishes, clean the table.", true);

        when(taskRepository.findById(taskId)).thenReturn(java.util.Optional.of(existingTask));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        Task result = taskService.updateTask(taskId, updatedTask);

        assertNotNull(result);
        assertEquals("Clean the kitchen.", result.getTaskTitle());
        assertEquals("Do dishes, clean the table.", result.getTaskComment());
        assertTrue(result.isDone());

        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(existingTask);
    }
    @Test
    void GetAllTasks_ShouldReturnAllTasks() {
        // Arrange
        Task task = new Task(1L, "Clean the kitchen.", "Do dishes, clean the table.", false);
        List<Task> tasks = List.of(task);

        when(taskRepository.findAll()).thenReturn(tasks);

        // Act
        List<Task> result = taskService.getAllTasks();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Clean the kitchen.", result.get(0).getTaskTitle());
        verify(taskRepository, times(1)).findAll();

    }

}
