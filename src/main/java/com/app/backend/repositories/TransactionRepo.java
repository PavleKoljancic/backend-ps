package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.transactions.Transaction;

public class TransactionRepo {
    List<Transaction> transactionDb = new ArrayList<>();

    public List<Transaction> getTransactionDb() {
        return transactionDb;
    }

    public void setTransactionDb(List<Transaction> transactionDb) {
        this.transactionDb = transactionDb;
    }
}
