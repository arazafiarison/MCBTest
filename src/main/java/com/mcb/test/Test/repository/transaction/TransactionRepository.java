package com.mcb.test.Test.repository.transaction;

import com.mcb.test.Test.model.collection.transaction.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public Optional<List<Transaction>> findByReferenceContaining(String reference);
}
