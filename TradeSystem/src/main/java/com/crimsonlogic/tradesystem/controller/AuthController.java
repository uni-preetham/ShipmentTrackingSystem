package com.crimsonlogic.tradesystem.controller;

import com.crimsonlogic.tradesystem.entity.User;
import com.crimsonlogic.tradesystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
//        try {
//            User user = authService.registerUser(username, password, role);
//            return ResponseEntity.ok(user);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User newUser = authService.registerUser(user.getUsername(), user.getPassword(), user.getRole(), user.getFirstName(), user.getLastName());
            return ResponseEntity.ok(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
//        try {
//            User user = authService.loginUser(username, password);
//            return ResponseEntity.ok(user);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User authenticatedUser = authService.loginUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(authenticatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
