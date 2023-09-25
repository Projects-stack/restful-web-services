package com.in28minutes.rest.webservices.restfulwebservices.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties({"field1", "field3"})
@Getter
@AllArgsConstructor
@JsonIgnoreProperties("field1")
public class SomeBean
{
    private String field1;
    @JsonIgnore
    private String field2;
    private String field3;
}
