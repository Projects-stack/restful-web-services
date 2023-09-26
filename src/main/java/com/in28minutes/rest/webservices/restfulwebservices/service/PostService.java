package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.PostEntity;

public interface PostService
{
    List<PostEntity> findByUser(Integer userId);
}
