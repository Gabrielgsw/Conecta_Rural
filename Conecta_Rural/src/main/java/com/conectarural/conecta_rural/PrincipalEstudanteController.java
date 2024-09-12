package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.models.Empresa;

import javafx.event.ActionEvent;
import com.conectarural.conecta_rural.models.Estudante;
import com.conectarural.conecta_rural.models.Usuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.conectarural.conecta_rural.HelloApplication.controllerUsuarioSessao;

public class PrincipalEstudanteController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

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
    private ImageView fotoGenerica;

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();


    Image image= new Image(getClass().getResourceAsStream("fotoAnonima.jpg"));

    public void displayImage(){
        fotoGenerica.setImage(image);
    }

    //recebendo
    public void setDadosEstudante(String nome) {
        nomeEstudante.setText(nome);
    }



    @FXML
    void acaoBotaoBuscarVagas(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoBuscarVagas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaBuscarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void acaoBotaoCandidaturas(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoCandidaturas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("VisualizarCandidaturas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoSairEstudante(ActionEvent event) throws IOException{
        controllerUsuarioSessao.setUsuarioLogado(null);
        System.out.println("acaoBotaoSairEstudante");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoVerPerfil(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoVerPerfil");
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


    @FXML
    void acaoBotaoVerVagasAbertas(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVerVagasAbertas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("telaBuscarVagasAbertasEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
