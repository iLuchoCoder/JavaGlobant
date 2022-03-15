package com.mockito.Controller;

import com.mockito.Exceptions.InsufficientFundsException;
import com.mockito.Exceptions.InvalidBillIdException;
import com.mockito.Models.BankAccount;
import com.mockito.Models.Bill;
import com.mockito.Service.BankAccountService;
import com.mockito.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService bservice;

    @Autowired
    private BankAccountService baService;

    @GetMapping(path="/getBills")
    public List<Bill> listBills(){
        return bservice.listBills();
    }

    @GetMapping(path="/getBillsById/{id}")
    public ResponseEntity<Bill> getBillsById(@PathVariable Integer id){
        try{
            Bill b = bservice.getBillById(id);
            return new ResponseEntity<Bill>(b, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/registerBill")
    public void saveBill(@RequestBody Bill b){
        bservice.saveBill(b);
    }

    @PutMapping(path="/updateBillById/{id}")
    public ResponseEntity<?> updateBillById(@RequestBody Bill b, @PathVariable Integer id){
        try{
            Bill cExist = bservice.getBillById(id);

            cExist.setId_company(b.getId_company());
            cExist.setId_bill(b.getId_bill());
            cExist.setDue_date(b.getDue_date());
            cExist.setAmount(b.getAmount());

            bservice.saveBill(cExist);

            return new ResponseEntity<Bill>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/payBill/{billID}/{bankAccountID}")
    public ResponseEntity<?> payBill(@PathVariable Integer bill_ID, @PathVariable Integer bankAccountOrigin_ID) {

        BankAccount baOrigin = baService.getBankAccountById(bankAccountOrigin_ID);
        Bill bill = bservice.getBillById(bill_ID);

        double disccount = 0.0;

        String msg = "";

        try{
            if(!bill.getId_bill().startsWith("00") || bill.getId_bill().length()!=7){
                throw new InvalidBillIdException("InvalidBillIdException");
            }

            if((baOrigin.getAccountFounds()+(baOrigin.getAccountFounds()*0.2))<bill.getAmount()){
                throw new InsufficientFundsException("InsufficientFundsException");
            }
            else{
                if(baOrigin.getTypeAccount().toUpperCase().equals("CORRIENTE")){
                    disccount = bill.getAmount() * 0.1;
                    baOrigin.setAccountFounds(bill.getAmount()-disccount);
                    bill.setPaid(true);
                    msg = "Bill paid with disccount";
                    System.out.println(msg);
                }
                else{
                    baOrigin.setAccountFounds(bill.getAmount());
                    bill.setPaid(true);
                    msg = "Bill paid";
                    System.out.println(msg);
                }
            }
        }catch(InsufficientFundsException ex){
            System.out.println(ex.getMessage());
        }
        catch(InvalidBillIdException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(msg,HttpStatus.OK);
    }

    @DeleteMapping(path="/deleteBillById/{id}")
    public void deleteBillById(@PathVariable Integer id){
        bservice.deleteBillById(id);
    }
}
