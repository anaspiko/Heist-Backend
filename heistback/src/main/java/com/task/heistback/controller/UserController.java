package com.task.heistback.controller;


import com.task.heistback.common.Constants;
import com.task.heistback.model.User;
import com.task.heistback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = Constants.BASE_URL)
@RequestMapping(Constants.URL_EXTENSION + Constants.USER)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    //find user by credentials
    @PostMapping("/findUserByCredentials")
    public ResponseEntity<User> findUserByCredentials(String username, String password) {
        return ResponseEntity.ok(userService.findUserByCredentials(username, password));
    }


}
