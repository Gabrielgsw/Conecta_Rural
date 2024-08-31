package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Empresa;
import com.conectarural.conecta_rural.models.Vaga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class BuscarVagasController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button botaoBuscar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TableView<Vaga> table;

    @FXML
    private TableColumn<Vaga, Empresa> colunaEmpresa;

    @FXML
    private TableColumn<Vaga, String> colunaDescricaoVaga;

    @FXML
    private TableColumn<Vaga, Double> colunaRemuneracao;

    @FXML
    private TableColumn<Vaga, Integer> colunaQuantidadeVagas;

    @FXML
    private TableColumn<Vaga, String> colunaNomeVaga;

    @FXML
    private TableColumn<Vaga, Double> colunaValorVaga;

    @FXML
    private AnchorPane BuscarVagasAnchorPane;

    @FXML
    void acaoBotaoBuscarVagas(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoBuscarVagas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaBuscarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void acaoBotaoVoltar(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVoltar");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
