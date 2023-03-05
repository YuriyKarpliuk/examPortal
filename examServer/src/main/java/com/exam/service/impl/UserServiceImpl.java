package com.exam.service.impl;

import com.exam.entity.User;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserById(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
