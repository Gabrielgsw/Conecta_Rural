package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PerfilEstudanteController {

    @FXML
    private Button botaoVoltar;

    @FXML
    private AnchorPane perfilEstudante;

    @FXML
    void acaoBotaoVoltar(ActionEvent event) {
        System.out.println("acaoBotaoVoltar");
    }

}
