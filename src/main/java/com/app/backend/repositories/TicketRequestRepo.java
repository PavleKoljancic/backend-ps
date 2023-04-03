package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.ticket.requests.TicketRequest;
import lib.etickets.users.supervisor.Supervisor;

public class TicketRequestRepo {
    List<TicketRequest> ticketRequestsDb = new ArrayList<>();

    public List<TicketRequest> getTicketRequests(Supervisor supervisor){
        return ticketRequestsDb;
    }

    public void update(TicketRequest newTicketRequest){
        ticketRequestsDb.remove(newTicketRequest);
    }

    public TicketRequest get(String reqId){
        TicketRequest tmp = null;
        for(TicketRequest t : ticketRequestsDb){
            if(t.ticketRequestId.compareTo(reqId) == 0){
                tmp = t;
                break;
            }
        }
        return tmp;
    }

    public List<TicketRequest> getTicketRequestsDb() {
        return ticketRequestsDb;
    }

    public void setTicketRequestsDb(List<TicketRequest> ticketRequestsDb) {
        this.ticketRequestsDb = ticketRequestsDb;
    }
}
