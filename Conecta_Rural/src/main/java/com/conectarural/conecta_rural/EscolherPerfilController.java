package com.conectarural.conecta_rural;


import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import com.conectarural.conecta_rural.models.Estudante;
import com.conectarural.conecta_rural.models.Usuario;
import com.conectarural.conecta_rural.models.Empresa;
import com.conectarural.conecta_rural.models.Estudante;
import com.conectarural.conecta_rural.models.Usuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static com.conectarural.conecta_rural.HelloApplication.controllerUsuarioSessao;

public class EscolherPerfilController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button btnEmpresa;
    @FXML
    private Button btnEstudante;
    @FXML
    private Button voltarBT;

    private int entrou = 0;

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();

    @FXML
    public void onVoltarBTaction(ActionEvent event) throws IOException {
        controllerUsuarioSessao.setUsuarioLogado(null);
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onBTEstudanteaction(ActionEvent event) throws IOException {
        // Variável local para controladorSessao
        ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("TelaPrincipalEstudante.fxml"));
        Parent root = loader.load();
        PrincipalEstudanteController principalEstudanteController = loader.getController();
        Usuario usuarioLogado = controladorSessao.getUsuarioLogado();

        if (usuarioLogado instanceof Estudante) {
            Estudante estudante = (Estudante) usuarioLogado;
            // Passando os dados do estudante para o controller da TelaPrincipalEstudante
            principalEstudanteController.setDadosEstudante(estudante.getNome());
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        if(controladorSessao.getUsuarioLogado() instanceof Empresa){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Esolha incorreta! Entre no perfil  para empresas!");
            alerta.setContentText("Tente novamente.");
            entrou = 0;
            alerta.showAndWait();
        }else{
            entrou = 1;
        }

        if(entrou !=0){
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    }

    @FXML
    public void onBTEmpresaaction(ActionEvent event) throws IOException {
        if(controladorSessao.getUsuarioLogado() instanceof Estudante){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Esolha incorreta! Entre no perfil para estudante!");
            alerta.setContentText("Tente novamente.");
            entrou = 0;
            alerta.showAndWait();
        }else{
            entrou = 1;
        }

        if(entrou != 0){
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    }

}
