package com.ivan.mylibrary.controller;
import com.ivan.mylibrary.entity.Book;
import com.ivan.mylibrary.service.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    MyServiceImpl service;
    @Autowired
    public MyController(MyServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/books")
    public ResponseEntity<Page<Book>> allBooks(Pageable page){
        return new ResponseEntity<>(service.getAllBooks(page), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return new ResponseEntity<>(service.getBook(id),HttpStatus.OK);
    }

    @PostMapping("/books/new")
    public ResponseEntity<String> addNewBook(@RequestBody Book book){
        service.addNewBook(book);
        return new ResponseEntity<>("Книга успешно добавлена",HttpStatus.OK);
    }

    @PutMapping("/books")
    public ResponseEntity<String> updateBook(@RequestBody Book book){
        service.update(book);
        return new ResponseEntity<>("Данные книги успешно изменены",HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return new ResponseEntity<>("Книга успешно удалена.",HttpStatus.OK);
    }
}