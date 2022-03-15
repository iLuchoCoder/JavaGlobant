package com.mockito.Models;

import javax.persistence.*;

@Entity
@Table(name="bill")
public class Bill {
    @Id
    @SequenceGenerator(
            name="bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name="id_company",
            nullable = false
    )
    private int id_company;

    @Column(
            name="id_bill",
            nullable = false
    )
    private String id_bill;

    @Column(
            name="due_date",
            nullable = false
    )
    private int due_date;

    @Column(
            name="amount",
            nullable = false
    )
    private int amount;

    @Column(
            name="paid",
            nullable = false
    )
    private boolean paid;

    public Bill(){
        super();
    }

    public Bill(int id_company, String id_bill, int due_date, int amount, boolean paid) {
        this.id_company = id_company;
        this.id_bill = id_bill;
        this.due_date = due_date;
        this.amount = amount;
        this.paid = paid;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public String getId_bill() {
        return id_bill;
    }

    public void setId_bill(String id_bill) {
        this.id_bill = id_bill;
    }

    public int getDue_date() {
        return due_date;
    }

    public void setDue_date(int due_date) {
        this.due_date = due_date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id_company=" + id_company +
                ", id_bill=" + id_bill +
                ", due_date=" + due_date +
                ", amount=" + amount +
                ", paid=" + paid +
                '}';
    }
}
