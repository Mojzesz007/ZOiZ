package com.zoiz.backend.repository;

import com.zoiz.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
