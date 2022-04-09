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
    /**
     * Metoda zwraca wszystkie zadania
     **/
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    /**
     * Metoda zwraca zadania pomiędzy podanymi datami
     * @param start data początkowa
     * @param end data końcowa
     **/
    public List<Task> findByStartDateAndEndDate(Date start, Date end) {
        return taskRepository.findByStartAndEndDate(start, end);
    }
    /**
     * Metoda zwraca zadania w zależności od ich stanu
     * @param done data od którego dnia
     **/
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
    /**
     * Metoda zwraca zadania które należy wykonać w najbliższych 7 dniach
     **/
    public List<Task> findInSevenDays() {
        Date today = new Date(Calendar.getInstance().getTime().getTime());
        LocalDate week = today.toLocalDate();
        week = week.plusDays(7);
        Date inSevenDays = new Date(week.toEpochDay());
        return taskRepository.findByStartAndEndDate(today, inSevenDays);
    }

    /**
     * Metoda tworzy zadanie
     * @param task obiekt dodawanego zadania !BEZ ! ID!
     **/
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    /**
     * Metoda aktualizuje zadanie
     * @param task obiekt aktualizowanego zadania
     **/
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    /**
     * Metoda zwraca obiekt wybranego zadania
     * @param id wybranego dokumentu
     **/
    public Task findById(Long id){
        return taskRepository.findByIdEquals(id)
                .orElseThrow(() -> new NoSuchElementException("Cant find task with id: " + id));
    }
    /**
     * Metoda zwraca usuwa obiekt wybranego zadania z bazy danych
     * @param taskId wybrany dokument
     **/
    @Transactional
    public void deleteTask(long taskId) {
        taskRepository.deleteTaskById(taskId);
    }
}
