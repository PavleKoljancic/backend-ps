package com.app.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.services.TicketRequestsService;

import lib.etickets.ticket.requests.TicketRequest;
import lib.etickets.users.supervisor.Supervisor;

@RestController
@RequestMapping("/api/ticketRequests")
public class TicketRequestsController {
    @Autowired
    TicketRequestsService ticketService;

    @PostMapping("/getRequests")
    public ResponseEntity<List<TicketRequest>> getRequests(@RequestBody Supervisor supervisor){

        return ResponseEntity.ok().body(ticketService.getTicketRequests(supervisor));
    }

    @PostMapping("/addTicketRequest")
    public ResponseEntity<String> addTicketRequest(@RequestBody TicketRequest ticketRequest){
        if(ticketService.addTicketRequest(ticketRequest))
            return ResponseEntity.ok().body("Added");
        return ResponseEntity.badRequest().body("Denied");
    }
}
