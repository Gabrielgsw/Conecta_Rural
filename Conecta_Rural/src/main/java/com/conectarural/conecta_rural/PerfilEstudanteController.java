package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PerfilEstudanteController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private TextField CPFestudante;

    @FXML
    private Button botaoCurriculo;

    @FXML
    private Button botaoVoltar;

    @FXML
    private AnchorPane perfilEstudante;

    @FXML
    private TextField cursoEstudante;

    @FXML
    private TextField emailEstudante;

    @FXML
    private TextField idadeEstudante;

    @FXML
    private TextField nomeEstudante;

    @FXML
    private TextField periodoEstudante;

    @FXML
    private TextField telefoneEstudante;

    @FXML
    void acaoBotaoCurriculo(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoCurriculo");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCurriculo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoVoltar(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVoltar");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
