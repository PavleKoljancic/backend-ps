package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lib.etickets.transporter.Transporter;
import lib.etickets.transporter.route.Route;

public class TransportersRepo {
    //for testing purposes
    List<Transporter> transportersDb = Arrays.asList(new Transporter("Prevoznik1", "1",null),
            new Transporter("Prevoznik2", "2",null),
            new Transporter("Prevoznik3", "3",null));

    public List<Transporter> getAll(){
        return transportersDb;
    }

    public Transporter getTransporterByID(String id){
        return transportersDb.get(0);
    }

    public void deleteTransporterById(String id){

        //remove from db
    }

    public List<Route> getAllRoutesByTransporterID(String id){
        return transportersDb.get(0).getRoutes();
    }
}
