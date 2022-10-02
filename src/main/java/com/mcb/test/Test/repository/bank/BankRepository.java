package com.mcb.test.Test.repository.bank;

import com.mcb.test.Test.model.collection.bank.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends MongoRepository<Bank, String> {
    Optional<List<Bank>> findByNameContaining(String bankNameLike);
}
