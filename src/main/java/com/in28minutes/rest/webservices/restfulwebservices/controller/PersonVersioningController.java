package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.bean.Name;
import com.in28minutes.rest.webservices.restfulwebservices.bean.PersonV1;
import com.in28minutes.rest.webservices.restfulwebservices.bean.PersonV2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*   Factors to consider -
*       1. URI Pollution
*       2. Misuse of HTTP Headers
*       3. Caching
*       4. Can we execute the request in the browser?
*       5. API Documentation
*
*   Summary - No Perfect Solution
*
*   Think about versioning before you even use it
*   One Enterprise - One Versioning Approach
*
* */


@RestController
public class PersonVersioningController
{

    PersonV1 personV1 = new PersonV1("Sanket Mhetre");
    PersonV2 personV2 = new PersonV2(new Name("Sanket", "Mhetre"));

    // URI Versioning - TWITTER
    @GetMapping("/person/v1")
    public PersonV1 getPersonV1() {
        return personV1;
    }
    @GetMapping("/person/v2")
    public PersonV2 getPersonV2() {
        return personV2;
    }


    // Request-Param Versioning - AMAZON
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonParamsV1() {
        return personV1;
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonParamsV2() {
        return personV2;
    }


    // Custom Header Versioning - MICROSOFT
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonRequestHeaderV1() {
        return personV1;
    }
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonRequestHeaderV2() {
        return personV2;
    }

    // Media-Type Versioning - GITHUB
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonAcceptHeaderV1() {
        return personV1;
    }
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonAcceptHeaderV2() {
        return personV2;
    }
}
