package com.app.backend.services;

import java.util.List;

import lib.etickets.transporter.route.Route;
import org.springframework.stereotype.Service;

import com.app.backend.repositories.TransportersRepo;

import lib.etickets.transporter.Transporter;


@Service
public class TransporterService {

    TransportersRepo transportersRepo = new TransportersRepo();

    public List<Transporter> getTransporters(){
        return transportersRepo.getAll();
    }

    public Transporter getTransporterById(String id){
        return transportersRepo.getTransporterByID(id);
    }

    public void deleteById(String id){
        transportersRepo.deleteTransporterById(id);
    }

    public List<Route> getRoutesByTransporterId(String id){
        return transportersRepo.getAllRoutesByTransporterID(id);
    }

}
