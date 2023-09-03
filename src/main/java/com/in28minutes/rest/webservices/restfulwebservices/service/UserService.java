package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.in28minutes.rest.webservices.restfulwebservices.bean.User;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

@Component
public class UserService
{
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id)
    {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}