package com.tweek.red.serveur.controllers;

import com.tweek.red.commun.User;
import com.tweek.red.serveur.forms.Login;
import com.tweek.red.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by tweek on 16/12/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<User> all() {
        List<User> liste = userService.getAll();
        return liste;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody Login form) {
        User user = userService.login(form.getLogin(), form.getPassword());
        return user;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody @Valid User input) {
        User user = userService.create(input);
        return user;
    }
}
