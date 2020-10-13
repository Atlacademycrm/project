package com.atlacademy.crm.service;

import com.atlacademy.crm.entity.User;
import com.atlacademy.crm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    public User saveUser(User User) {
        return userRepository.save(User);
    }

    public void deleteUserById(Long id) {
        userRepository.delete(getById(id));
    }
}
