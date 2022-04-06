package com.zoiz.backend.repository;

import com.zoiz.backend.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(
            value = "SELECT * FROM tasks t WHERE t.date_from > ?1 AND t.date_to < ?2",
            nativeQuery=true)
    List<Task> findByStartAndEndDate(Date startDate, Date endDate);

    @Query(
            value = "SELECT * FROM tasks t WHERE t.done = ?1",
            nativeQuery=true)
    List<Task> findDone(Boolean done);

    @Query(
            value = "SELECT * FROM tasks t WHERE t.dateTo < ?1",
            nativeQuery=true)
    List<Task> findOverdue(Date overdue);

    void deleteTaskById(Long id);
}
