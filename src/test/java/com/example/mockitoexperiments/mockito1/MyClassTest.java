package com.example.mockitoexperiments.mockito1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    @Mock
    MyClass2 myClass2;

    @InjectMocks
    MyClass myClass;

    @Test
    public void func1() {
        assertEquals(5, myClass.func1());
    }

    @Test
    public void func2() {
        when(myClass2.func1()).thenReturn(10);
        assertEquals(10, myClass.func2());
    }
}