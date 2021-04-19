package com.example.mockitoexperiments.mockito2.api;

import com.example.mockitoexperiments.mockito2.api.dto.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    // TODO Have to have setters???
    @GetMapping("/getPerson2")
    public PersonDto getPerson(@RequestBody PersonDto personDto) {
        return PersonDto.builder()
                .id(1)
                .name("Name1")
                .build();
    }

    // TODO Gson

    // TODO Mockito verify
}