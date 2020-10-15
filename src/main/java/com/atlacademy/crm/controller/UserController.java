package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.User;
import com.atlacademy.crm.interfaces.RepositoryConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {
    private RepositoryConnector repositoryConnector;

    public UserController(RepositoryConnector repositoryConnector) {
        this.repositoryConnector = repositoryConnector;
    }

    @GetMapping("/api/users")
    List<User> users() {
        return repositoryConnector.findAll();
    }
    @PostMapping("/api/users")
    User newUser(@RequestBody User user) {
        return repositoryConnector.save(user);
    }

    @GetMapping("/api/user/{id}")
    User singleUser(@PathVariable Long id) {
        return repositoryConnector.getById(id);
    }

    @PutMapping("/api/user/{id}")
    User updateUser(@PathVariable Long id) {
        User user = repositoryConnector.getById(id);
        return repositoryConnector.save(user);
    }

    @DeleteMapping("/api/user/{id}")
    void deleteUser(@PathVariable Long id) {
        repositoryConnector.deleteById(id);
    }
}
