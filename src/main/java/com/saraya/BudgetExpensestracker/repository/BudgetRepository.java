package com.saraya.BudgetExpensestracker.repository;

import com.saraya.BudgetExpensestracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {
    //Budget findByName(String budgetName);
}
