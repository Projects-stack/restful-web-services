package com.in28minutes.rest.webservices.restfulwebservices.filtering.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.filtering.bean.SomeBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController
{

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6")
        );
    }
}
