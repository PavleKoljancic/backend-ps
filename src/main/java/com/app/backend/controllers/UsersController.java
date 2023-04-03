package com.app.backend.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.services.UserService;

import lib.etickets.users.user.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @PostMapping("/payment/{userId}/{input}/{supervisorId}")
    public ResponseEntity<?> creditPayment(@PathVariable("userId") String userId, @PathVariable("input") double input, @PathVariable("supervisorId") String supervisorId){
        return ResponseEntity.ok().body(userService.creditPayment(userId, input, supervisorId));
    }

    @PostMapping("/approval/{approval}/{comment}/{reqId}")
    public ResponseEntity<String> approval(@PathVariable("approval") boolean approval, @PathVariable("comment") String comment, @PathVariable("reqId") String reqId){
        return ResponseEntity.ok().body(userService.approval(approval, comment, reqId));
    }
}
