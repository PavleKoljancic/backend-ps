package com.app.backend.controllers;

import com.app.backend.services.RouteService;
import lib.etickets.transporter.route.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//zeljko
@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/save")
    public ResponseEntity<Route> save(@RequestBody Route route) {
        return ResponseEntity.ok().body(routeService.saveRoute(route));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name") String name) {
        routeService.deleteRoute(name);
        return ResponseEntity.noContent().build();
    }
}
