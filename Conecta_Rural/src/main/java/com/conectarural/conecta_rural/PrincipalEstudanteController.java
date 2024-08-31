package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalEstudanteController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private AnchorPane TelaEstudante;

    @FXML
    private Button botaoBuscarVagas;

    @FXML
    private Button botaoCandidaturas;

    @FXML
    private Button botaoSairEstudante;

    @FXML
    private Button botaoVerPerfil;

    @FXML
    private Button botaoVerVagasAbertas;

    @FXML
    private ImageView fotoPerfil;

    @FXML
    private TextField nomeEstudante;

    @FXML
    void acaoBotaoBuscarVagas(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoBuscarVagas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaBuscarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoCandidaturas(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoCandidaturas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("VisualizarCandidaturas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoSairEstudante(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoSairEstudante");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("EscolherPerfil.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoVerPerfil(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVerPerfil");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("PerfilEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoVerVagasAbertas(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVerVagasAbertas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaBuscarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
