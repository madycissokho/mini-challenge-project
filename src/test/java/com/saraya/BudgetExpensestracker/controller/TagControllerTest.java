package com.saraya.BudgetExpensestracker.controller;

import com.saraya.BudgetExpensestracker.model.Tag;
import com.saraya.BudgetExpensestracker.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TagControllerTest {
@Autowired
    TagRepository tagRepository;
    @Test
    void tags() {
        Tag tags = Tag.builder()
                .tagId(1L)
                .tagName("Budget One")
                .build();
        tagRepository.save(tags);
        assertNotNull(tagRepository.findAll());
    }

    @Test
    void getTagById() {
        Tag tags = Tag.builder().build();
        assertNotNull(tagRepository.findById(1L));

    }

    @Test
    void createTag() {
        Tag tags = Tag.builder()
                .tagId(2L)
                .tagName("House Two")
                .build();
        assertNotNull(tagRepository.save(tags));
    }
}