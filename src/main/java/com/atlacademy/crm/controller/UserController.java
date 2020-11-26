package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.User;
import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    BaseResponse users() {
        return new BaseResponse(userService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse newUser(@RequestBody User user) {
        log.info(user.toString());
        return new BaseResponse(userService.save(user));
    }

    @GetMapping("/{id}")
    BaseResponse singleUser(@PathVariable Long id) {
        return new BaseResponse(userService.getById(id));
    }

    @PutMapping("/{id}")
    BaseResponse updateUser(@PathVariable Long id, @RequestBody User user) {
        return new BaseResponse(userService.updateById(id, user));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
