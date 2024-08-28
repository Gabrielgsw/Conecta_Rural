package com.conectarural.conecta_rural;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroController {
    @FXML
    private Button cadastrarBT;

    @FXML
    private Button redirecionarLoginBT;

    @FXML
    public void cadastrarOnAction() throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("CadastroRealizado.fxml"));

        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();

    }

    @FXML
    public void redirecionarLoginOnAction() throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();

    }
}

