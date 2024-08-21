package com.library.library.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}