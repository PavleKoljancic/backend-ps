package com.app.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.backend.repositories.TicketRequestRepo;

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

    public boolean addTicketRequest(TicketRequest newTicketRequest){
        if("Periodic".compareTo(userService.ticketsRepo.getTicketTypeById(newTicketRequest.getRequestedTicketId())) == 0){
            ticketRequestRepo.getTicketRequestsDb().add(newTicketRequest);
            return true;
        }
        else if("Amount".compareTo(userService.ticketsRepo.getTicketTypeById(newTicketRequest.getRequestedTicketId())) == 0)
            return userService.processRequest(newTicketRequest, ticketRequestRepo);
        else
            return false;
    }
}