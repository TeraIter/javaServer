package com.example.demo.controllers;

import com.example.demo.json_classes.response.*;
import com.example.demo.db.entities.User;
import com.example.demo.db.repo.UserRepo;
import com.example.demo.json_classes.response.requestBody.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/all")
    public @ResponseBody String getAllUsers() {
        Collection<User> users = userRepo.getAllUsers();
        return "HELLO";
    }

    @PostMapping("/add")
    public @ResponseBody Response addNewUser(@RequestBody User user) {
        if (
                user.getSurname() != null &&
                        user.getName() != null &&
                        user.getEmail() != null &&
                        user.getPassword() != null
        ) {
            userRepo.save(user);
            return new UserResponse(user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
        } else {
            return new HttpResponse(HttpStatus.FORBIDDEN.value(), "Oops");
        }
    }

    @PostMapping("/auth")
    public @ResponseBody Response authUser(@RequestBody UserAuth auth) {
        User user = userRepo.getUser(auth.email(), auth.password());
        return new UserResponse(user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
    }

    @PostMapping("/delete")
    public @ResponseBody Response deleteUser(@RequestBody UserAuth auth) {
        userRepo.deleteUser(auth.email(), auth.password());
        return new HttpResponse(HttpStatus.OK.value(), "Deleted");
    }
}
