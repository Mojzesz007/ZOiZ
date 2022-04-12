package com.zoiz.backend.rest;

import com.zoiz.backend.models.Task;
import com.zoiz.backend.models.User;
import com.zoiz.backend.repository.UserRepository;
import com.zoiz.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
    private final UserService userService;

    public UserEndpoint(UserService userService, UserRepository us) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @ResponseBody
    ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(
                userService.findAll(),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    ResponseEntity<User> createUser(
            @RequestBody User user
    ) {
        return new ResponseEntity<>(
                userService.createUser(user),
                HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    ResponseEntity<User> updateTask(
            @RequestBody User user
    ) {
        return new ResponseEntity<>(
                userService.updateUser(user),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    void delete(
            @PathVariable Long id
    ) {
        userService.deleteUser(id);
    }

    @GetMapping("/login")
    @ResponseBody
    ResponseEntity<User> loginUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password) {
        return new ResponseEntity<>(
                userService.login(login,password),
                HttpStatus.OK);
    }
}
