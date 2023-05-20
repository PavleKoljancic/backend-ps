package com.app.backend.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.services.UserService;

import lib.etickets.ticket.Ticket;
import lib.etickets.users.user.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    //Ovo je improvizacija dodavanja ticket-a od strane administratora radi testiranja funkcionalnosti
    @PostMapping("/addTicket")
    public ResponseEntity<?> addTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok().body(userService.addTicket(ticket));
    }

    @GetMapping("/getTickets")
    public ResponseEntity<?> getTickets(){
        return ResponseEntity.ok().body(userService.getTickets());
    }

    //Ovo je ekvivalent registraciji user-a, ali improvizovano radi testiranja ostalih funkcionalnosti
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @PostMapping("/payment/{userId}/{input}/{supervisorId}")
    public ResponseEntity<?> creditPayment(@PathVariable("userId") String userId, @PathVariable("input") double input, @PathVariable("supervisorId") String supervisorId){
        if(userService.creditPayment(userId, input, supervisorId))
            return ResponseEntity.ok().body("Success");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input error");
    }

    @PostMapping("/approval/{approval}/{comment}/{reqId}/{supervisorId}")
    public ResponseEntity<String> approval(@PathVariable("approval") boolean approval, @PathVariable("comment") String comment, 
    @PathVariable("reqId") String reqId, @PathVariable("supervisorId") String supervisorId){
        if(userService.approval(approval, comment, reqId, supervisorId) != null)
            return ResponseEntity.ok().body("");
        return ResponseEntity.badRequest().body("");
    }

     //Sofija
     @GetMapping("/getUserInfo/{userId}") 
     public ResponseEntity<?> getUserInfo(@PathVariable("userId") String userId){
        if(userService.getUserInfo(userId) != null)
             return ResponseEntity.ok().body(userService.getUserInfo(userId));
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserId error"); 
        // return ResponseEntity.ok().body(userService.getUserInfo(userId));
     }
}
