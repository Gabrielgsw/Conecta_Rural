package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PerfilEstudanteController {

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
    void acaoBotaoCurriculo(ActionEvent event) {
        System.out.println("acaoBotaoCurriculo");
    }

    @FXML
    void acaoBotaoVoltar(ActionEvent event) {
        System.out.println("acaoBotaoVoltar");
    }

}
