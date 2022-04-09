package com.zoiz.backend.service;

import com.zoiz.backend.models.User;
import com.zoiz.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Metoda zwraca wszystkich użytkowników
     **/
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Metoda tworzy użytkownika
     *
     * @param user obiekt dodawanego użytkownika !BEZ ! ID!
     **/
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Metoda aktualizuje użytkownika
     *
     * @param user obiekt aktualizowanego użytkownika
     **/
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Metoda zwraca obiekt wybranego użytkownika
     *
     * @param id wybranego użytkownika
     **/
    public User findById(Long id) {
        return userRepository.findByIdEquals(id)
                .orElseThrow(() -> new NoSuchElementException("Cant find user with id: " + id));
    }

    /**
     * Metoda usuwa obiekt wybranego użytkownika z bazy danych
     *
     * @param userId wybrany dokument
     **/
    @Transactional
    public void deleteUser(long userId) {
        userRepository.deleteUserById(userId);
    }
}
