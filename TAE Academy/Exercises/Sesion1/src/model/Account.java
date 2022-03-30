package model;

public class Account {

    private String owner_name;
    private float balance;

    public Account(String owner_name, float balance) {
        super();
        this.owner_name = owner_name;
        this.balance = balance;
    }

    public Account() {
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void addMoney(float money){
        this.balance = this.balance + money;
    }

    public void withdrawMoney(float money){
        this.balance = this.balance - money;
    }
}
