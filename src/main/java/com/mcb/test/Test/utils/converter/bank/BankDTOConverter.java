package com.mcb.test.Test.utils.converter.bank;

import com.mcb.test.Test.model.collection.bank.Bank;
import com.mcb.test.Test.model.dto.bank.BankListElementDTO;

import java.util.ArrayList;
import java.util.List;

public class BankDTOConverter {

    public static BankListElementDTO entityToDTO(Bank bank) {
        BankListElementDTO bankDto = null;
        if (bank != null) {
            bankDto = new BankListElementDTO();
            bankDto.setBankId(bank.getId());
            bankDto.setBankName(bank.getName());
        }
        return bankDto;
    }

    public static List<BankListElementDTO> entityListToDTO(List<Bank> bankList) {
        List<BankListElementDTO> bankListDto = null;
        if (bankList != null) {
            if (bankList.size() > 0) {
                bankListDto = new ArrayList<BankListElementDTO>();
                for (Bank bankTemp : bankList) {
                    bankListDto.add(BankDTOConverter.entityToDTO(bankTemp));
                }
            }
        }
        return bankListDto;
    }
}
