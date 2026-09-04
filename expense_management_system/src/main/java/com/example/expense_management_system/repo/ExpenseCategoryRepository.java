package com.example.expense_management_system.repo;

import com.example.expense_management_system.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository
        extends JpaRepository<ExpenseCategory, Long> {

    boolean existsByCategoryName(String categoryName);
}