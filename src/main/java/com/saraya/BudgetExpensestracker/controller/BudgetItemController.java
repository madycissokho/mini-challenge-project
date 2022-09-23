package com.saraya.BudgetExpensestracker.controller;

import com.saraya.BudgetExpensestracker.model.BudgetItem;
import com.saraya.BudgetExpensestracker.repository.BudgetItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BudgetItemController {

   private BudgetItemRepository budgetItemRepository;

    public BudgetItemController(BudgetItemRepository budgetItemRepository) {
        this.budgetItemRepository = budgetItemRepository;
    }

    @GetMapping("/budgetItem")
    public List<BudgetItem> budgetItems(){
        return budgetItemRepository.findAll();
    }
    @GetMapping("/budgetItem/{id}")
    public ResponseEntity<?> getBudgetItemById(@PathVariable Long id){
        Optional<BudgetItem> budgetItem = budgetItemRepository.findById(id);
        return budgetItem.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/budgetItem")
    public ResponseEntity<BudgetItem> createBudgetItem(@Valid @RequestBody BudgetItem budgetItem) throws URISyntaxException {

        BudgetItem result = budgetItemRepository.save(budgetItem);
        return ResponseEntity.created(new URI("/api/budgetItem" + budgetItem.getItemName())).body(result);
    }

}
