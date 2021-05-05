package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Database.Database;
import sample.model.ItemDetails;
import sample.model.Order;

public class OrderItemFormController {

    public TableView<ItemDetails> tblOrderDetail;
    public TableColumn colItemCode;
    public TableColumn colQTY;
    public TableColumn colUnitPrice;

    public void initialize() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }

    public void setData(String orderId) {
        for (Order o : Database.orderlist
        ) {
            if (o.getOrderId().equals(orderId)) {
                ObservableList<ItemDetails> detailsObList =
                        FXCollections.observableArrayList(o.getItems());
                tblOrderDetail.setItems(detailsObList);
                return;
            }
        }
    }
}
