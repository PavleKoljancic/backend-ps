package com.app.backend.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.backend.repositories.TicketRequestRepo;
import com.app.backend.repositories.TicketsRepo;
import com.app.backend.repositories.UserRepository;

import lib.etickets.ticket.Ticket;
import lib.etickets.ticket.requests.TicketRequest;
import lib.etickets.ticket.response.TicketApprovalResponse;
import lib.etickets.users.user.User;

@Service
public class UserService {
    
    UserRepository userRepo = new UserRepository();
    TicketRequestRepo ticketRequestRepo;
    TicketsRepo ticketsRepo = new TicketsRepo();

    @Autowired
    public TransactionService transactionService;
    
    public boolean addTicket(Ticket ticket){
        ticketsRepo.ticketsDb.add(ticket);
        return true;
    }
    
    public List<Ticket> getTickets(){
        //Ovo se naknadno treba izmjeniti da filtrira
        //Tj da ne vraca sve 
        return ticketsRepo.getAll();
    }

    public List<User> getUsers(){
        //Ovo se naknadno treba izmjeniti da filtrira
        //Tj da ne vraca sve 
        return userRepo.getAll();
    }

    public boolean addUser(User user){
        //Ovdje se mora izvrsiti provjera prije dodavanja
        return userRepo.getUsersDb().add(user);

    }

    public boolean creditPayment(String userId, double input, String supervisorId){
        if(input > 0){
            userRepo.addCredit(userId, input);
            transactionService.newCreditTransaction(userId, input, null, supervisorId);
            return true;
        }
        else
            return false;
    }

    public boolean processRequest(TicketRequest newTicketRequest, TicketRequestRepo ticketRequestRepo){
        //TicketRequestRepo kao parametar da bi se postavio atribut, jer nemamo anotaciju za klasu koja radi sa bazom te samim tim ne mozemo povezati
        //atribut automatski pomocu spring boot-a 
        this.ticketRequestRepo = ticketRequestRepo;
        Ticket t = ticketsRepo.getTicketById(newTicketRequest.getRequestedTicketId());
        User userToUpdate = userRepo.getUserById(newTicketRequest.getUserId());
        boolean approval = false;
        if(userToUpdate != null){
            if(userRepo.hasFunds(newTicketRequest.getUserId(), t.getPrice())){
                userRepo.updateUser(newTicketRequest, t);
                transactionService.newTicketTransaction(newTicketRequest.userId, t.getPrice(), LocalDate.now());
                approval = true;
            }
            userRepo.addTicketApprovalResponse(new TicketApprovalResponse(LocalDate.now(), "System processed response.", approval, t, "System"), userToUpdate);
            return true;
        }
        else
            return false;
    }

    public String approval(boolean approval, String comment, String reqId, String supervisorId){
        TicketRequest ticketRequest = ticketRequestRepo.get(reqId);
        User userToUpdate = userRepo.getUserById(ticketRequest.getUserId());
        if(userToUpdate != null){
            //Pronadji ime supervizora u bazi
            //String supervizorName = SupervisorRepo.getNameById(String supervisorId);
            Ticket t = ticketsRepo.getTicketById(ticketRequest.getRequestedTicketId());
            if(approval && userRepo.hasFunds(userToUpdate.getUserId(), t.getPrice())){
                userRepo.updateUser(ticketRequest, t);
                transactionService.newTicketTransaction(ticketRequest.userId, t.getPrice(), LocalDate.now());
            }
            else
                approval = false;
                
            ticketRequestRepo.getTicketRequestsDb().remove(ticketRequest);

            userRepo.addTicketApprovalResponse(new TicketApprovalResponse(LocalDate.now(), comment, approval, 
            t, "supervisor name"), userToUpdate);

            return "0";
        }
        else
            return null;
    }

     //Sofija
     public User getUserInfo(String userId)
     {
         return userRepo.getUserById(userId);
     }
}
