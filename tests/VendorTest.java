import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {
    static Vendor vendor;

    @BeforeEach
    public void setup(){
        vendor = new Vendor(2,4);
    }
    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void addMoneyTest(){
        vendor.addMoney(10);
        assertEquals(10, vendor.getBalance(), 0.001);

    }

}

