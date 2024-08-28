package com.conectarural.conecta_rural;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewController {

    @FXML
    private Button empresaBT;


    @FXML
    private Button estudanteBT;

    @FXML
    public void onBTAction() throws IOException {
        //FXMLLoader fxml = new FXMLLoader(getClass().getResource(“/Login.fxml”));
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();

    }
}
