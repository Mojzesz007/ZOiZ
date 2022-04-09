package com.zoiz.backend.repository;

import com.zoiz.backend.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    /**
     * Metoda zwraca obiekt zadania
     *
     * @param id danego obiektu
     **/
    Optional<Task> findByIdEquals(Long id);

    /**
     * Metoda zwraca zadania pomiędzy podanymi datami
     *
     * @param startDate data początkowa
     * @param endDate   data końcowa
     **/
    @Query(
            value = "SELECT * FROM tasks t WHERE t.date_from > ?1 AND t.date_to < ?2",
            nativeQuery = true)
    List<Task> findByStartAndEndDate(Date startDate, Date endDate);

    /**
     * Metoda zwraca zadania w zależności od ich statusu
     *
     * @param done decyduje o stanie zwróconych zadań
     **/
    @Query(
            value = "SELECT * FROM tasks t WHERE t.done = ?1",
            nativeQuery = true)
    List<Task> findDone(Boolean done);

    /**
     * Metoda zwraca zadania nieukończone do podanego dnia
     *
     * @param overdue data od którego dnia
     **/
    @Query(
            value = "SELECT * FROM tasks t WHERE t.dateTo < ?1",
            nativeQuery = true)
    List<Task> findOverdue(Date overdue);

    /**
     * Metoda zwraca usuwa obiekt wybranego zadania z bazy danych
     *
     * @param id wybrany dokument
     **/
    void deleteTaskById(Long id);
}
