package com.app.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.services.TransactionService;

import lib.etickets.transactions.Transaction;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/getTransactions")
    public ResponseEntity<List<Transaction>> getRequests(){
        return ResponseEntity.ok().body(transactionService.getTransactions());
    }
}
