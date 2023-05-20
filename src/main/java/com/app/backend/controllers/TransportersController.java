package com.app.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.services.TransporterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lib.etickets.transporter.Transporter;

@RestController
@RequestMapping("/transporters")
public class TransportersController {
    
    @Autowired
    TransporterService transporterService;

    @GetMapping("/getTransporters")
    public ResponseEntity<List<Transporter>> getTransporters(){
        return ResponseEntity.ok().body(transporterService.getTransporters());
    }   

      //SOFIJA
      @PostMapping("/newTransporter")
      public ResponseEntity<String> newTransporter(@RequestBody Transporter transporter){
          if(transporterService.addTransporter(transporter))
              return ResponseEntity.ok().body("Added");
          return ResponseEntity.badRequest().body("Denied");
      }
}
