package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.PostEntity;
import com.in28minutes.rest.webservices.restfulwebservices.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController
{
    @Autowired
    private PostService postService;

    @GetMapping("users/{userId}/posts")
    public List<PostEntity> findPostsByUser(@PathVariable("userId") Integer userId) {
        return postService.findByUser(userId);
    }
}
