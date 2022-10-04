package com.mcb.test.Test.service.transaction;

import com.mcb.test.Test.model.collection.transaction.Transaction;
import com.mcb.test.Test.model.dto.pagination.PaginationDTO;
import com.mcb.test.Test.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction saveTransaction(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        List<Transaction> transactions = this.transactionRepository.findAll();
        if (transactions == null) {
          return null;
        } else {
            return transactions;
        }
    }

    public List<Transaction> findByReference(String reference) {
        Optional<List<Transaction>> transactions = this.transactionRepository.findByReferenceContaining(reference);
        if (transactions.isPresent()) {
            return transactions.get();
        }
        return null;
    }
}
