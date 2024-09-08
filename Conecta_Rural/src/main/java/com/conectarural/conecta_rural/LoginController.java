package com.conectarural.conecta_rural;


import com.conectarural.conecta_rural.exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.exceptions.FalhaLoginException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private Button cadastroBT;
    @FXML
    private Button entrarBT;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField senhaField;

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();

    @FXML
    public void onCadastroBTaction(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("EmpresaCadastro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //Scene mscene = new Scene(root, 600, 400 );
        // Stage nstage = new Stage();
        // nstage.setScene(mscene);
        //nstage.show();
        //System.out.println("Cadastro BT");
    }

    private boolean validarInformacoes() {
        String erro = "";

        if (emailField.getText() == null || emailField.getText().isEmpty())
            erro += "Campo email vazio\n";
        if (senhaField.getText() == null || senhaField.getText().isEmpty())
            erro += "Campo senha vazio\n";

        if (erro.length() == 0)
            return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no login");
            alert.setHeaderText("Existem campos vazios");
            alert.setContentText(erro);
            alert.show();
            return false;
        }
    }

    @FXML
    public void onentrarBTaction(ActionEvent event) throws IOException, ElementoJaExistenteException {
        Stage stage;
        Scene scene;
        Parent root;

        String email = emailField.getText();
        String senha = senhaField.getText();
        if (validarInformacoes()) {
            try {
                controladorSessao.realizarLogin(email, senha);
                System.out.println("teste1");

            } catch (FalhaLoginException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Email ou senha estão errados.");
                alerta.setContentText("Tente novamente.");
                alerta.showAndWait();
                throw new RuntimeException(e);
            }


           /* if (controladorSessao.getUsuarioLogado() instanceof Estudante) {
                root = FXMLLoader.load(getClass().getResource("TelaPrincipalEstudante.fxml"));
            } else {
                root = FXMLLoader.load(getClass().getResource("TelaPrincipalEmpresa.fxml"));
            }*/

            //if (u.getEmail().equals(emailField.getText()) && u.getSenha().equals(senhaField.getText())) {
            //  controladorSessao.setUsuarioLogado(u);
            //    //controllerUsuario.adicionar(u);
            //  }


            root = FXMLLoader.load(HelloApplication.class.getResource("EscolherPerfil.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }
}