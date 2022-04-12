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
     * @param id id uzytkownika ktrórego te dane dotyczą
     **/
    @Query(
            value = "SELECT * FROM tasks t WHERE t.date_from > ?1 AND t.date_to < ?2 AND t.USER_ID =?3",
            nativeQuery = true)
    List<Task> findByStartAndEndDate(Date startDate, Date endDate, Long id);

    /**
     * Metoda zwraca zadania w zależności od ich statusu
     *
     * @param done decyduje o stanie zwróconych zadań
     * @param id id uzytkownika ktrórego te dane dotyczą
     **/
    @Query(
            value = "SELECT * FROM tasks t WHERE t.done = ?1 AND t.USER_ID =?2",
            nativeQuery = true)
    List<Task> findDone(Boolean done, Long id);

    /**
     * Metoda zwraca zadania nieukończone do podanego dnia
     *
     * @param overdue data od którego dnia
     * @param id id uzytkownika ktrórego te dane dotyczą
     **/
    @Query(
            value = "SELECT * FROM tasks t WHERE t.dateTo < ?1 AND t.USER_ID=?2",
            nativeQuery = true)
    List<Task> findOverdue(Date overdue, Long id);

    /**
     * Metoda zwraca usuwa obiekt wybranego zadania z bazy danych
     *
     * @param id wybrany dokument
     **/
    void deleteTaskById(Long id);
}
