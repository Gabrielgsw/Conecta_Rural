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

public class CadastroFeitoController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button botaoRetorno;

    @FXML
    void acaoBotaoRetorno(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoRetorno");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
