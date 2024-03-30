package com.springbootprojects.librarymanagementsystem.service;

import com.springbootprojects.librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(Long id);
    List<Book> searchBooksByTitle(String title);
    List<Book> searchBooksByAuthor(String authorName);
    List<Book> searchBooksByGenre(String genre);
    Book createBook(Book book);
    Book updateBook(Long id, Book updatedBook);
    void deleteBook(Long id);
}
