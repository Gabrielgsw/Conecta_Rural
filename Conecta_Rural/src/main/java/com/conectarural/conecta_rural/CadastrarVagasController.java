package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastrarVagasController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private Button cadastrarVagaBtn;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button voltarTelaBT;

    @FXML
    private TextField codigoVagaField;

    @FXML
    private TextArea descricaoVagaArea;

    @FXML
    private TextField nomeDaVagaField;

    @FXML
    private TextField numeroDeVagasField;

    @FXML
    private MenuItem regimeClt;

    @FXML
    private MenuItem regimeEstagio;

    @FXML
    private MenuItem regimeFreelancer;

    @FXML
    private MenuItem regimePj;

    private MenuButton regimeContratacaoMenu;

    @FXML
    private MenuItem regimeTemporario;

    @FXML
    private TextField valorRemuneracaoField;

    @FXML
    public void onCadastrarVagaBtnaction(ActionEvent event) throws IOException {
       /* Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCadastrarVagas.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        /*int codigoVaga = Integer.parseInt(codigoVagaField.getText());
        String descricaoVaga = descricaoVagaArea.getText();
        String nomeDaVaga = nomeDaVagaField.getText();
        String numeroDeVaga = numeroDeVagasField.getText();*/

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaVagaCadastrada.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void onvoltarTelaBTaction(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCadastrarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void onvoltarBtn(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
