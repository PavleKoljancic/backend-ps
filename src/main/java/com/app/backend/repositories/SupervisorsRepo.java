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
}
