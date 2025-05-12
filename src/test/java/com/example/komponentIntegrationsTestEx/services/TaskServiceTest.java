package com.example.komponentIntegrationsTestEx.services;

import com.example.komponentIntegrationsTestEx.models.Task;
import com.example.komponentIntegrationsTestEx.repositorys.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;


    // Ett enhetstest som testar att skapa och spara en task
    @Test
    void testCreateTask() {
        // Arrange
        Task task = new Task();
        task.setTaskTitle("Test");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        // Act
        Task saved = taskService.createTask(task);

        // Assert
        assertEquals("Test", saved.getTaskTitle());
        verify(taskRepository).save(task); // Verifierar att repositoryt verkligen anropats
    }
}