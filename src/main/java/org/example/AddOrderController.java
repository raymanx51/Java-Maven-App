package org.example;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AddOrderController {

    public AnchorPane layout;
    @FXML private TextField lastNameTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField invoiceNumTextField;
    @FXML private Label lastNameErrorMessage;
    @FXML private Label firstNameErrorMessage;
    @FXML private Label invoiceNumErrorMessage;
    @FXML private VBox lastNameVbox;
    @FXML private VBox firstNameVbox;
    @FXML private VBox invoiceNumVbox;

    @FXML
    private void initialize() {

        // Hide form error messages
        lastNameVbox.getChildren().remove(lastNameErrorMessage);
        firstNameVbox.getChildren().remove(firstNameErrorMessage);
        invoiceNumVbox.getChildren().remove(invoiceNumErrorMessage);
    }

    // Establishes a reference to the controller that created this window
    public DashboardController parentController;

    public void setParentController(DashboardController controller) {
        parentController = controller;
    }

    @FXML
    private void addOrder() throws IOException {

        /*
            To-do here:
            - Load in list of customers from database into ComboBox
            - Implement ComboBox selection to TextField validation (name fields can/must be blank if ComboBox is selected)
            - Add current date (LocalDate?) to the order entry (add set/get date to Entry class)


         */

        // Validate no fields are blank
        boolean val = validateOrder();

        if (val == false){
            System.out.println("A value is invalid");
        }

        else {
            // Singleton testing
            Entry ent = new Entry();

            ent.setLastName(lastNameTextField.getText());
            ent.setFirstName(firstNameTextField.getText());
            ent.setOrderNum(invoiceNumTextField.getText());
            SingletonData holder = SingletonData.getInstance();
            holder.setEntry(ent);

            // To-do here: After validating no fields are blank, add order to database (delete singleton cmd later)
            parentController.parseNewOrder();

            System.out.println("\nNew Order entered:");
            System.out.println("Last Name: " + ent.getLastName());
            System.out.println("First Name: " + ent.getFirstName());
            System.out.println("Invoice #: " + ent.getOrderNum());

            closeWindow();
        }

    }

    /**
     * Validate no TextField is blank, show/hide error message to user accordingly
     * @return False if any field is blank, else true
     */
    private boolean validateOrder() {
        //String firstName = first;
        //String lastName = last;
        //String invoiceNum = num;
        boolean val = true;

        if (lastNameTextField.getText().isBlank()) {
            try {
                lastNameVbox.getChildren().add(lastNameErrorMessage);
            }
            catch (IllegalArgumentException e){
                System.out.println("Last name error message displayed");
            }

            val = false;
        }

        else {
            lastNameVbox.getChildren().remove(lastNameErrorMessage);
        }

        if (firstNameTextField.getText().isBlank()) {
            try {
                firstNameVbox.getChildren().add(firstNameErrorMessage);
            }
            catch (IllegalArgumentException e){
                System.out.println("First name error message displayed");
            }

            val = false;
        }
        else {
            firstNameVbox.getChildren().remove(firstNameErrorMessage);
        }

        if (invoiceNumTextField.getText().isBlank()) {
            try {
                invoiceNumVbox.getChildren().add(invoiceNumErrorMessage);
            }
            catch (IllegalArgumentException e){
                System.out.println("Invoice number error message displayed");
            }

            val = false;
        }
        else {
            invoiceNumVbox.getChildren().remove(invoiceNumErrorMessage);
        }

        return val;


    }


    /**
     * Closes current window
     * @throws IOException
     */
    @FXML
    private void closeWindow () throws IOException {
        Stage window = (Stage) ((Node)layout).getScene().getWindow();
        window.close();
    }

}
