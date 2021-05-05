package sample.Views.TM;

public class OrderTM {
    private String orderId;
    private String orderDate;
    private String customerid;
    private double total;

    public OrderTM() {
    }

    public OrderTM(String orderId, String orderDate, String customerid, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerid = customerid;
        this.total = total;
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

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
