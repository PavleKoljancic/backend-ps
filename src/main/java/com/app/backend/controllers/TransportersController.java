package com.app.backend.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lib.etickets.transporter.route.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Transporter>> getTransporters() {
        return ResponseEntity.ok().body(transporterService.getTransporters());
    }   

      //SOFIJA
      @PostMapping("/newTransporter")
      public ResponseEntity<String> newTransporter(@RequestBody Transporter transporter){
          if(transporterService.addTransporter(transporter))
              return ResponseEntity.ok().body("Added");
          return ResponseEntity.badRequest().body("Denied");
      

    }

    //zeljko get, delete, get
    @GetMapping("/transporter/{id}")
    public ResponseEntity<Transporter> getTransporterById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(transporterService.getTransporterById(id));
    }

    @DeleteMapping("/transporter/{id}")
    public ResponseEntity<?> deleteTransporterById(@PathVariable(name = "id") String id) {
        transporterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/transporter/{id}/routes")
    public ResponseEntity<List<Route>> getRoutesForTransporter(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(transporterService.getRoutesByTransporterId(id));
    }

}
