package com.trustmeenglish.controllers;

import com.trustmeenglish.model.User;
import com.trustmeenglish.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SomeController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public User sayHello(@PathVariable Long id){
        return userService.getUser(id);
    }
}
