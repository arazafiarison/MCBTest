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

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction saveTransaction(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    public List<Transaction> findAll(PaginationDTO pagination) {
        Pageable pageable = PageRequest.of(
                pagination.getPageIndex(),
                pagination.getPageSize(),
                Sort.by("creationDate").descending()
        );
        Page<Transaction> transactions = this.transactionRepository.findAll(pageable);
        if (transactions.isEmpty()) {
          return null;
        } else {
            return transactions.stream().toList();
        }
    }
}
