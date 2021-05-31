package com.example.mockitoexperiments.mockito3;

import lombok.Data;

@Data
public class Car {
    Driver driver;

    public void pingDriverTwoTimes() {
        driver.sayHello();
        driver.sayHello();
    }
}
