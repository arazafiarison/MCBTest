package com.mcb.test.Test.controller.bank;

import com.mcb.test.Test.model.dto.bank.BankListElementDTO;
import com.mcb.test.Test.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankAPIController {

    @Autowired
    private BankService bankService;

    @GetMapping("/findBanks")
    public ResponseEntity<List<BankListElementDTO>> findBank(@RequestParam("bankName") String bankName) {
        return new ResponseEntity<List<BankListElementDTO>>(this.bankService.findBank(bankName), HttpStatus.OK);
    }
}
