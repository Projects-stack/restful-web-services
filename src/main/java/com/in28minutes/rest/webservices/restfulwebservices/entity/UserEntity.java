package com.in28minutes.rest.webservices.restfulwebservices.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // @JsonProperty("user_name")
    @Size(min = 2, message = "Name should have atleast two characters")
    @Column(name = "name")
    private String name;

    // @JsonProperty("birth_date")
    @Past(message = "Birthdate should not be in the future")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<PostEntity> postEntities;

}
