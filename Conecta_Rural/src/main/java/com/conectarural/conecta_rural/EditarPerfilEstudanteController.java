package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Curso;
import com.conectarural.conecta_rural.models.Empresa;
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
    Usuario u = ControllerUsuarioSessao.getInstance().getUsuarioLogado();

    Estudante e1 = (Estudante) u;

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
    private Curso getCursoFromString(String cursoTexto) {
        for (Curso curso : Curso.values()) {
            if (curso.toString().equals(cursoTexto)) {
                return curso;
            }
        }
        return null; //se o curso não for encontrado
    }

    @FXML
    void acaoBotaoVoltar(ActionEvent event) throws IOException {

        e1.setNome(editarNome.getText());
        e1.setEmail(editarEmail.getText());
        e1.setTelefone(editarTelefone.getText());
        int idade = Integer.parseInt(editarIdade.getText());
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = dataAtual.minusYears(idade);
        e1.setDataNascimento(dataNascimento);
        String cursoTexto = editarCurso.getText();
        Curso cursoSelecionado = getCursoFromString(cursoTexto);
        if (cursoSelecionado != null) {
            e1.setCurso(cursoSelecionado);
        } else {
            System.out.println("Curso inválido: " + cursoTexto);
        }
        int periodo = Integer.parseInt(editarPeriodo.getText());
        e1.setPeriodoAtual(periodo);

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("PerfilEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void acaoBotaoSalvar(ActionEvent event)  throws IOException {
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
