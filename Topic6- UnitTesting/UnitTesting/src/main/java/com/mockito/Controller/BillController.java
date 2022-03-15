package com.mockito.Controller;

import com.mockito.Models.Bill;
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

    @DeleteMapping(path="/deleteBillById/{id}")
    public void deleteBillById(@PathVariable Integer id){
        bservice.deleteBillById(id);
    }
}
