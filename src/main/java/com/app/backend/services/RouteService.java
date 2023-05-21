package com.app.backend.services;

import com.app.backend.repositories.RouteRepository;
import lib.etickets.transporter.route.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route saveRoute(Route route){
        return routeRepository.save(route);
    }

    public String deleteRoute(String name){
        return routeRepository.deleteByName(name);
    }
}
