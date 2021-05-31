package com.example.mockitoexperiments.mockito3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarTest {
    @Mock
    Driver driver;

    @InjectMocks
    Car car;

    @Test
    void firstTest() {
        car.pingDriverTwoTimes();
        verify(driver, times(2)).sayHello();
    }

    @Test
    void doThrowTest() {
        doThrow(NullPointerException.class).when(driver).sayHello();
        Assertions.assertThrows(NullPointerException.class,
                () -> car.pingDriverTwoTimes());
    }

    @Test
    void thenThrowTest() {
        when(driver.getSameNumber(anyInt())).thenThrow(NullPointerException.class);
        Assertions.assertThrows(NullPointerException.class,
                () -> driver.getSameNumber(5));
    }
}