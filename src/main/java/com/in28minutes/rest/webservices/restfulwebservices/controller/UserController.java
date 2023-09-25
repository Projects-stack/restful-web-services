package com.in28minutes.rest.webservices.restfulwebservices.controller;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.UserEntity;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    // EntityModel
    // WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<UserEntity> findOne(@PathVariable Integer id) {
        UserEntity userEntity = userService.findOne(id);
        EntityModel<UserEntity> userEntityModel = EntityModel.of(userEntity);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
        userEntityModel.add(link.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> save(@Valid @RequestBody UserEntity userEntity)
    {
        UserEntity savedUserEntity = userService.save(userEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUserEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id)
    {
        userService.delete(id);
    }
}
