package com.in28minutes.rest.webservices.restfulwebservices.controller;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.PostEntity;
import com.in28minutes.rest.webservices.restfulwebservices.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostController
{
    @Autowired
    private PostService postService;

    @GetMapping("/users/{userId}/posts/{id}")
    public PostEntity findOne(@PathVariable("id") Integer id)
    {
        return postService.findOne(id);
    }

    @GetMapping("/users/{userId}/posts")
    public List<PostEntity> findAllPostsByUser(@PathVariable("userId") Integer userId)
    {
        return postService.findAllByUser(userId);
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<URI> createPostForUser(@PathVariable("userId") Integer userId, @Valid @RequestBody PostEntity postEntity)
    {
        PostEntity savedPostEntity = postService.save(userId, postEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(savedPostEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
