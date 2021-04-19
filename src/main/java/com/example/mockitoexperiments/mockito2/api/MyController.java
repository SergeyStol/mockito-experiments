package com.example.mockitoexperiments.mockito2.api;

import com.example.mockitoexperiments.mockito2.api.dto.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyController {
    @GetMapping("/getNumber")
    public int getNumber() {
        return 5;
    }

    @GetMapping("/getPerson")
    public PersonDto getPerson() {
        return PersonDto.builder()
                .id(1)
                .name("Name1")
                .build();
    }

    // Have to have setters???
    @PostMapping("/getPerson2")
    public PersonDto getPerson(@RequestBody PersonDto personDto) {
        return personDto;
    }

    // TODO Cookie
    @GetMapping("/getPerson3")
    public PersonDto getPerson3(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Controller: " + cookie.getName() + " " + cookie.getValue());
        }

        response.addCookie(new Cookie("Name2", "Name2"));
        return PersonDto.builder()
                .id(1)
                .name("Name1")
                .build();
    }

    // TODO Mockito verify
}