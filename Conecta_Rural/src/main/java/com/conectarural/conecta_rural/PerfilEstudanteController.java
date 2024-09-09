package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Estudante;
import com.conectarural.conecta_rural.models.Usuario;
import com.conectarural.conecta_rural.models.Curso;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class PerfilEstudanteController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private ImageView fotoGenerica;

    @FXML
    private TextField CPFestudante;

    @FXML
    private Button botaoCurriculo;

    @FXML
    private Button botaoVoltar;

    @FXML
    private AnchorPane perfilEstudante;

    @FXML
    private TextField cursoEstudante;

    @FXML
    private TextField emailEstudante;

    @FXML
    private TextField idadeEstudante;

    @FXML
    private TextField nomeEstudante;

    @FXML
    private TextField periodoEstudante;

    @FXML
    private TextField telefoneEstudante;

    Image image= new Image(getClass().getResourceAsStream("fotoAnonima.jpg"));

    public void displayImage(){
        fotoGenerica.setImage(image);
    }

    //recebendo
    public void setDadosEstudante(String nome, String email, String telefone, String Cnpj, LocalDate dataNascimento,Curso curso) {
        nomeEstudante.setText(nome);
        emailEstudante.setText(email);
        telefoneEstudante.setText(telefone);
        CPFestudante.setText(Cnpj);
        idadeEstudante.setText(dataNascimento.toString());
        cursoEstudante.setText(curso.toString());

    }

    @FXML
    void acaoBotaoCurriculo(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoCurriculo");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCurriculo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoVoltar(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVoltar");
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
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
