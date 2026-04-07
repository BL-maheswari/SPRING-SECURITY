package com.bl.jwtauthentication.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bl.jwtauthentication.model.User;

@Service
public class UserServices {

    private List<User> store= new ArrayList<>();

    public UserServices(){
        store.add(new User(UUID.randomUUID().toString(),"Prateek Shinde","Prateek@example.com"));
        store.add(new User(UUID.randomUUID().toString(),"Alok Gupta","alok@example.com"));
        store.add(new User(UUID.randomUUID().toString(),"Ram ","ram@example.com"));
        store.add(new User(UUID.randomUUID().toString(),"om Prakask","om@example.com"));

    }

    public List<User> getUsers() {
        return this.store;
    }
}
