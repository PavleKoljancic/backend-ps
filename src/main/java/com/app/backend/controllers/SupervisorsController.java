package com.app.backend.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.backend.services.SupervisorsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lib.etickets.users.supervisor.Supervisor;

@RestController
@RequestMapping("/supervisors")
public class SupervisorsController {
    
    @Autowired
    SupervisorsService supervisorsService;

    //treba li provjera za validnost administratora?
    @GetMapping("/getSupervisors")
    public ResponseEntity<List<Supervisor>> getSupervisors(){
        return ResponseEntity.ok().body(supervisorsService.getSupervisors());
    }
}
