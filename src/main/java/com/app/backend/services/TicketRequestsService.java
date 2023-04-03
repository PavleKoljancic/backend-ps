package com.app.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.backend.repositories.TicketRequestRepo;

import lib.etickets.ticket.periodic.PeriodicTicket;
import lib.etickets.ticket.requests.TicketRequest;
import lib.etickets.users.supervisor.Supervisor;

@Service
public class TicketRequestsService {

    TicketRequestRepo ticketRequestRepo = new TicketRequestRepo();
    @Autowired
    UserService userService;

    public List<TicketRequest> getTicketRequests(Supervisor supervisor){
        return ticketRequestRepo.getTicketRequests(supervisor);
    }

    public String addTicketRequest(TicketRequest newTicketRequest){
        if(newTicketRequest.requestedTicket instanceof PeriodicTicket){
            ticketRequestRepo.getTicketRequestsDb().add(newTicketRequest);
            return "Dodan novi periodic ticket request.";
        }
        else
            return userService.processRequest(newTicketRequest, ticketRequestRepo);
    }
}
