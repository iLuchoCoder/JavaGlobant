package com.mockito.Controller;

import com.mockito.Exceptions.InsufficientFundsException;
import com.mockito.Models.BankAccount;
import com.mockito.Service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService baService;

    @GetMapping(path="/getBankAccounts")
    public List<BankAccount> listBanksAccounts(){
        return baService.listBankAccount();
    }

    @GetMapping(path="/getBankAccountById/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Integer id){
        try{
            BankAccount ba = baService.getBankAccountById(id);
            return new ResponseEntity<BankAccount>(ba, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<BankAccount>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/registerBankAccount")
    public void saveCourse(@RequestBody BankAccount ba){
        baService.saveBankAccount(ba);
    }

    @PutMapping(path="/updateBankAccountById/{id}")
    public ResponseEntity<?> updateBankAccountById(@RequestBody BankAccount ba, @PathVariable Integer id){
        try{
            BankAccount cExist = baService.getBankAccountById(id);

            cExist.setTypeAccount(ba.getTypeAccount());
            cExist.setTitularAccountName(ba.getTitularAccountName());
            cExist.setTitularAccountID(ba.getTitularAccountID());
            cExist.setAccountFounds(ba.getAccountFounds());
            cExist.setBankID(ba.getBankID());

            baService.saveBankAccount(cExist);

            return new ResponseEntity<BankAccount>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<BankAccount>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/bankTransfer")
    public void bankTransfer(@PathVariable Integer bankAccountOrigin_ID, @PathVariable Integer bankAccountDestination_ID, @PathVariable Double transfer) {
        BankAccount baOrigin = baService.getBankAccountById(bankAccountOrigin_ID);
        BankAccount baDestination = baService.getBankAccountById(bankAccountDestination_ID);
        try{
            if(baOrigin.getAccountFounds()<transfer){
                throw new InsufficientFundsException("InsufficientFundsException");
            }

        }catch(InsufficientFundsException ex){
            System.out.println(ex.getMessage());
        }

    }

    @DeleteMapping(path="/deleteBankAccountById/{id}")
    public void deleteBankAccountById(@PathVariable Integer id){
        baService.deleteBankAccountById(id);
    }
}
