package com.example.quizapp.service;

import com.example.quizapp.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Long, User> users = new HashMap<>();

    public User creatUser(Long id, String name) {
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    public User getUser(Long id) {
        return users.get(id);
    }
}
