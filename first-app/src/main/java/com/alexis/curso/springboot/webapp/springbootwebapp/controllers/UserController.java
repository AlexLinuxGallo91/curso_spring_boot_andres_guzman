package com.alexis.curso.springboot.webapp.springbootwebapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexis.curso.springboot.webapp.springbootwebapp.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola mundo Spring Boot!!!");
        model.addAttribute("user", new User(
                "Alexis", "Araujo", "alex_91y@hotmail.com"));

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Listas con Spring Boot !!!");
        return "list";
    }

    @ModelAttribute("users")
    public List users() {

        return Arrays.asList(
                new User("Alexis", "Araujo", "alexis@triara.com"),
                new User("Patsy", "Morales", "patsy@triara.com"),
                new User("Andrea", "Valencia"));

    }

    @GetMapping("/foo")
    public String getFooMessage(@RequestParam String message, Model model) {
        model.addAttribute("title", "hola desde Foo");
        model.addAttribute("message", message);
        return "fooMessage";
    }
}
