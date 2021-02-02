package edu.pingpong.taller;


public class CreditCard {
    
    private String owner = "";
    private String number = "";
    private Double credit = 0d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = 3000.0d;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getNumber() {
        return this.number;
    }

    public String getCredit() {
        return this.credit.toString();
    }

    @Override
    public String toString() {
        return "owner: " + getOwner() + '\n' + 
                "number: " + getNumber() + '\n' +
                "credit: " + getCredit() + SYMBOL;
    }
}
