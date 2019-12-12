package com.ingram.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//Controller which means this will be handling HTTP request or Rest request
@RestController
//I need to to tell spring boot that i want to get request from local host 4200
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    //I want to create a method that will just return Hello World.
    //When creat a rest service I want to define 2 things.
        //GET method
        //URI - /hello-world

    //This method I will need to map a GET request to the URI
    //So, I need to create a mapping to this method.

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    //public String helloWorld(){
    //    return "Hello World!";
    //}

    //Another option to do this is use @GetMapping
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    //URI = hello-world-bean this will return a JSON
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World!");
    }

    //I am creating another simple hello world request with a path parameter or variable
    //Path Variables are a critical part of creating rest services
    @GetMapping (path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        //throw new RuntimeException("Something went wrong");
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    //What I have done here is create a RestController and then I mapped it to my Request method

}
