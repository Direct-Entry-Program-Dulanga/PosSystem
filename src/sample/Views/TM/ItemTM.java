package sample.Views.TM;

import javafx.scene.control.Button;

public class ItemTM {
    private String icode;
    private String idescription;
    private int iquantityoh;
    private double iunitprice;
    private Button ibtn;

    public ItemTM() {
    }

    public ItemTM(String icode, String idescription, int iquantityoh, double iunitprice, Button ibtn) {
        this.icode = icode;
        this.idescription = idescription;
        this.iquantityoh = iquantityoh;
        this.iunitprice = iunitprice;
        this.ibtn = ibtn;
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

    public int getIquantityoh() {
        return iquantityoh;
    }

    public void setIquantityoh(int iquantityoh) {
        this.iquantityoh = iquantityoh;
    }

    public double getIunitprice() {
        return iunitprice;
    }

    public void setIunitprice(double iunitprice) {
        this.iunitprice = iunitprice;
    }

    public Button getIbtn() {
        return ibtn;
    }

    public void setIbtn(Button ibtn) {
        this.ibtn = ibtn;
    }
}
