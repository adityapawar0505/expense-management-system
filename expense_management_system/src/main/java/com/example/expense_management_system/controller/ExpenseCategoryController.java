package com.example.expense_management_system.controller;

import com.example.expense_management_system.entity.ExpenseCategory;
import com.example.expense_management_system.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryService service;

    @PostMapping
    public ExpenseCategory createCategory(
            @Valid @RequestBody ExpenseCategory category) {

        return service.createCategory(category);
    }

    @GetMapping
    public List<ExpenseCategory> getAllCategories() {

        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ExpenseCategory getCategoryById(
            @PathVariable Long id) {

        return service.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public ExpenseCategory updateCategory(
            @PathVariable Long id,
            @RequestBody ExpenseCategory category) {

        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(
            @PathVariable Long id) {

        service.deleteCategory(id);
        return "Category deleted successfully";
    }
}