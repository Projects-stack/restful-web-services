package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.User;

public interface UserService
{
    List<User> findAll();

    User findOne(int id);

    User save(User user);

    void delete(Integer id);

}
