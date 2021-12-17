package com.task.heistback.service;

import com.task.heistback.model.User;
import com.task.heistback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByCredentials(String username, String password) {
        return userRepository.FindAllWithDescriptionQuery(username, password);
    }

    public User createUser(User newUser) {
        User user = findUserByCredentials(newUser.getEmail(), newUser.getPassword());
        if (user != null) {
            return null;
        }
        return userRepository.save(newUser);
    }

}
