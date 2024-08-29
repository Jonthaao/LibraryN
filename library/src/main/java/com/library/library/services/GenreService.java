package com.library.library.services;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Entities.Genre;
import com.library.library.Dto.GenreDto;
import com.library.library.Repositories.GenreRepository;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    // public String register(Genre genre) {
    //     genreRepository.save(genre);

    //     return "Successfully registered!";
    // }

    public List<GenreDto> showList() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(x -> new GenreDto(x)).collect(Collectors.toList());
    }

    // public String delete(int id) {
    //     Genre genre = genreRepository.findById(id).orElse(null);

    //     if (genre != null) {
    //         genreRepository.delete(genre);
    //         return new String("Successfully deleted!");
    //     }

    //     return new String("Record not found.");
    // }

    // public String edit(Genre newgenre, int id) {
    //     Genre genre = genreRepository.findById(id).orElse(null);

    //     genre.setName(newgenre.getName());
    //     genre.setDescription(newgenre.getDescription());

    //     genreRepository.save(genre);

    //     return new String("Genre updated successfully!");
    // }

}
