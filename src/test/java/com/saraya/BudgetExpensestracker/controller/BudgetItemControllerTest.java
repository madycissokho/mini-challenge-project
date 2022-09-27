package com.saraya.BudgetExpensestracker.controller;

import com.saraya.BudgetExpensestracker.model.BudgetItem;
import com.saraya.BudgetExpensestracker.repository.BudgetItemRepository;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BudgetItemControllerTest {
    @Autowired
    BudgetItemRepository budgetItemRepository;

    @Test
    void getBudgetItems() {
        BudgetItem budgetItem = BudgetItem.builder()
                .itemId(1L)
                .itemName("House")
                .estimatedAmount(100.000)
                .actualAmount(500.000)
                .verified(false)
                .tag(new ArrayList<>())
                .type("Expense")
                .build();
        budgetItemRepository.save(budgetItem);
        assertNotNull(budgetItemRepository.findAll());
    }

    @Test
    void getBudgetItemById() {
        BudgetItem budgetItem = BudgetItem.builder().build();
        assertNotNull(budgetItemRepository.findById(1L).get());
    }

    @Test
    void createBudgetItem() {
        BudgetItem budgetItem = BudgetItem.builder()
                .itemId(1L)
                .itemName("Car")
                .estimatedAmount(150.000)
                .actualAmount(50.000)
                .verified(false)
                .tag(new ArrayList<>())
                .type("Expense")
                .build();
        assertNotNull(budgetItemRepository.save(budgetItem));
    }
}