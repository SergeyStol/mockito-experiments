package com.example.mockitoexperiments.mockito2.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/getNumber")
    int getNumber() {
        return 5;
    }

    // TODO return PersonDto
}