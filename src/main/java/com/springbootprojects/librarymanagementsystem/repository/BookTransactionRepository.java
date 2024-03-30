package com.springbootprojects.librarymanagementsystem.repository;

import com.springbootprojects.librarymanagementsystem.entity.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTransactionRepository extends JpaRepository<BookTransaction, Long> {

    List<BookTransaction> findByBookId(Long bookId);
    List<BookTransaction> findByIsReturned(boolean isReturned);
}
