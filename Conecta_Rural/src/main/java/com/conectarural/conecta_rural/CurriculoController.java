package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.*;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;


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
    private TextField areaAtividade;

    @FXML
    private TextField atividadeNome;

    @FXML
    private ChoiceBox<String> atividadesEstudanteCurriculo;

    @FXML
    private DatePicker dataFimAtividade;

    @FXML
    private DatePicker dataInicioAtividade;

    @FXML
    private ChoiceBox<Curso> opcaoCurso;

    @FXML
    private TextField periodoAtualCurriculo;

    @FXML
    private TextArea resumoCurriculo;

    @FXML
    private Button salvarAtividades;

    @FXML
    private Button botaoSalvarCurriculo;

    @FXML
    private TextField tecnologiaAtividade;

    Curriculo curriculo;

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();

    public void setDadosCurriculo(Curso curso, String periodo) {
        periodoAtualCurriculo.setText(periodo);
    }

    @FXML
    public void initialize(){
        atividadesEstudanteCurriculo.getItems().add("Estágio");
        atividadesEstudanteCurriculo.getItems().add("Projeto");
        atividadesEstudanteCurriculo.getItems().add("Trabalho");
        opcaoCurso.getItems().add(Curso.CienciaDaComputacao) ;
        opcaoCurso.getItems().add(Curso.LicenciaturaEmComputacao) ;
        opcaoCurso.getItems().add(Curso.MedicinaVeterinaria) ;
        opcaoCurso.getItems().add(Curso.Gastronomia) ;
        opcaoCurso.getItems().add(Curso.CienciasBiologias) ;
        opcaoCurso.getItems().add(Curso.LicenciaturaFisica) ;
        opcaoCurso.getItems().add(Curso.SistemasDeInformacao) ;
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
    @FXML
    void acaoSalvar(ActionEvent event) {
        Estudante e = (Estudante)controladorSessao.getUsuarioLogado();
        if(e.getCurriculoEstudante() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao cadastrar atividades");
            alert.setHeaderText("Currículo não existente");
            alert.setContentText("erro");
            alert.show();
        }else{
            //curriculo.
        }

    }



    @FXML
    public void acaoBotaoSalvarCurrículo(ActionEvent event) {
        curriculo = new Curriculo( resumoCurriculo.getText(), parseInt(periodoAtualCurriculo.getText()),opcaoCurso.getSelectionModel().getSelectedItem());
        Estudante e = (Estudante)controladorSessao.getUsuarioLogado();
        e.setCurriculoEstudante(curriculo);

    }

}