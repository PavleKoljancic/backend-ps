package com.app.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.backend.repositories.TicketRequestRepo;
import com.app.backend.repositories.UserRepository;

import lib.etickets.ticket.requests.TicketRequest;
import lib.etickets.users.user.User;

@Service
public class UserService {
    
    UserRepository userRepo = new UserRepository();
    TicketRequestRepo ticketRequestRepo;

    @Autowired
    public TransactionService transactionService;

    public List<User> getAllUsers(){
        return userRepo.getAll();
    }

    public String addUser(User user){
        userRepo.getUsersDb().add(user);
        return "Korisnik uspjesno kreiran";
    }

    public String creditPayment(String userId, double input, String supervisorId){
        userRepo.addCredit(userId, input);
        transactionService.newCreditTransaction(userId, input, null, supervisorId);
        return "Kredit uspjesno uplacen";
    }

    public String processRequest(TicketRequest newTicketRequest, TicketRequestRepo ticketRequestRepo){
        this.ticketRequestRepo = ticketRequestRepo;
        if(userRepo.hasFunds(newTicketRequest)){
            userRepo.updateUser(newTicketRequest);
            ticketRequestRepo.getTicketRequestsDb().remove(newTicketRequest);
            transactionService.newTicketTransaction(newTicketRequest.userId, newTicketRequest.requestedTicket.getPrice(), null);
            return "Korisnik azuriran uspjesno.";
        }
        else{
            ticketRequestRepo.getTicketRequestsDb().remove(newTicketRequest);
            return "Korisnik nema dovoljno kredita!";
        }
    }

    public String approval(boolean approval, String comment, String reqId){
        TicketRequest ticketRequest = ticketRequestRepo.get(reqId);
        if(approval){
            userRepo.updateUser(ticketRequest);
            ticketRequestRepo.getTicketRequestsDb().remove(ticketRequest);
            transactionService.newTicketTransaction(ticketRequest.userId, ticketRequest.requestedTicket.getPrice(), null);
        }
        else
            ticketRequestRepo.getTicketRequestsDb().remove(ticketRequest);
        return comment;
    }
}
