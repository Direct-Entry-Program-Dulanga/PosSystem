package sample.Views.TM;

import javafx.scene.control.Button;

public class CustomerTM {
    private String cid;
    private String cname;
    private String caddress;
    private double csalary;
    private Button btn;

    public CustomerTM() {
    }

    public CustomerTM(String cid, String cname, String caddress, double csalary, Button btn) {
        this.cid = cid;
        this.cname = cname;
        this.caddress = caddress;
        this.csalary = csalary;
        this.btn = btn;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public double getCsalary() {
        return csalary;
    }

    public void setCsalary(double csalary) {
        this.csalary = csalary;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
