import java.util.HashMap;

public class vendorManager {
    private HashMap<String, Vendor> vendors = new HashMap<>();

    void addVendor(String name, Vendor vendor){
        vendors.put(name, vendor);
    }
    Vendor getVendor(String name){
        return vendors.get(name);
    }
    void printAllInventories(){
        for (String name : vendors.keySet()){
            System.out.println("Inventory for Vendor: "+ name);
            vendors.get(name).showVendorInventory();
            System.out.println();
        }
    }
}
