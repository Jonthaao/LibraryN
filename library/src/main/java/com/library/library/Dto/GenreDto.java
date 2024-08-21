package com.library.library.Dto;

import com.library.library.Entities.Genre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDto {

    private String name;
    private String description;

    public GenreDto(Genre genre) {
        this.name = genre.getName();
        this.description = genre.getDescription();
    }
}