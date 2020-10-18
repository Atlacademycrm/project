package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.User;
import com.atlacademy.crm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> users() {
        return userService.findAll();
    }
    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/user/{id}")
    User singleUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/user/{id}")
    User updateUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
