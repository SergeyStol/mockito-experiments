package com.example.mockitoexperiments;

import com.example.mockitoexperiments.mockito1.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockitoExperimentsApplication implements CommandLineRunner {

    @Autowired
    MyClass myClass;

    public static void main(String[] args) {
        SpringApplication.run(MockitoExperimentsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(myClass.func1());
    }
}