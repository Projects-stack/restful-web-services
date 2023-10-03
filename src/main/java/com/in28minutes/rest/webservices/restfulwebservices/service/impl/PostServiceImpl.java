package com.in28minutes.rest.webservices.restfulwebservices.service.impl;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.dao.PostDAO;
import com.in28minutes.rest.webservices.restfulwebservices.entity.PostEntity;
import com.in28minutes.rest.webservices.restfulwebservices.entity.UserEntity;
import com.in28minutes.rest.webservices.restfulwebservices.exception.NotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.service.PostService;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostServiceImpl implements PostService
{
    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserService userService;

    @Override
    public List<PostEntity> findAllByUser(Integer userId)
    {
        return postDAO.findByUserEntityId(userId);
    }

    @Override
    public PostEntity save(Integer userId, PostEntity postEntity)
    {
        UserEntity userEntity = userService.findOne(userId);
        postEntity.setUserEntity(userEntity);
        return postDAO.save(postEntity);
    }

    @Override
    public PostEntity findOne(Integer id)
    {
        return postDAO.findById(id).orElseThrow(() -> new NotFoundException("Post with id: " + id + " not found"));
    }

}

