package org.example;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;





public class PrimaryController {

    @FXML private TextField testTextField;

    @FXML
    private void initialize() {

    }

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {

        // print testTextField to console for testing
        String testText = testTextField.getText();
        System.out.println(testText);

        // Singleton testing
        Entry ent = new Entry();

        ent.setName(testTextField.getText());

        SingletonData holder = SingletonData.getInstance();
        holder.setEntry(ent);
        //SecondaryController.receiveData(event);


        // Launch new scene
        App.setRoot("secondary");
    }

    // Test method
    @FXML
    private void printAMessage() throws IOException {
        System.out.println("Hello world");
    }

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

    }


}
