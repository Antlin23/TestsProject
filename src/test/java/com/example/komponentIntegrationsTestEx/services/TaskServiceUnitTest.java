package com.example.komponentIntegrationsTestEx.services;

import com.example.komponentIntegrationsTestEx.models.Task;
import com.example.komponentIntegrationsTestEx.models.User;
import com.example.komponentIntegrationsTestEx.repositorys.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

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
}
