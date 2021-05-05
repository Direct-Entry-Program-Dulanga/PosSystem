package sample.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFromController {
    public AnchorPane contextDashBoard;

    public void openCustomerForm(MouseEvent mouseEvent) throws IOException {
        setUi("CustomerForm");
    }

    public void OpenItemForm(MouseEvent mouseEvent) throws IOException {
        setUi("ItemForm");
    }

    public void openCartForm(MouseEvent mouseEvent) throws IOException {
        setUi("AddCartForm");
    }


    private void setUi(String location) throws IOException {
        Stage stage = (Stage) contextDashBoard.
                getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass()
                        .getResource
                                ("../Views/"+location+".fxml"))));

    }



}
