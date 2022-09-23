package com.saraya.BudgetExpensestracker.controller;

import com.saraya.BudgetExpensestracker.model.Budget;
import com.saraya.BudgetExpensestracker.model.BudgetItem;
import com.saraya.BudgetExpensestracker.model.Tag;
import com.saraya.BudgetExpensestracker.repository.BudgetItemRepository;
import com.saraya.BudgetExpensestracker.repository.BudgetRepository;
import com.saraya.BudgetExpensestracker.repository.TagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BudgetControllerTest {
    @Autowired
    BudgetRepository budgetRepository;

    @Test
    void budgets() {
        Budget budget =  Budget.builder()
                .budgetId(1)
                .budgetName("New York")
                .startDateOfBudget(new Date())
                .endDateOfBudget(new Date())
                .budgetItem(new ArrayList<>())
                .tag(new ArrayList<>())
                .completedBudget(false)
                .overBudget(false)
                .build();
        budgetRepository.save(budget);

      assertNotNull(budgetRepository.findAll().get(0));
    }

    @Test
    void getBudgetById() {
        Budget budget = new Budget();
        budget.setBudgetId(1);
        budget.setBudgetName("New York");
        budget.setStartDateOfBudget(new Date());
        budget.setEndDateOfBudget(new Date());
        budget.setBudgetItem(new ArrayList<>());
        budget.setTag(new ArrayList<>());
        budget.setCompletedBudget(false);
        budget.setOverBudget(false);


        budgetRepository.save(budget);

        assertNotNull(budgetRepository.findById(1L).get());
    }

    @Test
    void createBudget() {
        Budget budget = new Budget();
        budget.setBudgetId(1);
        budget.setBudgetName("New York");
        budget.setStartDateOfBudget(new Date());
        budget.setEndDateOfBudget(new Date());
        budget.setBudgetItem(new ArrayList<>());
        budget.setTag(new ArrayList<>());
        budget.setCompletedBudget(false);
        budget.setOverBudget(false);


        assertNotNull(budgetRepository.save(budget));
    }
}