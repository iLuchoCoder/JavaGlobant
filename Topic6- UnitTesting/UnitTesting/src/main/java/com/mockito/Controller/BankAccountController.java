package com.mockito.Controller;

import com.mockito.Exceptions.InsufficientFundsException;
import com.mockito.Exceptions.InvalidTargetFundsException;
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

    @PutMapping(path = "/bankTransfer/{bankAccountOriginID}/{bankAccountDestinationID}/{transfer}")
    public ResponseEntity<?> bankTransfer(@PathVariable Integer bankAccountOrigin_ID, @PathVariable Integer bankAccountDestination_ID, @PathVariable Double transfer) {

        // Point A
        BankAccount baOrigin = baService.getBankAccountById(bankAccountOrigin_ID);
        BankAccount baDestination = baService.getBankAccountById(bankAccountDestination_ID);

        // Point B
        String typeBankAccountDestination = baDestination.getTypeAccount().toUpperCase();
        Double foundsDestination = baOrigin.getAccountFounds();

        // Point C
        double tax = 0.0;
        double transferImp = 0.0;

        String msg = "";

        try{
            int bankID = baOrigin.getBankID();
            Double foundsOrigin = baOrigin.getAccountFounds();
            if(bankID!=5)
            {
                foundsOrigin = foundsOrigin - 3500;
            }
            if(foundsOrigin<transfer){
                throw new InsufficientFundsException("InsufficientFundsException");
            }

            if(typeBankAccountDestination.equals("CORRIENTE") && foundsDestination<(transfer*3)){
                throw new InvalidTargetFundsException("InsufficientFundsException");
            }

            // Point C
            if(transfer >= 1500000){
                tax = (transfer * 0.03);
                transferImp = transfer  - tax;
                baOrigin.setAccountFounds(baOrigin.getAccountFounds()-transfer);
                baDestination.setAccountFounds(baDestination.getAccountFounds()+transferImp);
                msg = "Transfer complete with tax for destination bank account";
                System.out.println(msg);

            }
            else{
                baOrigin.setAccountFounds(baOrigin.getAccountFounds()-transfer);
                baDestination.setAccountFounds(baDestination.getAccountFounds()+transfer);
                msg = "Transfer complete between bank accounts with the same bank";
                System.out.println(msg);
            }
        }catch(InsufficientFundsException ex){
            System.out.println(ex.getMessage());
        } catch (InvalidTargetFundsException ex) {
            System.out.println(ex.getMessage());
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(msg,HttpStatus.OK);
    }

    @DeleteMapping(path="/deleteBankAccountById/{id}")
    public void deleteBankAccountById(@PathVariable Integer id){
        baService.deleteBankAccountById(id);
    }
}
