package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.transporter.Transporter;

public class TransportersRepo {
    List<Transporter> transportersDb = new ArrayList<>();

    public List<Transporter> getAll(){
        return transportersDb;
    }
}
