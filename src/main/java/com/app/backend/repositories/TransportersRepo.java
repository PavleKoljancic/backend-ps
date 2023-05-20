package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.transporter.Transporter;

public class TransportersRepo {
    List<Transporter> transportersDb = new ArrayList<>();

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
}
