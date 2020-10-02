package org.example;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddOrderController {

    public AnchorPane layout;
    @FXML private TextField lastNameTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField invoiceNumTextField;

    // Establishes a reference to the controller that created this window
    public PrimaryController parentController;

    public void setParentController(PrimaryController controller) {
        parentController = controller;
    }

    @FXML
    private void addOrder() throws IOException {
        // Singleton testing
        Entry ent = new Entry();

        ent.setLastName(lastNameTextField.getText());
        ent.setFirstName(firstNameTextField.getText());
        ent.setOrderNum(invoiceNumTextField.getText());
        SingletonData holder = SingletonData.getInstance();
        holder.setEntry(ent);

        parentController.parseNewOrder();

        closeWindow();
    }


    @FXML
    private void closeWindow () throws IOException {
        Stage window = (Stage) ((Node)layout).getScene().getWindow();
        window.close();
    }

}
