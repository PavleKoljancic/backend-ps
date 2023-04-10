package com.app.backend.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.backend.repositories.TransactionRepo;

import lib.etickets.transactions.CreditTransaction;
import lib.etickets.transactions.TicketTransaction;
import lib.etickets.transactions.Transaction;

@Service
public class TransactionService {

    TransactionRepo transactionRepo = new TransactionRepo();

    public void newTicketTransaction(String userId, double amount, LocalDate date){
        transactionRepo.getTransactionDb().add(new TicketTransaction(userId, amount, date));
    }

    public void newCreditTransaction(String userId, double amount, LocalDate date, String supervisorId){
        transactionRepo.getTransactionDb().add(new CreditTransaction(userId, amount, date, supervisorId));
    }

    public List<Transaction> getTransactions(){
        return transactionRepo.getTransactionDb();
    }
}
