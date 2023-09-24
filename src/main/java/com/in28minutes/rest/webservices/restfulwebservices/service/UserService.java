package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.bean.User;
import com.in28minutes.rest.webservices.restfulwebservices.dao.UserDAO;
import com.in28minutes.rest.webservices.restfulwebservices.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findOne(int id)
    {
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException("User with id:" + id + " is not present"));
    }

    public User save(User user)
    {
        return userDAO.save(user);
    }

    public void delete(Integer id)
    {
        userDAO.deleteById(id);
    }
}
