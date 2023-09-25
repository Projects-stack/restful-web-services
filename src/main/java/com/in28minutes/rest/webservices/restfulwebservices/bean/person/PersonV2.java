package com.in28minutes.rest.webservices.restfulwebservices.bean.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import com.in28minutes.rest.webservices.restfulwebservices.bean.Name;

@Data
@AllArgsConstructor
@ToString
public class PersonV2
{
    private Name name;
}
