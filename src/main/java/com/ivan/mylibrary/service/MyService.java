package com.ivan.mylibrary.service;


import com.ivan.mylibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyService {
    Page<Book> getAllBooks(Pageable page);
    Book getBook(Long id);
    Book addNewBook(Book book);
    void update(Book book);
    void deleteBook(Long id);
}
