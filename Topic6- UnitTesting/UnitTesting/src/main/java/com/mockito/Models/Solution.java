package com.mockito.Models;

import com.mockito.Exceptions.InsufficientFundsException;
import com.mockito.Exceptions.InvalidBillIdException;
import com.mockito.Exceptions.InvalidTargetFundsException;

public class Solution {
    static BankAccount ba1 = new BankAccount("AHORROS","JHON SMITH",254266458,1000000,5);
    static BankAccount ba2= new BankAccount("CORRIENTE","MARIA HAMILTON",58545258,25000000,3);

    static Bill b1 = new Bill(4,"0054869",20220405,2000000,false);
    static Bill b2 = new Bill(4,"548422878",20220405,24000,false);

    public String payBill(int chooseBill, int chooseBankAccount){
        BankAccount baOrigin;
        Bill bill;

        if(chooseBankAccount==1){
            baOrigin = ba1;
        }
        else{
            baOrigin = ba2;
        }

        if(chooseBill==1){
            bill = b1;
        }
        else{
            bill = b2;
        }

        double disccount = 0.0;

        String msg = "";

        try{
            if(!bill.getId_bill().startsWith("00") || bill.getId_bill().length()!=7){
                msg = "InvalidBillIdException";
                throw new InvalidBillIdException("InvalidBillIdException");
            }

            if((baOrigin.getAccountFounds()+(baOrigin.getAccountFounds()*0.2))<bill.getAmount()){
                msg ="InsufficientFundsException";
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
        return msg;
    }

    public String bankTransfer(double transfer) {

        // Point A
        BankAccount baOrigin = ba1;
        BankAccount baDestination = ba2;

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
                msg = "InsufficientFundsException";
                throw new InsufficientFundsException("InsufficientFundsException");
            }

            if(typeBankAccountDestination.equals("CORRIENTE") && foundsDestination<(transfer*3)){
                msg = "InvalidTargetFundsException";
                throw new InvalidTargetFundsException("InvalidTargetFundsException");
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
        return msg;
    }
}
