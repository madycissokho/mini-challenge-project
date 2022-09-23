package com.saraya.BudgetExpensestracker.controller;

import com.saraya.BudgetExpensestracker.model.Tag;
import com.saraya.BudgetExpensestracker.repository.TagRepository;
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
public class TagController {

    private TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    @GetMapping("/tags")
    public Collection<Tag> tags(){
        return tagRepository.findAll();

    }
    @GetMapping("/tag/{id}")
    public ResponseEntity<?> getTagById(@PathVariable Long id){
        Optional<Tag> tag = tagRepository.findById(id);
        return tag.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/tag")
    public ResponseEntity<Tag> createTag(@Valid @RequestBody Tag tag) throws URISyntaxException{
        Tag result = tagRepository.save(tag);
        return ResponseEntity.created(new URI("/api/tag" + tag.getTagId())).body(result);
    }
}
