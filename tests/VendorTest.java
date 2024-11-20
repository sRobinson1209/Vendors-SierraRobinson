import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
//    @Test
//    public void buyItemTest(){
//        vendor.addMoney(1.50);
//        vendor.select("Candy");
//        //assertEquals(1,1);
//        assertEquals(1.25, vendor.Stock.get("Candy").stock);
//        assertEquals(0.25, vendor.getBalance());
//    }
   // @Test
//    void testRestockNewItem() {
//        // Arrange
//        Item inventory = new Item(); // Replace with the actual class name
//
//        // Act
//        inventory.restock(2,1, 1.25);
//
//        // Assert
//        //assertTrue(inventory.Stock.containsKey("Candy"));
//        assertEquals(20, inventory.Stock.get("Candy").getStock());
//        assertEquals(0.5, inventory.Stock.get("Candy").getPrice(), 0.001);
//    }
    @Test
    void changeItemNameTest(){
        vendor.changeItemName("Candy", "Twix Bar");
        Assertions.assertTrue(vendor.Stock.containsKey("Twix Bar"));
        Assertions.assertFalse(vendor.Stock.containsKey("Candy"));
    }

    @Test
    void removeItemTest(){
        vendor.removeItem("Gum");
        Assertions.assertFalse(vendor.Stock.containsKey("Gum"));
    }
    @Test
    void getDescriptionTest(){
        Item item = new Item(5, 3, "King sized sour skittles");
        assertEquals("King sized sour skittles" ,item.getDescription());
    }

}

