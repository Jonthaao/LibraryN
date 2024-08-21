package com.library.library.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}