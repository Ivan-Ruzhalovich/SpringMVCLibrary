package com.ivan.mylibrary.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @JsonView(Views.userWithOrders.class)
    private Long id;

    @JoinColumn(name = "bookid")
    @OneToOne
    @JsonBackReference
    private Book book;

    @Column(name = "name")
    @NotBlank
    private String name;

    public Author(Long id, Book book, String name) {
        this.id = id;
        this.book = book;
        this.name = name;
    }

    public Author(Book book, String name) {
        this.book = book;
        this.name = name;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(book, author.book) && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", book=" + book +
                ", name='" + name + '\'' +
                '}';
    }
}
