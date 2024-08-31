package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class CurriculoController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button BotaoGerarCurriculo;

    @FXML
    private Button BotaoVoltar;

    @FXML
    private ImageView imagemEstudanteCurriculo;

    @FXML
    private AnchorPane curriculoAnchorPane;

    @FXML
    private TextField nomeEstudanteCurriculo;

    @FXML
    private TextField ResumoEstudanteCurriculo;

    @FXML
    private TextField periodoAtualEstudanteCurriculo;

    @FXML
    private TextField cursoEstudanteCurriculo;

    @FXML
    private TextField atividadesEstudanteCurriculo;

    @FXML
    void acaoBotaoGerarCurriculo(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoGerarCurriculo");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCurriculo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoVoltar(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVoltar");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPerfilEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
