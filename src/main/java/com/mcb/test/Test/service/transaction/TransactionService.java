package com.mcb.test.Test.service.transaction;

import com.mcb.test.Test.model.collection.transaction.Transaction;
import com.mcb.test.Test.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public void saveTransaction(Transaction transaction) {

    }
}
