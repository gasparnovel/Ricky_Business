package edu.ricky.business.ricky;

public class CreditCard {
    
    private String owner = "";
    private String number = "";
    private String credit = "3000.0EIZ";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = credit;
        }
        
        
    public String getOwner() {
            return this.owner;
        }
    public String getNumber() {
            return this.number;
        }
    public String getCredit() {
        return this.credit;
    }
    
    @Override
    public String toString() {
        return "owner: " + getOwner() + '\n' +
                "number: " + getNumber() + '\n' +
                "credit: "+ getCredit();
    }
}
