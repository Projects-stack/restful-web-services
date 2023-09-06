package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.bean.User;
import com.in28minutes.rest.webservices.restfulwebservices.exception.NotFoundException;

import org.springframework.stereotype.Component;

@Component
public class UserService
{
    public static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id)
    {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException("id:" + id));
    }

    public User save(User user)
    {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public boolean delete(Integer id)
    {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
