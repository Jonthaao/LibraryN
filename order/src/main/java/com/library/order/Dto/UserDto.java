package com.library.order.Dto;

import java.util.Date;

import com.library.order.Entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String name;
    private Date dateofbirth;
    private String cpf;
    private String email;
    private String address;
    private String status;

    public UserDto(User user) {
        this.name = user.getName();
        this.dateofbirth = user.getDateofbirth();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.status = user.getStatus();
    }
    
    
    
}
