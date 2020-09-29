package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SecondaryController {

    @FXML private Label testLabel;

    @FXML
    private void initialize() {

        SingletonData holder = SingletonData.getInstance();
        Entry ent = holder.getEntry();
        String name = ent.getName();
        testLabel.setText(name);

    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }


    @FXML
    public static void receiveData(ActionEvent event) {
    }
}