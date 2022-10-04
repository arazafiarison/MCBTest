package com.mcb.test.Test.controller.transaction;

import com.mcb.test.Test.model.collection.transaction.Transaction;
import com.mcb.test.Test.model.dto.pagination.PaginationDTO;
import com.mcb.test.Test.service.transaction.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/transaction")
public class TransactionAPIController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody Transaction newTransaction) {
        return new ResponseEntity<>(this.transactionService.saveTransaction(newTransaction), HttpStatus.ACCEPTED);
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<Transaction>> findAll() {
        return new ResponseEntity<List<Transaction>>(this.transactionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByReference")
    public ResponseEntity<List<Transaction>> findByReference(@RequestParam("reference") String reference) {
        return new ResponseEntity<List<Transaction>>(this.transactionService.findByReference(reference), HttpStatus.OK);
    }
}
