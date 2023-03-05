package com.exam.controller;

import com.exam.dto.request.AuthenticationRequest;
import com.exam.dto.request.RegisterRequest;
import com.exam.dto.response.AuthenticationResponse;
import com.exam.entity.User;
import com.exam.security.service.AuthenticationService;
import com.exam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService service;

    private final UserService userService;

    public AuthenticationController(AuthenticationService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/current-user")
    public Optional<User> getCurrentUser(Principal principal) {
        return this.userService.getUserByUsername(principal.getName());
    }
}
