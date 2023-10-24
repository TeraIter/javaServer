package com.example.demo.db.repo;

import com.example.demo.db.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM User", nativeQuery = true)
    Collection<User> getAllUsers();

    @Query(value = "select * from user where email = ?1 and password = ?2", nativeQuery = true)
    User getUser(String email, String password);

    @Query(value = "delete from user where email=?1 and password=?2", nativeQuery = true)
    void deleteUser(String email, String password);
}
