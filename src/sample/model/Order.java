package lk.system.pos.model;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private String orderDate;
    private String ocustomerid;
    private double ototalCost;
    ArrayList<ItemDetails> itemsdetails;

    public Order(String text, String lblDateText, Object value, double ototalCost, ArrayList<ItemDetails> details) {
    }

    public Order(String orderId, String orderDate, String ocustomerid, double ototalCost, ArrayList<ItemDetails> itemsdetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.ocustomerid = ocustomerid;
        this.ototalCost = ototalCost;
        this.itemsdetails = itemsdetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOcustomerid() {
        return ocustomerid;
    }

    public void setOcustomerid(String ocustomerid) {
        this.ocustomerid = ocustomerid;
    }

    public double getOtotalCost() {
        return ototalCost;
    }

    public void setOtotalCost(double ototalCost) {
        this.ototalCost = ototalCost;
    }


    public ArrayList<ItemDetails> getItems() {
        return itemsdetails;
    }

    public void setItems(ArrayList<ItemDetails> itemsdetails) {
        this.itemsdetails = itemsdetails;
    }
}
