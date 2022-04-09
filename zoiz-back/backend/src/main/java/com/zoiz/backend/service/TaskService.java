package com.zoiz.backend.service;

import com.zoiz.backend.models.Task;
import com.zoiz.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

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
    /**
     * Metoda zwraca zadania nieukończone
     **/
    public List<Task> findOverdue() {
        Date today = new Date(Calendar.getInstance().getTime().getTime());
        return taskRepository.findOverdue(today);
    }

    public List<Task> findInSevenDays() {
        Date today = new Date(Calendar.getInstance().getTime().getTime());
        LocalDate week = today.toLocalDate();
        week = week.plusDays(7);
        Date inSevenDays = new Date(week.toEpochDay());
        return taskRepository.findByStartAndEndDate(today, inSevenDays);
    }


    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Task findById(Long id){
        return taskRepository.findByIdEquals(id)
                .orElseThrow(() -> new NoSuchElementException("Cant find task with id: " + id));
    }

    @Transactional
    public void deleteTask(long taskId) {
        taskRepository.deleteTaskById(taskId);
    }
}
