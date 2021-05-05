package sample.model;

public class ItemDetails {
    private String code;
    private int QTY;
    private double unitPrice;

    public ItemDetails() {
    }

    public ItemDetails(String code, int QTY, double unitPrice) {
        this.code = code;
        this.QTY = QTY;
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
