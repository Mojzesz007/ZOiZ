package com.zoiz.backend.service;

import com.zoiz.backend.models.Task;
import com.zoiz.backend.models.User;
import com.zoiz.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
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

    public User login(String login, String password) {
        return userRepository.loginUser(login,password);
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
