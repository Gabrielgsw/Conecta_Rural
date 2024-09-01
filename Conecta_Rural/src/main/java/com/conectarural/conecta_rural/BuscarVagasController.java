package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Candidatura;
import com.conectarural.conecta_rural.models.Empresa;
import com.conectarural.conecta_rural.models.Vaga;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BuscarVagasController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button botaoBuscar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TableView<Vaga> table;




    @FXML
    private AnchorPane BuscarVagasAnchorPane;

    @FXML void initialize(){
        //coluna data
        ;//fim da coluna Data
        TableColumn<Vaga, String> colNomeVaga = new TableColumn<>("Nome");
        colNomeVaga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpresa().getNome()));

        TableColumn<Vaga,String> colEmpresa= new TableColumn<>("Empresa");
        colEmpresa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpresa().getNome()));

        TableColumn<Vaga, String> colRemuneracao = new TableColumn<>("Status");
        colRemuneracao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRemuneracao().toString()));
        TableColumn<Vaga, String> colDescricao = new TableColumn<>("Status");
        colDescricao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescricaoVaga()));

        table.getColumns().addAll(colNomeVaga,colEmpresa,colRemuneracao,colDescricao);
        //Empresa e2 = new Empresa("Teste","teste@gmail.com",32423423L,"Rua Manoel de Medeiros","teste123","12321-2121",20,"Tecnologia","teste");
        //Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", 8123L,"Rua das mocas,77","teste",11357L, LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        //tabelaCandidatura.getItems().add(new Candidatura(e1,LocalDateTime.now(),new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250,2,e2,001,RegimeContratacao.Estagio,StatusVaga.Aberta)));
    }


    @FXML
    public void acaoBotaoBuscarVagas(ActionEvent event) throws IOException {


        System.out.println("acaoBotaoBuscarVagas");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaBuscarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void acaoBotaoVoltar(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVoltar");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
