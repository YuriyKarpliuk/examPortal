package com.exam.controller;

import com.exam.entity.User;
import com.exam.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;



    public UserController(UserService userService ) {
        this.userService = userService;
    }


    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable("username") String username) {
        return this.userService.getUserByUsername(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId) {
        this.userService.deleteUserById(userId);
    }


}
