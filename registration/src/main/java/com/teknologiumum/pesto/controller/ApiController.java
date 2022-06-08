package com.teknologiumum.pesto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teknologiumum.pesto.model.User;
import com.teknologiumum.pesto.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody User user) {
        userService.putUserToWaitlist(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/pending")
    public ResponseEntity getPending() {
        List<User> waitlist = userService.getUserInWaitlist();
        return ResponseEntity.ok(waitlist);
    }

}
