package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.Database;
import sample.Views.TM.OrderTM;
import sample.model.Order;

import java.io.IOException;

public class OrderDetailsFormController {
    public AnchorPane contextOrderForm;
    public Button btnBack;
    public TableView tblOrder;
    public TableColumn colFinalOID;
    public TableColumn colFinalODate;
    public TableColumn colFinalCustomer;
    public TableColumn colFinalTotal;


    public void initialize() {

        colFinalOID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFinalODate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colFinalCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        colFinalTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        loadAllOrders();

        //-----------------

        tblOrder.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            FXMLLoader loader = new
                    FXMLLoader(getClass().getResource("../Views/OrderItemForm.fxml"));
            try {
                Parent root = loader.load();
                OrderItemFormController controller = loader.getController();
                controller.setData(newValue.);
                Stage s = new Stage();
                s.setScene(new Scene(root));
                s.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //-----------------

    }

    private void loadAllOrders() {
        ObservableList<OrderTM> orderObList = FXCollections.observableArrayList();
        for (Order o : Database.orderlist
        ) {
            orderObList.add(
                    new OrderTM(o.getOrderId(),
                            o.getOrderDate(),
                            o.getOcustomerid(),
                            o.getOtotalCost())
            );
        }
        tblOrder.setItems(orderObList);
    }


    public void backhome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextOrderForm.
                getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass()
                        .getResource
                                ("../Views/DashBoardForm.fxml"))));
    }


}
