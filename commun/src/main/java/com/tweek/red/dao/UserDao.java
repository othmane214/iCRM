package com.tweek.red.dao;

/**
 * Created by tweek on 18/12/16.
 */

import com.tweek.red.commun.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query("select u from User u where u.login=:login and u.password=:password")
    User findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
} // class UserDao
