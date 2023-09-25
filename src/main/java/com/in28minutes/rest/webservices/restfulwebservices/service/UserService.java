package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.UserEntity;

public interface UserService
{
    List<UserEntity> findAll();

    UserEntity findOne(int id);

    UserEntity save(UserEntity userEntity);

    void delete(Integer id);

}
