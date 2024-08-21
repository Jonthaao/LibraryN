package com.library.library.services;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Entities.Author;
import com.library.library.Dto.AuthorDto;
import com.library.library.Repositories.AuthorRepository;


@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public String register(Author author) {
        repository.save(author);

        return "Successfully registered!";
    }

    public List<AuthorDto> showList() {
        List<Author> authors = repository.findAll();
        return authors.stream().map(x -> new AuthorDto(x)).collect(Collectors.toList());
    }

    public String delete(int id) {
        Author author = repository.findById(id).orElse(null);

        if (author != null) {
            repository.delete(author);
            return new String("Successfully deleted!");
        }

        return new String("Record not found.");
    }

    public String edit(Author newauthor, int id) {
        Author author = repository.findById(id).orElse(null);

        author.setName(newauthor.getName());
        author.setAge(newauthor.getAge());
        author.setDescription(newauthor.getDescription()); 

        repository.save(author);

        return new String("Author updated successfully!");
    }

}
