package com.library.library.Dto;

import java.util.List;

import com.library.library.Entities.Author;
import com.library.library.Entities.Book;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AuthorDto {

    private String name;
    private String age;
    private String description;
    private List<Book> books;
    
    public AuthorDto(Author author){

        this.name = author.getName();
        this.age = author.getAge();
        this.description = author.getDescription();
        this.books = author.getBooks();
    }

}
