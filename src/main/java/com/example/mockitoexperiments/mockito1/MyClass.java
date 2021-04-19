package com.example.mockitoexperiments.mockito1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyClass {
    @Autowired
    MyClass2 myClass2;

    public int func1() {
        return 5;
    }

    public int func2() {
        return myClass2.func1();
    }
}