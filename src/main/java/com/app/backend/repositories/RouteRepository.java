package com.app.backend.repositories;

import lib.etickets.transporter.route.Route;
import org.springframework.stereotype.Repository;

//zeljko
@Repository
public interface RouteRepository {

    Route save(Route route);

    String deleteByName(String name); //no id
}
