package com.in28minutes.rest.webservices.restfulwebservices.service.impl;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.dao.UserDAO;
import com.in28minutes.rest.webservices.restfulwebservices.exception.NotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findOne(int id)
    {
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException("User with id:" + id + " is not present"));
    }

    @Override
    public User save(User user)
    {
        return userDAO.save(user);
    }

    @Override
    public void delete(Integer id)
    {
        userDAO.deleteById(id);
    }
}
