package com.app.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.backend.repositories.TransportersRepo;

import lib.etickets.transporter.Transporter;


@Service
public class TransporterService {

    TransportersRepo transportersRepo = new TransportersRepo();

    public List<Transporter> getTransporters(){
        return transportersRepo.getAll();
    }
}
