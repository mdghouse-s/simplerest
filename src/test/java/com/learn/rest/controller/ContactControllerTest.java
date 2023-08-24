package com.learn.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.rest.exception.ContactNotFoundException;
import com.learn.rest.model.Contact;
import com.learn.rest.respository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private ContactRepository contactRepository;

    private Contact testContact;

    @BeforeEach
    void setUp() {
        // Create a sample Contact for testing
        testContact = new Contact(1, "John", "Doe", "1234567890", "john@example.com", "Friend");
    }

    @Test
    public void testGetInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/info"))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetContacts() throws Exception {
        // Mock your repository's behavior
        Map<Integer, Contact> mockRepository = new HashMap<>();
        mockRepository.put(1, testContact);
        mockRepository.put(2, new Contact(2, "Jane", "Smith", "9876543210", "jane@example.com", "Family"));

        when(contactRepository.getRepository()).thenReturn(mockRepository);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/contacts"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("John"))
               .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value("Jane"));
    }
}
