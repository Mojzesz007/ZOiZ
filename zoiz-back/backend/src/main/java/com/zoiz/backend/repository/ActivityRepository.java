package com.zoiz.backend.repository;

import com.zoiz.backend.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    /**
     * Metoda zwraca obiekt zadania
     *
     * @param id danego obiektu
     **/
    Optional<Activity> findByIdEquals(Long id);

    /**
     * Metoda zwraca usuwa obiekt wybranego zadania z bazy danych
     *
     * @param id wybrany dokument
     **/
    void deleteActivityById(Long id);

    /**
     * Metoda zwraca aktualności pomiędzy podanymi datami
     *
     * @param startDate data początkowa
     * @param endDate   data końcowa
     **/
    @Query(
            value = "SELECT * FROM activities a WHERE a.activity_start > ?1 AND a.activity_end < ?2",
            nativeQuery = true)
    List<Activity> findByStartAndEndDate(Date startDate, Date endDate);

    /**
     * Metoda zwraca aktualności w zależności od ich statusu
     *
     * @param important decyduje o stanie zwróconych aktualności
     **/
    @Query(
            value = "SELECT * FROM activities a WHERE a.important = ?1",
            nativeQuery = true)
    List<Activity> findImportant(Boolean important);


}
