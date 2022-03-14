package com.mockito.Models;

import javax.persistence.*;

@Entity
@Table(name="bank_account")
public class BankAccount {
    @Id
    @SequenceGenerator(
            name="bankacc_sequence",
            sequenceName = "bankacc_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bankacc_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name="type_account",
            nullable = false,
            columnDefinition ="TEXT"
    )
    private String typeAccount;

    @Column(
            name="titular_account_name",
            nullable = false,
            columnDefinition ="TEXT"
    )
    private String titularAccountName;

    @Column(
            name="titular_account_id",
            nullable = false
    )
    private int titularAccountID;

    @Column(
            name="account_founds",
            nullable = false
    )
    private double accountFounds;

    @Column(
            name="bank_id",
            nullable = false
    )
    private int bankID;

    public BankAccount(String typeAccount, String titularAccountName, int titularAccountID, double accountFounds, int bankID) {
        this.typeAccount = typeAccount;
        this.titularAccountName = titularAccountName;
        this.titularAccountID = titularAccountID;
        this.accountFounds = accountFounds;
        this.bankID = bankID;
    }

    public BankAccount(){
        super();
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getTitularAccountName() {
        return titularAccountName;
    }

    public void setTitularAccountName(String titularAccountName) {
        this.titularAccountName = titularAccountName;
    }

    public int getTitularAccountID() {
        return titularAccountID;
    }

    public void setTitularAccountID(int titularAccountID) {
        this.titularAccountID = titularAccountID;
    }

    public double getAccountFounds() {
        return accountFounds;
    }

    public void setAccountFounds(double accountFounds) {
        this.accountFounds = accountFounds;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", typeAccount='" + typeAccount + '\'' +
                ", titularAccountName='" + titularAccountName + '\'' +
                ", titularAccountID=" + titularAccountID +
                ", accountFounds=" + accountFounds +
                ", bankID=" + bankID +
                '}';
    }
}
