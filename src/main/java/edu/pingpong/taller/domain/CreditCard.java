package edu.pingpong.taller.domain;


public class CreditCard {
    
    private final String owner;
    private final String number;
    private Double credit = 3000.0d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    public boolean pay(double charge){
        if (charge <= this.credit) {
            this.credit -= charge;
            return true;
        } else {
            return false;
        }
    }

    public String number() {
        return this.number;
    }

    public String cardOwner() {
        return this.owner;
    }

    public double credit(){
        return this.credit;
    }

    @Override
    public String toString() {
        return "owner: " + cardOwner() + '\n' + 
                "number: " + number() + '\n' +
                "credit: " + credit() + SYMBOL;
    }
}
