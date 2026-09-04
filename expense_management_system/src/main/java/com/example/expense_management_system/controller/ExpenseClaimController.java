package com.example.expense_management_system.controller;

import com.example.expense_management_system.entity.ExpenseClaim;
import com.example.expense_management_system.service.ExpenseClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpenseClaimController {

    @Autowired
    private ExpenseClaimService service;

    @PostMapping
    public ExpenseClaim createClaim(
            @Valid @RequestBody ExpenseClaim claim) {

        return service.createClaim(claim);
    }

    @GetMapping
    public List<ExpenseClaim> getAllClaims() {
        return service.getAllClaims();
    }

    @GetMapping("/{id}")
    public ExpenseClaim getClaimById(
            @PathVariable Long id) {

        return service.getClaimById(id);
    }

    @PutMapping("/{id}")
    public ExpenseClaim updateClaim(
            @PathVariable Long id,
            @RequestBody ExpenseClaim claim) {

        return service.updateClaim(id, claim);
    }

    @DeleteMapping("/{id}")
    public String deleteClaim(
            @PathVariable Long id) {

        service.deleteClaim(id);
        return "Claim Deleted Successfully";
    }

    @GetMapping("/category/{categoryId}")
    public List<ExpenseClaim> getClaimsByCategory(
            @PathVariable Long categoryId) {

        return service.getClaimsByCategory(categoryId);
    }

    @GetMapping("/monthly-spending")
    public Double getMonthlySpending() {

        return service.getMonthlySpending();
    }
}