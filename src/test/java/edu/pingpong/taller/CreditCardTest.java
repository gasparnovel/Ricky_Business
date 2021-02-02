package edu.pingpong.taller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

    private CreditCard card = null;

    @Before
    public void setup_card() {
        this.card = new CreditCard("Rick", "123456789");
        assertNotNull(card);
    }

    @Test
    public void constructor_test() {
        assertNotNull(this.card);
    }

    @Test
    public void getOwner_test() {
        assertEquals("Rick", this.card.getOwner());      
    }

    @Test
    public void getNumber_test() {
        assertEquals("123456789", this.card.getNumber());
    }

    @Test
    public void getCredit_test() {
        assertEquals("3000.0", this.card.getCredit());
    }
    
}
