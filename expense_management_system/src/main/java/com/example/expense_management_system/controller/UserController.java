package com.example.expense_management_system.controller;

import com.example.expense_management_system.entity.User;
import com.example.expense_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.expense_management_system.dto.ChangePasswordRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody User user) {

        return service.forgotPassword(
                user.getEmail());
    }

    @Autowired
    private UserService service;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return service.login(
                user.getEmail(),
                user.getPassword());
    }

    @PutMapping("/change-password")
    public String changePassword(
            @RequestBody ChangePasswordRequest request) {

        return service.changePassword(
                request.getEmail(),
                request.getOldPassword(),
                request.getNewPassword());
    }
}