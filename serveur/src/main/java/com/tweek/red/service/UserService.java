package com.tweek.red.service;

import com.tweek.red.commun.User;
import com.tweek.red.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tweek on 25/12/16.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User login(String login, String password) {
        User user = userDao.findByLoginAndPassword(login, password);
        return user;
    }

    public User create(User input) {
        User user = userDao.save(input);
        return user;
    }
}
