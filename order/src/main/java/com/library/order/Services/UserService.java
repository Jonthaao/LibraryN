package com.library.order.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.library.order.Dto.UserDto;
import com.library.order.Entities.User;
import com.library.order.Exception.RegisterNotFoundException;
import com.library.order.Exception.UserIdNotFoundException;
import com.library.order.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String register(User user) {
        userRepository.save(user);
        return "Cadastrado com sucesso!";
    }

    public List<UserDto> showList() {
        List<User> users = userRepository.findAll();
        return users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
    }
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws RegisterNotFoundException{
        User user = userRepository.findById(id).orElseThrow(()-> new RegisterNotFoundException("Registro de usuário não encontrado"));

        if (user != null) {
            userRepository.delete(user);
            return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Nao encontrado!", HttpStatus.NOT_FOUND);

    }

    public String edit(User newuser, int id) throws UserIdNotFoundException{
        User user = userRepository.findById(id).orElseThrow(()-> new UserIdNotFoundException("Código do usuário não encontrado!"));

        user.setName(newuser.getName());
        user.setDateofbirth(newuser.getDateofbirth());
        user.setCpf(newuser.getCpf());
        user.setEmail(newuser.getEmail());
        user.setAddress(newuser.getAddress());
        user.setPassword(newuser.getPassword());
        user.setStatus(newuser.getStatus());
        user.setType(newuser.getType());

        userRepository.save(user);

        return new String("Usuário atualizado com sucesso!");
    }
    
}
