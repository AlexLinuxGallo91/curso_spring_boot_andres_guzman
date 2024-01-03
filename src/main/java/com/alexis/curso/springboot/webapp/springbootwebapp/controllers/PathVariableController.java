package com.alexis.curso.springboot.webapp.springbootwebapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.alexis.curso.springboot.webapp.springbootwebapp.models.User;
import com.alexis.curso.springboot.webapp.springbootwebapp.models.dto.ParamDto;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${code.name}")
    private String name;

    @Value("${code.lastName}")
    private String lastName;

    @Value("${code.email}")
    private String email;

    // @Value("${code.listOfValues}")
    // private String[] listOfValues;

    // @Value("${code.age}")
    // private int age;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mix(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();

        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/setUser")
    public User setUser(@RequestBody User user) {

        user.setName(user.getName().toUpperCase());

        return user;
    }

    @GetMapping("/getUser")
    public Map<String, Object> getUser(
            @Value("${code.listOfValues}") String[] listOfValues,
            @Value("${code.age}") Integer age) {
        Map<String, Object> map = new HashMap<>();

        map.put("name", this.name);
        map.put("lastName", this.lastName);
        map.put("email", this.email);
        map.put("listOfValues", listOfValues);
        map.put("age", age);

        return map;
    }

}
