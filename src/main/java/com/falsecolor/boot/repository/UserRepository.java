package com.falsecolor.boot.repository;

import com.falsecolor.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "FROM User u JOIN FETCH u.roles")
    List<User> findAll();

    @Query(value = "FROM User u JOIN FETCH u.roles where u.username = :username")
    User findUserByUsername(@Param("username") String username);

}