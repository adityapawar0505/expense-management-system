package com.example.expense_management_system.repo;

import com.example.expense_management_system.entity.ExpenseClaim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseClaimRepository
        extends JpaRepository<ExpenseClaim, Long> {

    List<ExpenseClaim> findByCategoryId(Long categoryId);
}