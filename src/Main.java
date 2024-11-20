public class Main {
    public static void main(String[] args) {


        System.out.println("Welcome to Ultra Shop!");
        System.out.println("Maintained by <A human>");

        Vendor candyVendor = new Vendor(10, 5); //10 candy, 5 Gum
        Vendor snackVendor = new Vendor(0, 0);// no snacks

        vendorManager manager = new vendorManager();
        manager.addVendor("Candy1 Vendor", candyVendor);
        manager.addVendor("Snack1 Vendor", snackVendor);

        //Adding money to vendor
        System.out.println("Adding money to Candy1 Vendor");
        candyVendor.addMoney(10.00); // added $10
        System.out.println("Current balance for Candy1 Vendor is: " + candyVendor.getBalance());

        //Checking stock from candy1
        System.out.println("Buying Candy from Candy1");
        candyVendor.select("Candy");
        System.out.println("Candy Stock: "+ candyVendor.Stock.get("Candy").stock);

        //Restocking
        System.out.println("Restocking snackVendor with Doritos");
        snackVendor.restock("Doritos", 3, 2.50);
        System.out.println("Restocked " + snackVendor.Stock.get("Doritos").stock);

        //Changing Item name
        snackVendor.changeItemName("Doritos", "Cool Ranch Doritos");
        System.out.println("Snack Vendor inventory"+ snackVendor.Stock.keySet());

        //Discount
        snackVendor.applyDiscount("Cool Ranch Doritos", 15);
        System.out.println("Discounted Snack Vendor: $" + snackVendor.Stock.get("Cool Ranch Doritos").price);

        //Mark Doritos as bestseller
        snackVendor.bestSellers("Cool Ranch Doritos");

        //removing Item from Inventory
        snackVendor.removeItem("Cool Ranch Doritos");
        System.out.println("Updated Inventory: "+ snackVendor.Stock.keySet());

        //Item Descriptions
        Item candyItem = candyVendor.Stock.get("Candy");
        if(candyItem != null){
            candyItem.description = "A King Sized Candy Bar";
            System.out.println("Description: "+ candyItem.getDescription());
        }
        System.out.println("Thank you for stopping in!");
    }
}