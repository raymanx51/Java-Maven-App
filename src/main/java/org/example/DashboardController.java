package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class DashboardController {



    @FXML private TextField testTextField;
    @FXML private Label orderNumLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label firstNameLabel;
    @FXML private Label invoiceLabel;

    @FXML
    private void initialize() {

        /**
         * old - testing initialize between scenes
         *
         * try {
            SingletonData holder = SingletonData.getInstance();
            Entry ent = holder.getEntry();
            String orderNum = ent.getOrderNum();
            orderNumLabel.setText(orderNum);
        }
        catch(NullPointerException e){
            System.out.println("Order Number is Null");
        }**/


    }

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {

        // print testTextField to console for testing

        // Singleton testing
        Entry ent = new Entry();
        SingletonData holder = SingletonData.getInstance();
        holder.setEntry(ent);


        // Launch new scene
        App.setRoot("Orders");
    }

    @FXML
    private void addOrderWindow() throws IOException {
        System.out.println("New order button pressed");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Add Order Window.fxml"));
        Parent root = loader.load();

        AddOrderController controller = loader.getController();
        controller.setParentController(this);

        Scene scene = new Scene(root);
        Stage popUp = new Stage();
        popUp.setScene(scene);
        popUp.setTitle("New Order");
        popUp.show();

    }

    // Test method
    @FXML
    private void printAMessage() throws IOException {
        System.out.println("Hello world");
    }


    /**    old - singleton data pass testing
    @FXML
    private void printNameFromEntry() {

        try {
            SingletonData holder = SingletonData.getInstance();
            Entry ent = holder.getEntry();
            String name = ent.getName();
            System.out.println(name);
        }
        catch (NullPointerException e){
            System.out.println("Invoice number is null");
        }

    }**/

    public void parseNewOrder() {

        try {
            SingletonData holder = SingletonData.getInstance();
            Entry ent = holder.getEntry();
            String invoiceNum = ent.getOrderNum();
            invoiceLabel.setText(invoiceNum);

            String lastName = ent.getLastName();
            lastNameLabel.setText(lastName);

            String firstName = ent.getFirstName();
            firstNameLabel.setText(firstName);

        }
        catch(NullPointerException e){
            System.out.println("New order is null");
        }
    }



}
