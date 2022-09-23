package com.saraya.BudgetExpensestracker.repository;

import com.saraya.BudgetExpensestracker.model.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetItemRepository extends JpaRepository<BudgetItem,Long> {
}
