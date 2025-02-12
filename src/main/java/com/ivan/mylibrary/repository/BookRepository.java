package com.ivan.mylibrary.repository;

import com.ivan.mylibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BookRepository
        extends JpaRepository<Book,Long>, PagingAndSortingRepository<Book,Long> {
    Optional<Book> findBookByTitle (String title);
}
