package com.example.demo.classes;

import com.example.demo.db.entities.User;

public record AllUsers(Iterable<User> users, long usersCount) {

}
