package com.in28minutes.rest.webservices.restfulwebservices.dao;

import com.in28minutes.rest.webservices.restfulwebservices.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Integer>
{
}
