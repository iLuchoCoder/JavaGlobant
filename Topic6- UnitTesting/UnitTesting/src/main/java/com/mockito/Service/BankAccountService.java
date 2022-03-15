package com.mockito.Service;

import com.mockito.Models.BankAccount;
import com.mockito.Repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository BankAccountRepo;

    public List<BankAccount> listBankAccount() {
        return BankAccountRepo.findAll();
    }

    public void saveBankAccount(BankAccount bankaccount) {
        BankAccountRepo.save(bankaccount);
    }

    public BankAccount getBankAccountById(Integer id) {
        return BankAccountRepo.findById(id).get();
    }

    public void deleteBankAccountById(Integer id) {
        BankAccountRepo.deleteById(id);
    }

    public void bankTransfer(Integer bankAccountOrigin_ID, Integer bankAccountDestination_ID, Double transfer){
    }
}
