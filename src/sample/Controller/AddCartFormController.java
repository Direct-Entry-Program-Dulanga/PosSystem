package lk.system.pos.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.system.pos.DataBase.Database;
import lk.system.pos.Views.TM.CartTM;
import lk.system.pos.model.Customer;
import lk.system.pos.model.Item;
import lk.system.pos.model.ItemDetails;
import lk.system.pos.model.Order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddCartFormController {
    public Button btnBack;
    //------------------------------
    public ComboBox cmbCustomerId;
    public ComboBox cmbItemCode;
    //------------------------------
    public Label lblOrderId;
    public Label lblDate;
    public Label lblTime;
    //------------------------------
    public TextField txtOrderCus;
    public TextField txtOrderAdd;
    public TextField txtOrderSal;
    public TextField txtOrderDes;
    public TextField txtOrderQTYHand;
    public TextField txtOrderUPrice;
    public TextField txtOrderQTY;
    public Button btnRemove;
    public Button btnAddCart;
    //------------------------------
    public TableView<CartTM> tblOrder;
    public TableColumn colOrderIC;
    public TableColumn colOrderDes;
    public TableColumn colOrderQTY;
    public TableColumn colOrderUPrice;
    public TableColumn colOrderTotal;
    //------------------------------
    public AnchorPane contextaddcart;
    public Label lblOrderTotal;
    public Button btnOrderPlace;


    ObservableList<CartTM> cartList = FXCollections.observableArrayList();


    public void initialize(){
        colOrderIC.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOrderDes.setCellValueFactory(new PropertyValueFactory<>("description"));
        colOrderQTY.setCellValueFactory(new PropertyValueFactory<>("QTY"));
        colOrderUPrice.setCellValueFactory(new PropertyValueFactory<>("total"));
        colOrderTotal.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        loadAllItemIds();
        loadAllCustomerIds();
        setDateAndTime();
        setOrderId();

        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setCustomerData((String) newValue);
        });
        //------------------------------
        cmbItemCode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setItemsData((String) newValue);
        });

        tblOrder.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            tempcart = newValue;
        });
    }

    private void setOrderId() {
        if (Database.orderlist.size() > 0) {

            String tempNumber = Database.orderlist.get(Database.orderlist.size() - 1).getOrderId();
            String array[] = tempNumber.split("O-");
            int number = Integer.parseInt(array[1]);
            number++;

            if (number > 100) {
                tempNumber = "O-" + number;
            } else if (number > 10) {
                tempNumber = "O-0" + number;
            } else {
                tempNumber = "O-00" + number;
            }

            lblOrderId.setText(tempNumber);

        } else {
            lblOrderId.setText("O-001");
        }
    }

    private void setItemsData(String value) {
        for (Item i1: Database.itemlist1
        ) {
            if(value.equals(i1.getIcode())){
                txtOrderDes.setText(i1.getIdescription());
                txtOrderQTYHand.setText(String.valueOf(i1.getIquantityOH()));
                txtOrderUPrice.setText(String.valueOf(i1.getIunitPrice()));
                break;
            }
        }
    }

    private void setCustomerData(String id) {
        for (Customer c1: Database.customerList1
        ) {
            if(id.equals(c1.getCid())){
                txtOrderCus.setText(c1.getCname());
                txtOrderAdd.setText(c1.getCaddress());
                txtOrderSal.setText(String.valueOf(c1.getCsalary()));
                break;
            }
        }
    }


    //-----------------------------------


    private void loadAllCustomerIds() {
        ObservableList<String> customeroblist = FXCollections.observableArrayList();

        for (Customer c: Database.customerList1
        ) {
            customeroblist.add(c.getCid());
        }
        cmbCustomerId.setItems(customeroblist);
    }
    //----------------------------------
    private void loadAllItemIds() {
        ObservableList<String> itemoblist = FXCollections.observableArrayList();

        for (Item i: Database.itemlist1
        ) {
            itemoblist.add(i.getIcode());
        }
        cmbItemCode.setItems(itemoblist);
    }

    private void setDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-DD");
        lblDate.setText(f.format(date));
        lblTime.setText(new SimpleDateFormat("HH:mm:ss").format(date));
    }

    public void addcart(ActionEvent actionEvent) {
        if(Integer.parseInt(txtOrderQTY.getText())<= Integer.parseInt(txtOrderQTYHand
                .getText())) {
            int qty = Integer.parseInt(txtOrderQTY.getText());
            double unitPrice = Double.parseDouble(txtOrderUPrice.getText());
            double total = qty * unitPrice;
            CartTM tm = new CartTM(
                    cmbItemCode.getValue().toString(),
                    txtOrderDes.getText(),
                    qty,
                    unitPrice,
                    total
            );
            boolean isExists = checkIsExists(tm);
            if (isExists) {
                tblOrder.refresh();
            } else {
                cartList.add(tm);
                tblOrder.setItems(cartList);
            }


        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Invalid Quantity").show();
        }
    }

    private boolean checkIsExists(CartTM tm) {
        int C = 0;
        for (CartTM temp: cartList
        ) {
            if(temp.getItemCode().equals(tm.getItemCode())){
                if(cartList.get(C).getQTY() >= Integer.parseInt(txtOrderQTY.getText()) + cartList.get(C).getQTY()){
                    cartList.get(C).setQTY(tm.getQTY()+ temp.getQTY());
                    cartList.get(C).setTotal(tm.getTotal()+temp.getTotal());
                    return true;
                }else{
                    new Alert(Alert.AlertType.CONFIRMATION,"Invalid Quantity").show();
                    return true;
                }

            }
            C++;
        }
        return false;
    }


    CartTM tempcart = null;
    public void removeitem(ActionEvent actionEvent) {
        if(tempcart!= null){
            for (CartTM tm1:cartList)
            {
                if(tm1.getItemCode().equals(tempcart.getItemCode())){
                    cartList.remove(tm1);
                    tblOrder.refresh();
                }
            }
        }else{
            new Alert(Alert.AlertType.WARNING, "Please Select a row").show();
        }
    }


  void calculateTotalCost(){

    double total = 0.00;
    for (CartTM tm2 : cartList
    ) {
        total += tm2.getTotal();
    }
    lblOrderTotal.setText(total+"/=");
}

    public void btnback(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextaddcart.
                getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass()
                        .getResource
                                ("../views/DashBoardForm.fxml"))));
    }

    public void palceOrder(ActionEvent actionEvent) {
        ArrayList<ItemDetails> details = new ArrayList<>();
        for (CartTM tm : cartList
        ) {
            details.add(
                    new ItemDetails(
                            tm.getItemCode(),
                            tm.getQTY(), tm.getUnitPrice()
                    )
            );
        }

        Order order = new Order(
                lblOrderId.getText(),
                lblDate.getText(),
                cmbCustomerId.getValue(),
                Double.parseDouble(lblOrderTotal.getText().split(" /=")[0]),
                details

        );

        if (Database.orderlist.add(order)) {
            new Alert(Alert.AlertType.CONFIRMATION, " Placed.").show();
            cartList.clear();
            calculateTotalCost();
        }


    }

}
