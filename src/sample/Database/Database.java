package sample.Database;


import sample.model.Customer;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerList1 = new ArrayList();
    //-------------------------------

    static {
        // For Customer ------------------
        customerList1.add(new Customer("C-001", "Nimal", "Colombo", 25000.00));
        customerList1.add(new Customer("C-002", "Kasun", "Galle", 30000.00));
        customerList1.add(new Customer("C-003", "Dulanga", "Ambalangoda", 15000.00));
        customerList1.add(new Customer("C-004", "Admin", "America", 40000.00));
        customerList1.add(new Customer("C-005", "Namal", "Kandy", 50000.00));


    }
}
