package sample.model;

public class Customer {
    private String Cid;
    private String Cname;
    private String Caddress;
    private double Csalary;

    public Customer() {
    }

    public Customer(String cid, String cname, String caddress, double csalary) {
        Cid = cid;
        Cname = cname;
        Caddress = caddress;
        Csalary = csalary;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCaddress() {
        return Caddress;
    }

    public void setCaddress(String caddress) {
        Caddress = caddress;
    }

    public double getCsalary() {
        return Csalary;
    }

    public void setCsalary(double csalary) {
        Csalary = csalary;
    }
}
