package com.saraya.BudgetExpensestracker.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    private long tagId;
   // @Column(name = "tag_name")
    private String tagName;

 //Tag = Etiquette
}
