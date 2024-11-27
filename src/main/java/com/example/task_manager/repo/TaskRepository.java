package com.example.task_manager.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task_manager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

