package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Curso;
import com.conectarural.conecta_rural.models.Estudante;
import com.conectarural.conecta_rural.models.Usuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class EditarPerfilEstudanteController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField editarCPF;

    @FXML
    private TextField editarCurso;

    @FXML
    private TextField editarEmail;

    @FXML
    private TextField editarIdade;

    @FXML
    private TextField editarNome;

    @FXML
    private TextField editarPeriodo;

    @FXML
    private TextField editarTelefone;

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();

    public void setDadosEditarEstudante(String nome, String email, String telefone, String Cnpj, LocalDate dataNascimento, Curso curso, String periodo) {
        editarNome.setText(nome);
        editarEmail.setText(email);
        editarTelefone.setText(telefone);
        editarCPF.setText(Cnpj);
        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(dataNascimento, dataAtual).getYears();
        editarIdade.setText(String.valueOf(idade));
        editarCurso.setText(curso.toString());
        editarPeriodo.setText(periodo);
    }

    @FXML
    void acaoBotaoSalvar(ActionEvent event) throws IOException {

    }

    @FXML
    void acaoBotaoVoltar(ActionEvent event)  throws IOException {
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
