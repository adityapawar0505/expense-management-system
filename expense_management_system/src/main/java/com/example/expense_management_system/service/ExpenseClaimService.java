package com.example.expense_management_system.service;

import com.example.expense_management_system.entity.ExpenseClaim;
import com.example.expense_management_system.repo.ExpenseClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseClaimService {
    public Double getMonthlySpending() {

        return repository.findAll()
                .stream()
                .mapToDouble(ExpenseClaim::getAmount)
                .sum();
    }
    public List<ExpenseClaim> getClaimsByCategory(
            Long categoryId) {

        return repository.findByCategoryId(categoryId);
    }

    @Autowired
    private ExpenseClaimRepository repository;

    public ExpenseClaim createClaim(ExpenseClaim claim) {
        return repository.save(claim);
    }

    public List<ExpenseClaim> getAllClaims() {
        return repository.findAll();
    }

    public ExpenseClaim getClaimById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ExpenseClaim updateClaim(Long id, ExpenseClaim claim) {

        ExpenseClaim existing =
                repository.findById(id).orElse(null);

        if(existing != null) {
            existing.setExpenseDate(claim.getExpenseDate());
            existing.setAmount(claim.getAmount());
            existing.setDescription(claim.getDescription());
            existing.setUserId(claim.getUserId());
            existing.setCategoryId(claim.getCategoryId());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteClaim(Long id) {
        repository.deleteById(id);
    }
}