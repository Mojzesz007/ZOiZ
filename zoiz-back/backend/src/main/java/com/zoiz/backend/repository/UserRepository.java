package com.zoiz.backend.repository;

import com.zoiz.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Metoda zwraca obiekt użytkownika
     *
     * @param id danego obiektu
     **/
    Optional<User> findByIdEquals(Long id);

    /**
     * Metoda usuwa obiekt wybranego użytkownika z bazy danych
     *
     * @param id danego obiektu
     **/
    void deleteUserById(Long id);

    /**
     * Metoda loguje danego użytkownika
     * @return User wszystkie dane użytkownika
     *
     * @param login
     * @param password
     **/
    @Query(
            value = "SELECT * FROM users u WHERE u.email = ?1 AND u.password = ?2",
            nativeQuery = true)
    User loginUser(String login, String password);
}
