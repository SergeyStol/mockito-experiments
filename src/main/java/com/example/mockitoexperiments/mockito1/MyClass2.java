package com.example.mockitoexperiments.mockito1;

import org.springframework.stereotype.Component;

@Component
public class MyClass2 {
    public int func1() {
        return 10;
    }

    void func2(String str) {
        System.out.println(str);
    }
}