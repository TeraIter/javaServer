package com.example.demo.controllers;

import com.example.demo.classes.AllUsers;
import com.example.demo.classes.UserCreatedMessage;
import com.example.demo.db.entities.User;
import com.example.demo.db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/all")
    public @ResponseBody AllUsers getAllUsers() {
        Iterable<User> users = userRepo.findAll();
        System.out.println("ALL");
        return new AllUsers(users, userRepo.count());
    }

    @PostMapping("/add")
    public @ResponseBody UserCreatedMessage addNewUser(@RequestBody User user) {
        System.out.println("name:"+user.getName()+" surname:"+user.getSurName());
        //userRepo.save(user);
        return new UserCreatedMessage(HttpStatus.CREATED.value(), "Created");
    }
}
