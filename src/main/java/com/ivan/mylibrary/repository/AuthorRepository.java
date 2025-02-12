package com.ivan.mylibrary.repository;

import com.ivan.mylibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository
        extends JpaRepository<Author,Long>, PagingAndSortingRepository<Author,Long> {
}
