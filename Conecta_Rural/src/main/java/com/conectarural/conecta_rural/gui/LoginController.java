package com.conectarural.conecta_rural.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button cadastroBT;

    @FXML
    public void onCadastroBTaction() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmpresaCadastro.fxml"));
        Scene mscene = new Scene(root, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();
        System.out.println("Cadastro BT");
    }


}