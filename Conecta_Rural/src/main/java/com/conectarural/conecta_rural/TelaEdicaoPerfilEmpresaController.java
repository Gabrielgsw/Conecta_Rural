package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Empresa;
import com.conectarural.conecta_rural.models.Usuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.conectarural.conecta_rural.HelloApplication.controllerUsuarioSessao;

public class TelaEdicaoPerfilEmpresaController {

    @FXML
    private Scene scene;

    @FXML
    private Stage stage;

    @FXML
    private TextField areaField;

    @FXML
    private Label cnpjLabel;

    @FXML
    private TextArea descricaoArea;

    @FXML
    private TextField quantidadeDeFuncionariosField;

    @FXML
    private Button salvarBtn;

    @FXML
    private Button voltarBtn;

    Usuario u = ControllerUsuarioSessao.getInstance().getUsuarioLogado();

    Empresa e1 = (Empresa) u;

    public void initialize() {

        cnpjLabel.setText(e1.getCnpj());
        descricaoArea.setText(e1.getDescricao());
        areaField.setText(e1.getAreaAtuacao());
        quantidadeDeFuncionariosField.setText(e1.getQuantidadeFuncionarios());

    }

    public void salvarBtnOnaction(ActionEvent event) throws IOException {

        e1.setAreaAtuacao(areaField.getText());
        e1.setDescricao(descricaoArea.getText());
        e1.setQuantidadeFuncionarios(quantidadeDeFuncionariosField.getText());

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPerfilEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void voltarBtnOnaction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPerfilEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
