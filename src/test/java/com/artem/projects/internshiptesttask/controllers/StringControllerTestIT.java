package com.artem.projects.internshiptesttask.controllers;

import com.artem.projects.internshiptesttask.exceptions.InputStringEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnFrequencyResponse_AfterGettingFrequencyOfCharacterOccurrence() throws Exception {
        String inputString = "aaaaabcccchhjjad";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v3/get-frequency/{string}", inputString);
        mockMvc.perform(request).andExpectAll(
                status().isOk(),
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                MockMvcResultMatchers.content().json("{\n" +
                        "    \"frequencyOfCharacters\": {\n" +
                        "        \"a\": 6,\n" +
                        "        \"c\": 4,\n" +
                        "        \"h\": 2,\n" +
                        "        \"j\": 2,\n" +
                        "        \"b\": 1,\n" +
                        "        \"d\": 1\n" +
                        "    }\n" +
                        "}"));
    }

    @Test
    void shouldReturnExceptionResponse_IfThrowInputStringEmptyException_WhenGettingFrequencyOfCharacterOccurrence() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v3/get-frequency/");

        mockMvc.perform(request).andExpectAll(
                result -> Assertions.assertTrue(result.getResolvedException() instanceof InputStringEmptyException),
                status().isBadRequest(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.requestURI").value("/api/v3/get-frequency/"),
                jsonPath("$.message").value("The entered string cannot be empty"),
                jsonPath("$.currentTime").exists()
        );
    }
}