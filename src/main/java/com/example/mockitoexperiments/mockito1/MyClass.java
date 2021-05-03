package com.example.mockitoexperiments.mockito1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MyClass {
    @Autowired
    MyClass2 myClass2;

    public int func1() {
        return 5;
    }

    public int func2() {
        return myClass2.func1();
    }

    public void func3() {
        myClass2.func2("Hello!");
    }
}