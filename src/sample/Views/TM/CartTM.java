package sample.Views.TM;

public class CartTM {
    private String itemCode;
    private String description;
    private int QTY;
    private double unitPrice;
    private double total;

    public CartTM() {
    }

    public CartTM(String itemCode, String description, int QTY, double unitPrice, double total) {
        this.itemCode = itemCode;
        this.description = description;
        this.QTY = QTY;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
