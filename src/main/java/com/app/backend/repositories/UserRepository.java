package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.ticket.requests.TicketRequest;
import lib.etickets.users.user.User;

public class UserRepository {
    private List<User> usersDb = new ArrayList<>();

    public List<User> getAll(){
        return getUsersDb();
    }

    public List<User> getUsersDb() {
        return usersDb;
    }

    public void setUsersDb(List<User> usersDb) {
        this.usersDb = usersDb;
    }

    public void addCredit(String userId, double input){
        for(User u : getUsersDb())
            if(u.getUserId().compareTo(userId) == 0){
                u.setCredit(u.getCredit() + input);
            }
    }

    public boolean hasFunds(TicketRequest newTicketRequest){
        User user = null;
        for(User u : getUsersDb())
            if(u.getUserId().compareTo(newTicketRequest.userId) == 0){
                user = u;
                break;
            }
        if(user.getCredit() >= newTicketRequest.requestedTicket.getPrice())
            return true;
        else
            return false;
    }

    public void updateUser(TicketRequest newTicketRequest){
        User userToUpdate = null;
        for(User u : getUsersDb())
            if(u.getUserId().compareTo(newTicketRequest.userId) == 0)
                userToUpdate = u;
        userToUpdate.setCredit(userToUpdate.getCredit() - newTicketRequest.requestedTicket.getPrice());
        userToUpdate.getMyTickets().add(newTicketRequest.requestedTicket);
        /*if(userToUpdate.documents.size() != 0)
            userToUpdate.documents.remove(1);
        if(newTicketRequest.document != null)
            userToUpdate.documents.add(newTicketRequest.document);*/
    }

}
