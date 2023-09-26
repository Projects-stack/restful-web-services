package com.in28minutes.rest.webservices.restfulwebservices.dao;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends JpaRepository<PostEntity, Integer>
{
    List<PostEntity> findByUserEntityId(Integer userId);
}
