package edu.ricky.business.ricky;

import edu.ricky.business.ricky.CreditCard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CreditCardTest {
    @Test
    public void contructor_test() {
        CreditCard card = new CreditCard("Rick", "123456789");
        assertNotNull(card);
    }

    @Test 
    public void getOwner_test() {
        CreditCard card = new CreditCard("Rick", "123456789");
        assertEquals("Rick", card.getOwner());
    }

    @Test 
    public void getNumber() {
        CreditCard card = new CreditCard("Rick", "123456789");
        assertEquals("123456789", card.getNumber());
    }
}
