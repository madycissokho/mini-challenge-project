package com.saraya.BudgetExpensestracker.model;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "budget")
public class Budget {
    @Id
    private long budgetId;
    @Column(name = "budget_name")
    private String budgetName;
    private Date startDateOfBudget;
    private Date endDateOfBudget;
    @OneToMany(fetch = FetchType.EAGER)
    private List<BudgetItem> budgetItem;
    @ManyToMany
    private List<Tag> tag;
    private boolean completedBudget;
    private boolean overBudget;


    /*
    Classes
   1- Budget= Ensemble des depenses
  2-  Budget Item = Un poste budgétaire est une catégorie de dépenses
  3-  Tag = Etiquette
    */

}
