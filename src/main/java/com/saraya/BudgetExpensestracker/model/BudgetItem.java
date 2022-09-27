package com.saraya.BudgetExpensestracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "budgetItem")
public class BudgetItem {
    @Id
    private long itemId;
    @Column(name = "item_name")
    private String itemName;
    private double estimatedAmount;
    private double actualAmount;
    private boolean verified;
    @OneToMany
    private List<Tag> tag;
    private String type;
}
