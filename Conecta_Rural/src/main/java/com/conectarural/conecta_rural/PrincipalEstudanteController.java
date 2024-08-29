package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PrincipalEstudanteController {

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
    private Label nomeEstudante;

    @FXML
    void acaoBotaoBuscarVagas(ActionEvent event) {
        System.out.println("acaoBotaoBuscarVagas");
    }

    @FXML
    void acaoBotaoCandidaturas(ActionEvent event) {
        System.out.println("acaoBotaoCandidaturas");
    }

    @FXML
    void acaoBotaoSairEstudante(ActionEvent event) {
        System.out.println("acaoBotaoSairEstudante");
    }

    @FXML
    void acaoBotaoVerPerfil(ActionEvent event) {
        System.out.println("acaoBotaoVerPerfil");
    }

    @FXML
    void acaoBotaoVerVagasAbertas(ActionEvent event) {
        System.out.println("acaoBotaoVerVagasAbertas");
    }


}
