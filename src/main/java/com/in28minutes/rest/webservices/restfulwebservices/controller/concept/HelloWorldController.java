package com.in28minutes.rest.webservices.restfulwebservices.controller.concept;

import java.util.Locale;

import com.in28minutes.rest.webservices.restfulwebservices.bean.HelloWorldBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{

    @Autowired
    private MessageSource messageSource;
    /*
     * How are our requests handled?
     * Auto Configuration (DispatcherServletAutoConfiguration)
     *
     * How does HelloWorldBean object gets converted into json?
     * Auto Configuration (JacksonHttpMessageConvertersConfiguration)
     *
     * Who is configuring error mapping?
     * Auto Configuration (ErrorMvcAutoConfiguration)
     *
     * How are all jars available?
     * Spring Boot Starter Web Dependency consists of ->
     *  1. spring-web mvc
     *  2. spring-web
     *  3. spring-boot-starter-tomcat
     *  4. spring-boot-starter-json
    */


    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping("/good-morning-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}
