package com.example.mockitoexperiments.mockito2.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MyControllerTest {
    MockMvc mockMvc;
    MyController myController;

    @Before
    public void setUp() throws Exception {
        myController = new MyController();
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(myController)
//                .addFilter((request, response, chain) -> {
//                    response.setCharacterEncoding("UTF-8"); // this is crucial
//                    chain.doFilter(request, response);
//                }, "/*")
//                .build();
    }

    @Test
    public void getNumber() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getNumber");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();

        assertEquals(5, Integer.parseInt(responseContent));
    }
}