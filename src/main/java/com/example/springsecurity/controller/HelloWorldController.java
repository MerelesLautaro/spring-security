package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("denyAll()")
public class HelloWorldController {

    @GetMapping("/helloSec")
    @PreAuthorize("hasRole('ADMIN')") //HasAnyRole cuando son mas de un rol
    public String getHello(){
        return "Hello world  with security";
    }

    @GetMapping("/helloNoSec")
    @PreAuthorize("permitAll()")
    public String getHelloNoSec(){
        return "Hello world non security";
    }

}
