package com.example.mockitoexperiments.mockito3;

import lombok.Data;

@Data
public class Driver {
    String name;

    public void sayHello() {
        System.out.println("Hello guys!");
    }

    int getSameNumber(int number) {
        return number;
    }
}