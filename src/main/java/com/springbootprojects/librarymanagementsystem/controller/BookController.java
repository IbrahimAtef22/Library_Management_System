package com.springbootprojects.librarymanagementsystem.controller;

import com.springbootprojects.librarymanagementsystem.entity.Book;
import com.springbootprojects.librarymanagementsystem.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> result = bookService.getAllBooks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book result = bookService.getBookById(id);
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) String genre) {
        if (title != null) {
            return new ResponseEntity<>(bookService.searchBooksByTitle(title), HttpStatus.FOUND);
        } else if (author != null) {
            return new ResponseEntity<>(bookService.searchBooksByAuthor(author), HttpStatus.FOUND);
        } else if (genre != null) {
            return new ResponseEntity<>(bookService.searchBooksByGenre(genre), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Validated @RequestBody Book book) {
        Book result = bookService.createBook(book);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Validated @RequestBody Book updatedBook) {
        Book result = bookService.updateBook(id, updatedBook);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
