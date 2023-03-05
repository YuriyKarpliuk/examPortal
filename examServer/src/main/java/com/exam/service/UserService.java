package com.exam.service;

import com.exam.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByUsername(String username);

    void deleteUserById(Long userId);
}
