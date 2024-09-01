package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class VerCandidaturaController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private TableView<Candidatura> tabelaCandidatura;

    @FXML
    private Button botaoVoltar;

    @FXML void initialize(){
        //coluna data
        TableColumn<Candidatura,LocalDateTime> colData= new TableColumn<>("Data");
        colData.setCellValueFactory(new PropertyValueFactory<>("dataCandidatura"));
        colData.setCellFactory(column -> new TableCell<Candidatura, LocalDateTime>() {
            private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

            @Override
            protected void updateItem(LocalDateTime item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.format(formatter));
                }
            }
        });//fim da coluna Data
        TableColumn<Candidatura, String> colEmpresa = new TableColumn<>("Empresa");
        colEmpresa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVaga().getEmpresa().getNome()));

        TableColumn<Candidatura,String> colCandidatura= new TableColumn<>("Candidatura");
        colCandidatura.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVaga().getNomeVaga()));

        TableColumn<Candidatura, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVaga().getStatusVaga().toString()));

        tabelaCandidatura.getColumns().addAll(colData,colEmpresa,colCandidatura,colStatus);
        //Empresa e2 = new Empresa("Teste","teste@gmail.com",32423423L,"Rua Manoel de Medeiros","teste123","12321-2121",20,"Tecnologia","teste");
        //Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", 8123L,"Rua das mocas,77","teste",11357L, LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        //tabelaCandidatura.getItems().add(new Candidatura(e1,LocalDateTime.now(),new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250,2,e2,001,RegimeContratacao.Estagio,StatusVaga.Aberta)));
    }

    @FXML
    void acaoBotaoVoltar(ActionEvent event)throws IOException {
        System.out.println("acaoBotaoVoltar");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEstudante.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

