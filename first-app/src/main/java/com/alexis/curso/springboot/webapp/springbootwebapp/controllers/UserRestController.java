package com.alexis.curso.springboot.webapp.springbootwebapp.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexis.curso.springboot.webapp.springbootwebapp.models.User;
import com.alexis.curso.springboot.webapp.springbootwebapp.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {

        UserDto userDto = new UserDto();
        userDto.setUser(new User("Alexis", "Araujo"));
        userDto.setTitle("Hola Spring Boot");

        return userDto;
    }

    @GetMapping("/listUsers")
    public List<User> listUsers() {

        return Arrays.asList(
                new User("Alexis", "Araujo"),
                new User("Patsy", "Morales"),
                new User("Jessica", "Cid"));

    }

}
