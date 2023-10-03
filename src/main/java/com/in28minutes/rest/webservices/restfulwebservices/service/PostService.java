package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.PostEntity;

public interface PostService
{
    List<PostEntity> findAllByUser(Integer userId);

    PostEntity save(Integer userId, PostEntity postEntity);

    PostEntity findOne(Integer id);
}
