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

public class PerfilEmpresaController {

    @FXML
    private Button editarPerfilBtn;
    @FXML
    private Button voltarTelaPrincipalBtn;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    public void onvoltarTelaPrincipalBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void oneditarPerfilBtn(ActionEvent event) throws IOException {

        System.out.println("editarPerfilBtn");

    }

}
