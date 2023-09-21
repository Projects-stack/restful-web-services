package com.in28minutes.rest.webservices.restfulwebservices.controller;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.bean.User;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    // EntityModel
    // WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> findOne(@PathVariable Integer id) {
        User user = userService.findOne(id);
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
        userEntityModel.add(link.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@Valid @RequestBody User user)
    {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public boolean delete(@PathVariable Integer id)
    {
        return userService.delete(id);
    }
}
