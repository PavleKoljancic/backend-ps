package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lib.etickets.users.supervisor.Supervisor;
//import lib.etickets.transporter.Transporter;
//import lib.etickets.users.generaluser.GeneralUser;

public class SupervisorsRepo {
    

    private List<Supervisor> supervisorsDb = new ArrayList<>();

    public List<Supervisor> getAll(){
        return getSupervisorsDb();
    }

    public List<Supervisor> getSupervisorsDb() {
        return supervisorsDb;
    }

    public Supervisor getSupervisorById(String reqId){
        Supervisor tmp = null;
         for(Supervisor t : supervisorsDb){
             if(t.getUserId().compareTo(reqId) == 0){
                 tmp = t;
                 break;
             }
         }
         return tmp;
     }

     public boolean supervisorExists(String reqId){
        for(Supervisor t : supervisorsDb){
            if(t.getUserId().compareTo(reqId) == 0){
                return true;
            }
        }
        return false;
    }
}
