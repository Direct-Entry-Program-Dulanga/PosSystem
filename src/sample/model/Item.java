package sample.model;

public class Item {
    private String icode;
    private String idescription;
    private int iquantityOH;
    private double iunitPrice;

    public Item() {
    }

    public Item(String icode, String idescription, int iquantityOH, double iunitPrice) {
        this.icode = icode;
        this.idescription = idescription;
        this.iquantityOH = iquantityOH;
        this.iunitPrice = iunitPrice;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getIdescription() {
        return idescription;
    }

    public void setIdescription(String idescription) {
        this.idescription = idescription;
    }

    public int getIquantityOH() {
        return iquantityOH;
    }

    public void setIquantityOH(int iquantityOH) {
        this.iquantityOH = iquantityOH;
    }

    public double getIunitPrice() {
        return iunitPrice;
    }

    public void setIunitPrice(double iunitPrice) {
        this.iunitPrice = iunitPrice;
    }
}
