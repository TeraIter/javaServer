package com.example.demo.json_classes.response;

import com.example.demo.db.entities.User;

public record AllUsers(Iterable<User> users, long usersCount) implements Response {

}
