package com.mcb.test.Test.model.collection.transaction;

import com.mcb.test.Test.model.collection.bank.BankEmbeded;
import com.mcb.test.Test.model.collection.location.RegionEmbeded;
import com.mcb.test.Test.model.enumeration.authentication.CurrencyEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Transaction {
    @Id
    private String id;
    private String reference;
    private Customer customer;
    private BigDecimal transferAmount;
    private CurrencyEnum transferCurrency;
    private BankEmbeded beneficiaryBank;
    private String beneficiaryAccountNumber;
    private String paymentDetails;
    private String cardDetails;
    private RegionEmbeded region;
}
