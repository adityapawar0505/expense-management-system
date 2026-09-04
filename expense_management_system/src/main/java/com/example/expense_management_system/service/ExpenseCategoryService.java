package com.example.expense_management_system.service;

import com.example.expense_management_system.entity.ExpenseCategory;
import com.example.expense_management_system.repo.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {

    @Autowired
    private ExpenseCategoryRepository repository;

    public ExpenseCategory createCategory(ExpenseCategory category) {

        if(repository.existsByCategoryName(category.getCategoryName())) {
            throw new RuntimeException("Category already exists");
        }

        return repository.save(category);
    }

    public List<ExpenseCategory> getAllCategories() {
        return repository.findAll();
    }

    public ExpenseCategory getCategoryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ExpenseCategory updateCategory(Long id,
                                          ExpenseCategory category) {

        ExpenseCategory existing =
                repository.findById(id).orElse(null);

        if(existing != null) {
            existing.setCategoryName(category.getCategoryName());
            existing.setStatus(category.getStatus());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
