package com.springbootprojects.librarymanagementsystem.controller;

import com.springbootprojects.librarymanagementsystem.entity.Author;
import com.springbootprojects.librarymanagementsystem.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> result = authorService.getAllAuthors();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Author result = authorService.getAuthorById(id);
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@Validated @RequestBody Author author) {
        Author result = authorService.createAuthor(author);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @Validated @RequestBody Author updatedAuthor) {
        Author result = authorService.updateAuthor(id, updatedAuthor);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
