package edu.ricky.business.ricky;

public class CreditCard {
    
    private String owner = "";
    private String number = "";
    private double credit = 3000d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = credit;
        }
    
    public boolean pay(double charge) {
        if (charge <= this.credit) {
            this.credit -= charge;
            return true;
        } else {
            return false;
        }
    }
        
        
    public String getOwner() {
            return this.owner;
        }
    public String getNumber() {
            return this.number;
        }
    public double getCredit() {
        return this.credit;
    }
    
    @Override
    public String toString() {
        return "owner: " + getOwner() + '\n' +
                "number: " + getNumber() + '\n' +
                "credit: "+ getCredit() + this.SYMBOL;
    }
}
