package com.example.komponentIntegrationsTestEx.repositorys;

import com.example.komponentIntegrationsTestEx.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
