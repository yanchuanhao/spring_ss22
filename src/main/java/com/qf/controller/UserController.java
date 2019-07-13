package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    private UserService userService;
    public String getUser(int id){
        User user = userService.findUser(id);
        String s = user.toString();
        return s;
    }
}
