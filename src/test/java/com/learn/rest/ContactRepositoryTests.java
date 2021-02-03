package com.learn.rest;

import com.learn.rest.respository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoryTests {

    private ContactRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ContactRepository();
    }

    @Test
    public void testContactsInRepository() {
        assertTrue(repository.getRepository().size() == 4);
    }

}