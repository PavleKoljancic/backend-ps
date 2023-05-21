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


      //SOFIJA

      public Transporter getTransporterById(String reqId){
        Transporter tmp = null;
         for(Transporter t : transportersDb){
             if(t.getTransporterId().compareTo(reqId) == 0){
                 tmp = t;
                 break;
             }
         }
         return tmp;
     }
 
     public boolean transporterExists(String reqId){
          for(Transporter t : transportersDb){
              if(t.getTransporterId().compareTo(reqId) == 0){
                  return true;
              }
          }
          return false;
      }
 
        /* 
     public boolean addTransporter(Transporter transporter)
     {
         if(!transportersDb.constains(transporter))
         {
             transportersDb.add(transporter);
             return true;
         }
         return false;
     }
     */

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
