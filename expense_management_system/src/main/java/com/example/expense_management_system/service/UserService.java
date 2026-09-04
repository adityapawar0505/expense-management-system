package com.example.expense_management_system.service;

import com.example.expense_management_system.entity.User;
import com.example.expense_management_system.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public String forgotPassword(String email) {

        User user = repository.findByEmail(email).orElse(null);

        if (user == null) {
            return "User not found";
        }

        return "Email verified";
    }

    @Autowired
    private UserRepository repository;

    // Create User
    public User createUser(User user) {
        return repository.save(user);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Get User By ID
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete User
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    // Login
    public User login(String email, String password) {

        User user = repository.findByEmail(email).orElse(null);

        if (user != null &&
                user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    // Change Password
    public String changePassword(String email,
                                 String oldPassword,
                                 String newPassword) {

        User user = repository.findByEmail(email).orElse(null);

        if (user == null) {
            return "User not found";
        }

        if (!user.getPassword().equals(oldPassword)) {
            return "Old password is incorrect";
        }

        user.setPassword(newPassword);
        repository.save(user);

        return "Password changed successfully";
    }
}