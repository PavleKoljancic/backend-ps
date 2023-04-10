package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.ticket.Ticket;

public class TicketsRepo {

    public List<Ticket> ticketsDb = new ArrayList<>();
    
    //Ovo ce u stvari biti citanje polja ticketType iz baze
    public String getTicketTypeById(String id){
        for(Ticket t : ticketsDb)
            if(id.compareTo(t.getTicketId()) == 0)
                return t.getTicketType();
        return "";
    }

    //Ovo ce u stvari biti citanje citave vrste iz baze ticket-a
    public Ticket getTicketById(String id){
        for(Ticket t : ticketsDb)
            if(id.compareTo(t.getTicketId()) == 0)
                return t;
        return null;
    }

    public List<Ticket> getAll(){
        return ticketsDb;
    }
}
