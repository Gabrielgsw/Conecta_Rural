package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Empresa;
import com.conectarural.conecta_rural.models.Usuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class PerfilEmpresaController {

    @FXML
    private Button editarPerfilBtn;
    @FXML
    private Button voltarTelaPrincipalBtn;
    @FXML
    private Label areaEmpresaLabel;

    @FXML
    private Label cnjpEmpresaLabel;
    @FXML
    private Label numeroFuncionariosLabel;
    @FXML
    private TextArea descricaoEmpresaArea;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private ImageView fotoGenerica;

    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();

    Usuario u = controllerUsuarioSessao.getUsuarioLogado();

    Empresa e1 = (Empresa) u;


    public void initialize() {

        cnjpEmpresaLabel.setText(e1.getCnpj());
        numeroFuncionariosLabel.setText(e1.getQuantidadeFuncionarios());
        descricaoEmpresaArea.setText(e1.getDescricao());
        areaEmpresaLabel.setText(e1.getAreaAtuacao());

    }


    Image image= new Image(getClass().getResourceAsStream("fotoAnonima.jpg"));

    public void displayImage(){
        fotoGenerica.setImage(image);
    }

    @FXML
    public void onvoltarTelaPrincipalBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void oneditarPerfilBtn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaEdicaoPerfilEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
