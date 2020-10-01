package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SecondaryController {

    @FXML private Label testLabel;
    @FXML private TextField orderNumTextField;

    @FXML
    private void initialize() {

        SingletonData holder = SingletonData.getInstance();
        Entry ent = holder.getEntry();
        String name = ent.getName();
        testLabel.setText(name);

    }

    @FXML
    private void saveOrder() throws IOException {

        // Singleton testing
        Entry ent = new Entry();
        ent.setOrderNum(orderNumTextField.getText());
        SingletonData holder = SingletonData.getInstance();
        holder.setEntry(ent);

        App.setRoot("primary");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }


    @FXML
    public static void receiveData(ActionEvent event) {
    }
}