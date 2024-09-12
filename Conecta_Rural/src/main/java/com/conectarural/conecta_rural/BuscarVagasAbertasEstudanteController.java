package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.models.*;
import com.conectarural.conecta_rural.negocio.ControllerCandidatura;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import com.conectarural.conecta_rural.negocio.ControllerVaga;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BuscarVagasAbertasEstudanteController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TableView<Vaga> tabelaVagaAberta;

    @FXML
    private AnchorPane telaVagasAbertas;


    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
    ControllerVaga controllerVaga = ControllerVaga.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
    ControllerCandidatura controllerCandidatura = ControllerCandidatura.getInstance();

    @FXML void initialize(){
        TableColumn<Vaga, String> colNomeVaga = new TableColumn<>("Nome");
        colNomeVaga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomeVaga()));

        TableColumn<Vaga,String> colEmpresa= new TableColumn<>("Empresa");
        colEmpresa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpresa().getNome()));

        TableColumn<Vaga, String> colRemuneracao = new TableColumn<>("Remuneração");
        colRemuneracao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRemuneracao().toString()));
        TableColumn<Vaga, String> colDescricao = new TableColumn<>("Descrição");
        colDescricao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescricaoVaga()));
        TableColumn<Vaga, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatusVaga().toString()));

        tabelaVagaAberta.getColumns().addAll(colNomeVaga,colEmpresa,colRemuneracao,colDescricao,colStatus);

        // Filtra as vagas com status "aberta" (comparação de String)
        for (Vaga v : controllerVaga.listar()) {
            if ("aberta".equalsIgnoreCase(v.getStatusVaga().toString())) {
                tabelaVagaAberta.getItems().add(v);
            }
        }

       // Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", "8123","Rua das mocas,77","teste","11357", LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
       // Empresa e2 = new Empresa("Teste","teste@gmail.com","32423423","Rua Manoel de Medeiros","teste123","12321-2121","20","Tecnologia","teste");
        //tabelaVagaAberta.getItems().add(new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250D,2,e2,001, RegimeContratacao.Estagio, StatusVaga.Aberta));
        //Empresa e2 = new Empresa("Teste","teste@gmail.com",32423423L,"Rua Manoel de Medeiros","teste123","12321-2121",20,"Tecnologia","teste");
        //Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", 8123L,"Rua das mocas,77","teste",11357L, LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        //tabelaCandidatura.getItems().add(new Candidatura(e1,LocalDateTime.now(),new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250,2,e2,001,RegimeContratacao.Estagio,StatusVaga.Aberta)));
    }

    Vaga vaga;
    @FXML
    public void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2){
            System.out.println(tabelaVagaAberta.getSelectionModel().getSelectedItem());
            vaga = tabelaVagaAberta.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    void acoaBotaoVoltar(ActionEvent event) throws IOException{
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
