package com.example.demo.db.repo;

import com.example.demo.db.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
