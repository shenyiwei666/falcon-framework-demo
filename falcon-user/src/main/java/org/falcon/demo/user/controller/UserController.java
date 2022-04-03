package org.falcon.demo.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.falcon.demo.user.service.UserService;
import org.falcon.demo.user.provider.dto.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @IgnoreLogging
    @GetMapping("/get/{userid}")
    public UserBean getUserById(@PathVariable("userid") Long userid) {
        return userService.getUserById(userid);
    }

}
