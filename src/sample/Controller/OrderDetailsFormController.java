package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderDetailsFormController {
    public AnchorPane contextOrderForm;
    public Button btnBack;
    public TableView tblOrder;
    public TableColumn colFinalOID;
    public TableColumn colFinalODate;
    public TableColumn colFinalCustomer;
    public TableColumn colFinalTotal;

    public void backhome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextOrderForm.
                getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass()
                        .getResource
                                ("../Views/DashBoardForm.fxml"))));
    }
}
