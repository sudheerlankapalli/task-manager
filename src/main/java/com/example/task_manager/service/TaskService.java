package com.example.task_manager.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task_manager.entity.Task;
import com.example.task_manager.repo.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get a specific task by ID
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null); // Return task if exists, otherwise return null
    }

    // Add a new task
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    // Update a task
    public Task updateTask(Long id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task updatedTask = existingTask.get();
            updatedTask.setCompleted(task.isCompleted());
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            return taskRepository.save(updatedTask);
        } else {
            return null; // Task not found
        }
    }

    // Delete a task
    public boolean deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
            return true;
        }
        return false; // Task not found
    }
}
