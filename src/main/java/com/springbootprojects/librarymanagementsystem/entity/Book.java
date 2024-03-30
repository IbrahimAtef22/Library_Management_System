package com.springbootprojects.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    private String genre;
    private int stock;
    private int borrowedBooksNo;
    private boolean isAvailable;


    public int getRemained() {
        return stock - borrowedBooksNo;
    }

    public double getBorrowedBooksPercentage() {
        return (stock > 0) ? ((double) borrowedBooksNo / stock) * 100 : 0;
    }
}
