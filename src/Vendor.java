import javax.sound.midi.SysexMessage;
import java.util.HashMap;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vendor {
    public static HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;
    private HashMap<String, Integer> purchaseHistory = new HashMap<>();

    Vendor(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy,"Chocolate Bar"));
        Stock.put("Gum", new Item(.5, numGum, "Orbit Spreamint Gum"));
        this.balance = 0;
    }

    /**
     * resets the Balance to 0
     */
    void resetBalance() {
        this.balance = 0;
    }

    /**
     * returns the current balance
     */
    double getBalance() {
        return this.balance;
    }

    /**
     * adds money to the machine's balance
     *
     * @param amt how much money to add
     */
    void addMoney(double amt) {
        this.balance = this.balance + amt;
    }

    /**
     * attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                if (item.stock > 0) { // Assuming getStock() checks item quantity
                    item.purchase(1);
                    this.balance = this.balance - item.price;

                    purchaseHistory.put(name, purchaseHistory.getOrDefault(name, 0) + 1);

                    System.out.println("Purchase Successful");
                } else {
                    System.out.println(name + " is out of stock.");
                }
            } else {
                System.out.println("Gimme more money");
            }
        } else {
            System.out.println("Sorry, don't know that item.");
        }
    }
    void restock(String name, int amount, double price){
        if(Stock.containsKey(name)){
            Stock.get(name).restock(amount);
        } else {
            Stock.put(name, new Item(price, amount, name));
        }
        System.out.println(name + "Restocked with " + amount + "Pieces");
    }
    void changeItemName(String oldName, String newName){
        if(Stock.containsKey(oldName)){
            Item item = Stock.remove(oldName);
            Stock.put(newName, item);
            System.out.println("Item renamed to " + newName);
        } else {
            System.out.println("Item "+ oldName +"Not found");
        }
    }
    void removeItem(String name){
        if(Stock.containsKey(name)){
            Stock.remove(name);
            System.out.println("Item " + name + " removed from stock.");
        } else {
            System.out.println("Item " + name + "not found.");
        }
    }
    void applyDiscount(String name, double discountPercent){
        if(Stock.containsKey(name)){
            Stock.get(name).price *= (1 - discountPercent /100);
        }
    }
    void bestSellers(String name){
        System.out.println(name + " Has been marked a best seller!");
    }
}

class Examples {
}

