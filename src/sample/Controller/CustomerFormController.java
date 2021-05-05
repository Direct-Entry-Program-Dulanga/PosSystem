package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.Database;
import sample.Views.TM.CustomerTM;
import sample.model.Customer;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerFormController {
//    public Button btnBackHome;
//    public Button BtnNewCustomer;
    //---------------------------
    public TextField txtCid;
    public TextField txtCname;
    public TextField txtCsalary;
    public TextField txtCaddress;
    public Button btnSave;
    //--------------------------------
    public TableView<CustomerTM> tblCustomer;
    public TableColumn colCid;
    public TableColumn colCname;
    public TableColumn colCsalary;
    public TableColumn colCaddress;
    public TableColumn colCoperate;
    //----------------------------------
    public AnchorPane contextcustomer;
    //-------------------------------
    public TextField txtCsearch;

    ArrayList<Customer> customersList= new ArrayList/*<>*/();

    public void initialize(){
        colCid.setCellValueFactory(new PropertyValueFactory/*<>*/("Cid"));
        colCname.setCellValueFactory(new PropertyValueFactory("Cname"));
        colCsalary.setCellValueFactory(new PropertyValueFactory("Csalary"));
        colCaddress.setCellValueFactory(new PropertyValueFactory("Caddress"));
        colCoperate.setCellValueFactory(new PropertyValueFactory("btn"));
//        ---------------------------------
        setCustomerID();
        loadAllCustomers();

//        --------------------------------
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue)-> {

            if(newValue != null){
                setData(newValue);
            }

        });
    }

    private void setData(CustomerTM newValue) {
        txtCid.setText(newValue.getCid());
        txtCname.setText(newValue.getCname());
        txtCaddress.setText(newValue.getCaddress());
        txtCsalary.setText(String.valueOf(newValue.getCsalary()));
        btnSave.setText("Update Customer");
    }

    private void loadAllCustomers() {
        ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();
        for (Customer c: Database.customerList1
        ) {

            Button btn = new Button("Delete");
            observableList.add(
                    new CustomerTM(
                            c.getCid(),
                            c.getCname(),
                            c.getCaddress(),
                            c.getCsalary(),
                            btn)
            );

            btn.setOnAction(e->{
                if(Database.customerList1.remove(c)){
                    loadAllCustomers();
                }
            });
        }
        tblCustomer.setItems(observableList);
    }

    private void setCustomerID(){
        if(Database.customerList1.size()>0){
            String tempNumber = Database.customerList1.get(
                    Database.customerList1.size()-1).getCid();
            String array[] = tempNumber.split("C-");
            int number = Integer.parseInt(array[1]);
            number++;

            if(number>100){
                tempNumber = "C-"+number;
            }else if(number>10){
                tempNumber = "C-0"+number;
            }
            txtCid.setText(tempNumber);
        }else{
            txtCid.setText("C-001");
        }
    }


    public void savecustomer(ActionEvent actionEvent) {
        Customer c1= new Customer(
                txtCid.getText(),
                txtCname.getText(),
                txtCaddress.getText(),
                Double.parseDouble(txtCsalary.getText())
        );
        customersList.add(c1);
        System.out.println(customersList);

        if (btnSave.getText().equals("Save Customer")){
            if (Database.customerList1.add(c1)){
                new Alert(Alert.AlertType.CONFIRMATION,
                        "Done", ButtonType.OK).show();
                //load save data
                loadAllCustomers();
            }else{
                new Alert(Alert.AlertType.WARNING,
                        "Try Again", ButtonType.CLOSE).show();
            }
        }else {
            //update -------------------
            for (int i = 0; i < Database.customerList1.size(); i++) {

                if (txtCid.getText().equals(Database.customerList1.get(i).getCid())){
                    Database.customerList1.remove(i);
                    if(Database.customerList1.add(c1)){
                        new Alert(Alert.AlertType.CONFIRMATION,
                                "Updated", ButtonType.OK).show();
                        loadAllCustomers();
                        break;
                    }else{
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.CLOSE).show();
                    }
                }

            }
        }
    }
    //------------------------------
    public void searchcustomer(KeyEvent keyEvent) {
        String searchText = "";
        searchText = txtCsearch.getText();
        System.out.println(txtCsearch.getText());

        ObservableList<CustomerTM> searchTm = FXCollections.observableArrayList();

        for(Customer customer: Database.customerList1){
            if(customer.getCid().contains(searchText) ||
                    customer.getCname().contains(searchText) ||
                    customer.getCaddress().contains(searchText)
            ){
                Button btn = new Button("Delete");
                searchTm.add(new CustomerTM(
                        customer.getCid(),
                        customer.getCname(),
                        customer.getCaddress(),
                        customer.getCsalary(),
                        btn));
            }

        }
        tblCustomer.setItems(searchTm);
    }
    //------------------------------
    private void clearData() {
        txtCid.clear();
        txtCname.clear();
        txtCaddress.clear();
        txtCsalary.clear();
    }
    public void newcustomer(ActionEvent actionEvent) {
        btnSave.setText("Save Customer");
        clearData();
    }
    //------------------------------
    public void backhome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextcustomer.
                getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass()
                        .getResource
                                ("../views/DashBoardForm.fxml"))));
    }



}
