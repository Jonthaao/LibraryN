package com.library.library.services;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Entities.Author;
import com.library.library.Exception.AuthorIdNotFoundException;
import com.library.library.Exception.RegisterNotFoundException;
import com.library.library.Dto.AuthorDto;
import com.library.library.Repositories.AuthorRepository;


@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String register(Author author) {
        authorRepository.save(author);

        return "Successfully registered!";
    }

    public List<AuthorDto> showList() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(x -> new AuthorDto(x)).collect(Collectors.toList());
    }

    public int delete(int id) throws RegisterNotFoundException{
        Author author = authorRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException("Registro de autor não encontrado!"));
        authorRepository.delete(author);
        return id;
    }

    public String edit(Author newauthor, int id) throws AuthorIdNotFoundException{
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorIdNotFoundException("Id do author não encontrado"));

        author.setName(newauthor.getName());
        author.setAge(newauthor.getAge());
        author.setDescription(newauthor.getDescription()); 

        authorRepository.save(author);

        return new String("Author updated successfully!");
    }

}
