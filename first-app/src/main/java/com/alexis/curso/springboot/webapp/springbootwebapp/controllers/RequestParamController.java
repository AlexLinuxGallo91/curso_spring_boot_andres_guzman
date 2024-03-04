package com.alexis.curso.springboot.webapp.springbootwebapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexis.curso.springboot.webapp.springbootwebapp.models.dto.ParamDto;
import com.alexis.curso.springboot.webapp.springbootwebapp.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "hola", name = "mensaje") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text,
            @RequestParam(required = false, defaultValue = "10") Integer code) {
        ParamMixDto param = new ParamMixDto();
        param.setText(text);
        param.setCode(code);

        return param;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {

        ParamMixDto param = new ParamMixDto();

        int code = 0;
        String text = "";

        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            code = 10;
        }

        text = request.getParameter("text");
        param.setCode(code);
        param.setText(text);

        return param;
    }

}
