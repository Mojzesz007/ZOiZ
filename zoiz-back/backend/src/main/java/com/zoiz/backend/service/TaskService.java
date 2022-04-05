package com.zoiz.backend.service;

import com.zoiz.backend.models.Task;
import com.zoiz.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {

        return taskRepository.findAll();
    }

    public List<Task> findByStartDateAndEndDate(Date start, Date end) {
        return taskRepository.findByStartAndEndDate(start, end);
    }
    public List<Task> findDone(Boolean done) {
        return taskRepository.findDone(done);
    }
}
