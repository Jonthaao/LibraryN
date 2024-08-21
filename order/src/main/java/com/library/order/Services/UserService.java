package com.library.order.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.order.Dto.UserDto;
import com.library.order.Entities.User;
import com.library.order.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public String register(User user) {
        repository.save(user);
        return "Cadastrado com sucesso!";
    }

    public List<UserDto> showlist() {
        List<User> users = repository.findAll();
        return users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
    }
    
}
