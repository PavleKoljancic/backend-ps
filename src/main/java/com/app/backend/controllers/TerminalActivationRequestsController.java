package com.app.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.services.TerminalActivationRequestService;

import lib.etickets.terminal.activationrequests.TerminalActivationRequest;

@RestController
@RequestMapping("/terminalActivationRequests")
public class TerminalActivationRequestsController {
    
    @Autowired
    TerminalActivationRequestService terminalActivationRequestService;

    @PostMapping("/addTerminalActivationRequest")
    public ResponseEntity<String> addTerminalActivationRequest(@RequestBody TerminalActivationRequest terminalActivationRequest){
        if(terminalActivationRequestService.addTerminalActivationRequest(terminalActivationRequest))
        return ResponseEntity.ok().body("Added");
        
        return ResponseEntity.status(HttpStatus.CONFLICT).body("");
    }
}
