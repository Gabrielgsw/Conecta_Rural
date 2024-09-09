package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.*;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


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
    private TextArea ResumoEstudanteCurriculo;

    @FXML
    private ChoiceBox<String> atividadesEstudanteCurriculo;

    @FXML
    private TextField opcaoCurso;

    @FXML
    private TextField periodoAtualCurriculo;

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();

    public void setDadosCurriculo(Curso curso, String periodo) {
        periodoAtualCurriculo.setText(periodo);
        opcaoCurso.setText(curso.toString());
    }

    @FXML
    public void initialize(){
        atividadesEstudanteCurriculo.getItems().add("Estágio");
        atividadesEstudanteCurriculo.getItems().add("Projeto");
        atividadesEstudanteCurriculo.getItems().add("Trabalho");
    }

    @FXML
    public void acaoBotaoGerarCurriculo(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoGerarCurriculo");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCurriculo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void acaoBotaoVoltar(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVoltar");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("PerfilEstudante.fxml"));
        Parent root = loader.load();
        PerfilEstudanteController perfilEstudanteController = loader.getController();
        Usuario usuarioLogado = controladorSessao.getUsuarioLogado();

        if (usuarioLogado instanceof Estudante) {
            Estudante estudante = (Estudante) usuarioLogado;
            perfilEstudanteController.setDadosEstudante(estudante.getNome(), estudante.getEmail(), estudante.getTelefone(),estudante.getCpf(),estudante.getDataNascimento(),estudante.getCurso(),estudante.getPeriodoAtual());
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
