package com.conectarural.conecta_rural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalEmpresaController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button visualizarCandidaturas;

    @FXML
    private Button buscarEstudantesBtn;

    @FXML
    private Button cadastrarNovaVagaBtn;

    @FXML
    private Button meuPerfilBtn;

    @FXML
    private Label nomeDaEmpresaLabel;

    @FXML
    private Button paginaAnteriorBtn;

    @FXML
    private Button visualizarMinhasVagasBtn;

    @FXML
    private ImageView fotoGenerica;

    Image image= new Image(getClass().getResourceAsStream("fotoAnonima.jpg"));

    public void displayImage(){
        fotoGenerica.setImage(image);
    }

    @FXML
    public void onCadastrarNovaVagaBtnBtnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCadastrarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onBuscarEstudantesBtnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaBuscarEstudantes.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onPaginaAnteriorBtnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onVisualizarMinhasVagasBtnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaVisualizarVagasAbertas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onMeuPerfilBtnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPerfilEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onVisualizarCandidaturasBtnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaVisualizarCandidaturasEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
