package com.app.backend.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lib.etickets.ticket.Ticket;
import lib.etickets.ticket.amount.AmountTicket;
import lib.etickets.ticket.periodic.PeriodicTicket;
import lib.etickets.ticket.requests.TicketRequest;
import lib.etickets.ticket.response.TicketApprovalResponse;
import lib.etickets.users.user.User;

public class UserRepository {
    private List<User> usersDb = new ArrayList<>();
    Random rand = new Random();

    public List<User> getAll(){
        return getUsersDb();
    }

    public User getUserById(String userId){
        for(User u : usersDb)
            if(userId.compareTo(u.getUserId()) == 0)
                return u;
        return null;
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

    public boolean hasFunds(String userId, double ticketPrice){
        User user = null;
        for(User u : getUsersDb())
            if(u.getUserId().compareTo(userId) == 0){
                user = u;
                break;
            }
        if(user.getCredit() >= ticketPrice)
            return true;
        else
            return false;
    }

    public void updateUser(TicketRequest newTicketRequest, Ticket t){
        User userToUpdate = null;
        for(User u : getUsersDb())
            if(u.getUserId().compareTo(newTicketRequest.userId) == 0)
                userToUpdate = u;
        userToUpdate.setCredit(userToUpdate.getCredit() - t.getPrice());

        Ticket ticketToAdd = null;
        //Specijalizovani atributi ce se citati iz baze, ovdje random jer ne moze drugacije da se improvizuje (zbog kastovanja nemamo pristup)
        if("Periodic".compareTo(t.getTicketType()) == 0){
            ticketToAdd = new PeriodicTicket(t.getName(), String.valueOf(rand.nextInt(100)), t.isNeedsDocumentation(), t.getTransporters(), t.getPrice(), 
            "Periodic", rand.nextInt(100), LocalDate.now(), LocalDate.now().plusDays(rand.nextInt(100)));
            userToUpdate.getMyTickets().add(ticketToAdd);
        }
        else if("Amount".compareTo(t.getTicketType()) == 0){
            ticketToAdd = new AmountTicket(t.getName(), String.valueOf(rand.nextInt(100)), t.isNeedsDocumentation(), t.getTransporters(), t.getPrice(), "Amount", rand.nextInt(100));
            userToUpdate.getMyTickets().add(ticketToAdd);
        }
    }

    public void addTicketApprovalResponse(TicketApprovalResponse res, User userToUpdate){

        //Dodaj u bazu
        userToUpdate.getTicketApprovalResponses().add(res);
    }
}
