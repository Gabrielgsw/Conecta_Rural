package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        Parent parent = FXMLLoader.load(getClass().getResource("TelaBuscarVagas.fxml"));
        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();
    }

    @FXML
    void acaoBotaoCandidaturas(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoCandidaturas");
        Parent parent = FXMLLoader.load(getClass().getResource("VisualizarCandidaturas.fxml"));
        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();
    }

    @FXML
    void acaoBotaoSairEstudante(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoSairEstudante");
        Parent parent = FXMLLoader.load(getClass().getResource("EscolherPerfil.fxml"));
        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();
    }

    @FXML
    void acaoBotaoVerPerfil(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVerPerfil");
        Parent parent = FXMLLoader.load(getClass().getResource("PerfilEstudante.fxml"));
        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();
    }

    @FXML
    void acaoBotaoVerVagasAbertas(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVerVagasAbertas");
        Parent parent = FXMLLoader.load(getClass().getResource("TelaVisualizarVagasAbertas.fxml"));
        Scene mscene = new Scene(parent, 600, 400 );
        Stage nstage = new Stage();
        nstage.setScene(mscene);
        nstage.show();
    }


}
