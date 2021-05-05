package sample.Database;


import sample.model.Customer;
import sample.model.Item;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerList1 = new ArrayList();
    //-------------------------------
    public static ArrayList<Item> itemlist1 = new ArrayList();
    //--------------------------------
    static {
        // For Customer ------------------
        customerList1.add(new Customer("C-001", "Nimal", "Colombo", 25000.00));
        customerList1.add(new Customer("C-002", "Kasun", "Galle", 30000.00));
        customerList1.add(new Customer("C-003", "Dulanga", "Ambalangoda", 15000.00));
        customerList1.add(new Customer("C-004", "Admin", "America", 40000.00));
        customerList1.add(new Customer("C-005", "Namal", "Kandy", 50000.00));

        //For Item -----------------------
        itemlist1.add(new Item("I-001", "Description1", 34, 250.00));
        itemlist1.add(new Item("I-002", "Description2", 23, 300.00));
        itemlist1.add(new Item("I-003", "Description3", 40, 100.00));
        itemlist1.add(new Item("I-004", "Description4", 40, 400.00));
        itemlist1.add(new Item("I-005", "Description5", 60, 130.00));
        itemlist1.add(new Item("I-006", "Description6", 12, 450.00));

    }
}
