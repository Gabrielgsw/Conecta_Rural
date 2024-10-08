package com.conectarural.conecta_rural;

import java.time.Period;
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
    private Button botaoEditar;

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
    public void setDadosEstudante(String nome, String email, String telefone, String Cnpj, LocalDate dataNascimento,Curso curso,String periodo) {
        nomeEstudante.setText(nome);
        emailEstudante.setText(email);
        telefoneEstudante.setText(telefone);
        CPFestudante.setText(Cnpj);
        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(dataNascimento, dataAtual).getYears();
        idadeEstudante.setText(String.valueOf(idade));
        cursoEstudante.setText(curso.toString());
        periodoEstudante.setText(periodo);
    }

    @FXML
    void acaoBotaoCurriculo(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoCurriculo");

        ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("TelaCurriculo.fxml"));
        Parent root = loader.load();
        CurriculoController curriculoController = loader.getController();
        Usuario usuarioLogado = controladorSessao.getUsuarioLogado();

        if (usuarioLogado instanceof Estudante) {
            Estudante estudante = (Estudante) usuarioLogado;
            // Passando os dados do estudante para o controller da TelaPrincipalEstudante
            curriculoController.setDadosCurriculo(estudante.getCurso(),estudante.getPeriodoAtual());
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoEditar(ActionEvent event) throws IOException{
        ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("telaEditarPerfilEstudante.fxml"));
        Parent root = loader.load();
        EditarPerfilEstudanteController editarPerfilEstudanteController = loader.getController();
        Usuario usuarioLogado = controladorSessao.getUsuarioLogado();

        if (usuarioLogado instanceof Estudante) {
            Estudante estudante = (Estudante) usuarioLogado;
            // Passando os dados do estudante para o controller da TelaPrincipalEstudante
            editarPerfilEstudanteController.setDadosEditarEstudante(estudante.getNome(), estudante.getEmail(), estudante.getTelefone(),estudante.getCpf(),estudante.getDataNascimento(),estudante.getCurso(),estudante.getPeriodoAtual());
        }
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
