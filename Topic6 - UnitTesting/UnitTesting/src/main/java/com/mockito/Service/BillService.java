package com.mockito.Service;

import com.mockito.Models.BankAccount;
import com.mockito.Models.Bill;
import com.mockito.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository BillRepo;

    public List<Bill> listBills() {
        return BillRepo.findAll();
    }

    public void saveBill(Bill bill) {
        BillRepo.save(bill);
    }

    public Bill getBillById(Integer id) {
        return BillRepo.findById(id).get();
    }

    public void deleteBillById(Integer id) {
        BillRepo.deleteById(id);
    }

    public void payBill(Bill bill, BankAccount bankAccount){
    }
}
