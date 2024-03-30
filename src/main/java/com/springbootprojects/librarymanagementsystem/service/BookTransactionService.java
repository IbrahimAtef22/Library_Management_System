package com.springbootprojects.librarymanagementsystem.service;

import com.springbootprojects.librarymanagementsystem.entity.BookTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookTransactionService {

    void borrowBook();
    void returnBook();
    List<BookTransaction> getAllBorrowedBooks();
}
