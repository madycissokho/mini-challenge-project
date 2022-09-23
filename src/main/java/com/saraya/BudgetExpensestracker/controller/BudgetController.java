package com.saraya.BudgetExpensestracker.controller;

import com.saraya.BudgetExpensestracker.model.Budget;
import com.saraya.BudgetExpensestracker.repository.BudgetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BudgetController {
    private BudgetRepository budgetRepository;

    public BudgetController(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @GetMapping("/budgets")
    public Collection<Budget> budgets() {
        return budgetRepository.findAll();
    }

    @GetMapping("/budget/{id}")
    public ResponseEntity<?> getBudgetById(@PathVariable Long id) {
        Optional<Budget> budget = budgetRepository.findById(id);
        return budget.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/budget")
    public ResponseEntity<Budget> createBudget(@Valid @RequestBody Budget budget) throws URISyntaxException {
        Budget result = budgetRepository.save(budget);
        return ResponseEntity.created(new URI("/api/budget" + result.getBudgetId())).body(result);
    }
}