package com.example.mockitoexperiments.mockito2.api;

import com.example.mockitoexperiments.mockito2.api.dto.PersonDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class MyControllerTest {
    MockMvc mockMvc;
    MyController myController;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    ObjectMapper mapper = new ObjectMapper();
    PersonDto personDtoExpected = PersonDto.builder()
            .id(1)
            .name("Name1")
            .build();

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
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/getNumber");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();

        assertEquals(5, Integer.parseInt(responseContent));
    }

    @Test
    public void getPerson() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/getPerson");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        PersonDto personDtoExpected = PersonDto.builder()
                .id(1)
                .name("Name1")
                .build();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        // Jackson
        PersonDto personDtoActual =
                mapper.readValue(contentAsString, PersonDto.class);
        assertEquals(personDtoExpected, personDtoActual);

        // Gson
        Gson gson = new Gson();
        personDtoActual = gson.fromJson(contentAsString, PersonDto.class);
        assertEquals(personDtoExpected, personDtoActual);
    }

    @Test
    public void getPerson3() throws Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/getPerson3")
                        .cookie(new Cookie("Name1", "Name1"));

        doNothing().when(response);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        Cookie[] cookiesActual = mvcResult.getResponse().getCookies();
        for (Cookie cookie : cookiesActual) {
            System.out.println("Test: " + cookie.getName() + " " + cookie.getValue());
        }

        when(myController.func1(anyString())).thenReturn(100);

        doNothing().when(myController).func2("MyStr");

        Cookie[] cookiesExcepted = new Cookie[2];
        cookiesExcepted[0] = new Cookie("Name2", "Name2");
        cookiesExcepted[1] = new Cookie("Name3", "Name3");
        assertTrue(Arrays.deepEquals(cookiesExcepted, cookiesActual));
    }

    @Test
    public void getPerson2() throws Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .post("/getPerson2")
                        .content(mapper.writeValueAsString(personDtoExpected))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        PersonDto personDtoActual =
                mapper.readValue(mvcResult.getResponse().getContentAsString(),
                        PersonDto.class);
        log.warn(personDtoActual.toString());

        assertEquals(personDtoExpected, personDtoActual);
    }

    @Test
    public void func2() {
        myController.func2("Hello");

        doNothing().when(myController).func2("Hello world!");


    }
}