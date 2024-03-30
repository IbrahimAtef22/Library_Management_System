package com.springbootprojects.librarymanagementsystem.service;

import com.springbootprojects.librarymanagementsystem.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author createAuthor(Author author);
    Author updateAuthor(Long id, Author updatedAuthor);
    void deleteAuthor(Long id);
}
