package com.in28minutes.rest.webservices.restfulwebservices.service.impl;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.dao.PostDAO;
import com.in28minutes.rest.webservices.restfulwebservices.entity.PostEntity;
import com.in28minutes.rest.webservices.restfulwebservices.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostServiceImpl implements PostService
{
    @Autowired
    private PostDAO postDAO;

    @Override
    public List<PostEntity> findByUser(Integer userId)
    {
        return postDAO.findByUserEntityId(userId);
    }

}

