package com.movieHam.user.controller;

import com.movieHam.user.service.SessionUser;
import com.movieHam.user.service.UserService;
import com.movieHam.user.service.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/user/insert", produces = "application/json; charset=UTF-8")
    public void doLogin(@RequestBody UserVO user) {
        userService.save(user);
    }


}
