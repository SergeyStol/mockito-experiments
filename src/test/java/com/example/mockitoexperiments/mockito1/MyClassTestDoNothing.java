package com.example.mockitoexperiments.mockito1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyClassTestDoNothing {
    @Mock
    MyClass2 myClass2;

    @InjectMocks
    MyClass myClass;

    //

    @Test
    public void func3() {
        doNothing().doCallRealMethod().when(myClass2).func2(any());
//        doNothing().when(myClass2).func2(any());
//        doCallRealMethod().when(myClass2).func2(any());

        myClass.func3();

        myClass2.func2("aaa");
        myClass2.func2("aaa");
        myClass2.func2("aaa");
        myClass2.func2("aaa");
    }
}