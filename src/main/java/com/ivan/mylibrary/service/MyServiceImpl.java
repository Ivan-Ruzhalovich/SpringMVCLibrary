package com.ivan.mylibrary.service;
import com.ivan.mylibrary.entity.Book;
import com.ivan.mylibrary.repository.AuthorRepository;
import com.ivan.mylibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MyServiceImpl implements MyService {

    private BookRepository repository;
    private AuthorRepository authorRepository;

    @Autowired
    public MyServiceImpl(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Page<Book> getAllBooks(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = repository.findById(id);
        return book.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Книга не найдена"));
    }

    @Override
    public Book addNewBook(Book book) {
        Optional<Book> newBook = repository.findBookByTitle(book.getTitle());
        if(newBook.isEmpty())
            return repository.save(book);
        throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED,"Книга уже присутствует в библиотеке!");
    }

    @Override
    public void update(Book book) {
        Book updatedBook = repository
                .findById(book.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Книга не найдена"));
        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        repository.save(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book deletedBook = repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Книга не найдена"));
        repository.delete(deletedBook);
    }
}
