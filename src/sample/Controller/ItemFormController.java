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
import sample.Views.TM.ItemTM;
import sample.model.Item;

import java.io.IOException;

public class ItemFormController {
    public AnchorPane contextItemForm;
    //-----------------------------
    public Button btnHome;
    public Button btnNewItem;
    //-----------------------------
    public TextField txtItemCode;
    public TextField txtQuantityOH;
    public TextField txtUnitPrice;
    public TextField txtDescription;
    public Button btnSaveItem;
    //-----------------------------
    public TableView<ItemTM> tblItemForm;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colQuantityOH;
    public TableColumn colUnitPrice;
    public TableColumn colOperate;
    //-----------------------------
    public TextField txtSearch;


    ObservableList<ItemTM> obList = FXCollections.observableArrayList();

    public void initialize(){
        colItemCode.setCellValueFactory(new PropertyValueFactory/*<>*/("icode"));
        colDescription.setCellValueFactory(new PropertyValueFactory("idescription"));
        colQuantityOH.setCellValueFactory(new PropertyValueFactory("iquantityOH"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("iunitPrice"));
        colOperate.setCellValueFactory(new PropertyValueFactory("ibtn"));
//        ---------------------------------
        loadItems( "");
        setItemID();

//        --------------------------------
        tblItemForm.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue)-> {

            if(newValue != null){
                setData(newValue);
            }

        });
    }

    private void setData(ItemTM value) {
        txtItemCode.setText(value.getIcode());
        txtDescription.setText(value.getIdescription());
        txtQuantityOH.setText(String.valueOf(value.getIquantityoh()));
        txtUnitPrice.setText(String.valueOf(value.getIunitprice()));
        btnSaveItem.setText("Update Item");
    }

    public void btnhome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextItemForm.
                getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass()
                        .getResource
                                ("../Views/DashBoardForm.fxml"))));
    }

    //----------------------------------------------------
    private void clearData() {
        txtItemCode.clear();
        txtUnitPrice.clear();
        txtQuantityOH.clear();
        txtDescription.clear();
        txtSearch.clear();
    }
    public void btnnewitem(ActionEvent actionEvent) {
        clearData();
    }
    //------------------------------------------------------
    public void btnsaveitem(ActionEvent actionEvent) {
        Item i1 = new Item(
                txtItemCode.getText(),
                txtDescription.getText(),
                Integer.parseInt(txtQuantityOH.getText()),
                Double.parseDouble(txtUnitPrice.getText())
        );

        if(btnSaveItem.getText().equals("Save Item")){
            //Save -------------
            if (Database.itemlist1.add(i1)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK)
                        .show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE)
                        .show();
            }
        } else {
            //update
            int counter = 0;
            for (Item i: Database.itemlist1
            ) {
                if (txtItemCode.getText().equals(i.getIcode())){
                    Database.itemlist1.get(counter).setIdescription(txtDescription.getText());
                    Database.itemlist1.get(counter).setIquantityOH(Integer.parseInt(txtQuantityOH.getText()));
                    Database.itemlist1.get(counter).setIunitPrice(Double.parseDouble(txtUnitPrice.getText()));
                    loadItems("");
                    break;
                }
                counter++;

            }

        }
    }

    public void searchitem(KeyEvent keyEvent) {
        loadItems(txtSearch.getText());
    }

    private void loadItems(String searchText) {
        // clear Duplicate
        obList.clear();

        for( Item i:Database.itemlist1){
            //-----------------------
            Button btn = new Button("Delete");
            //-----------------------
            if(i.getIcode().contains(searchText) || i.getIdescription().contains(searchText)){
                obList.add(new ItemTM(
                        i.getIcode(),
                        i.getIdescription(),
                        i.getIquantityOH(),
                        i.getIunitPrice(),
                        btn));

                btn.setOnAction(e->{
                    if(Database.itemlist1.remove(i)){
                        new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                        loadItems("");
                    }else{
                        new Alert(Alert.AlertType.WARNING,"Try Again").show();
                    }
                });
            }

        }
        tblItemForm.setItems(obList);
    }

    private void setItemID(){
        if (Database.itemlist1.size()>0){

            String tempNumber1 = Database.itemlist1.get(Database.itemlist1.size()-1).getIcode();
            String array[]= tempNumber1.split("I-");
            int number=Integer.parseInt(array[1]);
            number++;

            if (number>100){
                tempNumber1="I-"+number;
            }else if(number>10){
                tempNumber1="I-0"+number;
            }else{
                tempNumber1="I-00"+number;
            }
            txtItemCode.setText(tempNumber1);

        }else{
            txtItemCode.setText("I-001");
        }
    }
}
