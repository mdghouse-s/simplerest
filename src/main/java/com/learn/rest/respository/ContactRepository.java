package com.learn.rest.respository;

import com.learn.rest.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ContactRepository {

    public static Map<Integer, Contact> repository = new HashMap<>();

    static{
        repository.put(101, new Contact(101, "ghouse", "9999911111","mg@sr.com", "official"));
        repository.put(102, new Contact(102, "jp", "9999922222","jp@sr.com", "official"));
        repository.put(103, new Contact(103, "sunil", "9999933333","sunil@sr.com", "friends"));
        repository.put(104, new Contact(104, "manzoor", "9999944444","manz@sr.com", "friends"));
    }

    public Map<Integer, Contact> getRepository(){
        return repository;
    }

}
