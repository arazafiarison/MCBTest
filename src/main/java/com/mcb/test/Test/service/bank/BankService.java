package com.mcb.test.Test.service.bank;

import com.mcb.test.Test.model.collection.bank.Bank;
import com.mcb.test.Test.model.dto.bank.BankListElementDTO;
import com.mcb.test.Test.repository.bank.BankRepository;
import com.mcb.test.Test.utils.converter.bank.BankDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    /**
     * Search bank
     * @param bankNameLike
     * @return
     */
    public List<BankListElementDTO> findBank(String bankNameLike) {
        List<BankListElementDTO> bankList = null;
        Optional<List<Bank>> bankSearchList = this.bankRepository.findByNameContaining(bankNameLike);
        if (bankSearchList.isPresent()) {
            bankList = BankDTOConverter.entityListToDTO(bankSearchList.get());
        }
        return bankList;
    }
}
