package com.conectarural.conecta_rural;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button cadastroBT;
    @FXML
    private Button entrarBT;
    @FXML
    private TextField emailField;
    @FXML
    private TextField senhaField;

    @FXML
    public void onCadastroBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("EmpresaCadastro.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //Scene mscene = new Scene(root, 600, 400 );
       // Stage nstage = new Stage();
       // nstage.setScene(mscene);
        //nstage.show();
        //System.out.println("Cadastro BT");
    }

    @FXML
    public void onentrarBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("EscolherPerfil.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}