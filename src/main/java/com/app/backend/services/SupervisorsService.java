package com.app.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.backend.repositories.SupervisorsRepo;

import lib.etickets.users.supervisor.Supervisor;
//import lib.etickets.transporter.Transporter;
//import lib.etickets.users.generaluser.GeneralUser;


@Service
public class SupervisorsService {
    
    SupervisorsRepo supervisorsRepo = new SupervisorsRepo();

    public List<Supervisor> getSupervisors(){
        return supervisorsRepo.getAll();
    }

    public Supervisor getSupervisorById(String id){
        return supervisorsRepo.getSupervisorById(id);
    }
}
