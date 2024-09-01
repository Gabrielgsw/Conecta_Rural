package com.conectarural.conecta_rural;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    public void cadastrarOnAction(ActionEvent event) throws IOException{
//        Parent parent = FXMLLoader.load(getClass().getResource("CadastroRealizado.fxml"));

        //Scene mscene = new Scene(parent, 600, 400 );
        //Stage nstage = new Stage();
        //nstage.setScene(mscene);
       // nstage.show();

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("CadastroRealizado.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void redirecionarLoginOnAction(ActionEvent event) throws IOException{
//        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));

        //Scene mscene = new Scene(parent, 600, 400 );
        //Stage nstage = new Stage();
        //nstage.setScene(mscene);
       // nstage.show();
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}

