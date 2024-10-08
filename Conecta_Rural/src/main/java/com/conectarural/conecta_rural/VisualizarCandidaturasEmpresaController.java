package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.*;
import com.conectarural.conecta_rural.negocio.ControllerCandidatura;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import com.conectarural.conecta_rural.negocio.ControllerVaga;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VisualizarCandidaturasEmpresaController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button voltarTelaBT;
    @FXML
    private TableView<Candidatura> tableCandidaturas;
    @FXML
    private Button aprovarCandidatoBT;

    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
    ControllerVaga controllerVaga = ControllerVaga.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
    ControllerCandidatura controllerCandidatura = ControllerCandidatura.getInstance();
    public static int aprovado = 0;

    @FXML
    public void onvoltarTelaBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void initialize() throws IOException {
        TableColumn<Candidatura, String> colCandidato = new TableColumn<>("Candidato");
        colCandidato.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCandidato().getNome()));

        TableColumn<Candidatura, String> colCodigo = new TableColumn<>("Código");
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVaga().getCodigoVaga().toString()));

        TableColumn<Candidatura, String> colVaga = new TableColumn<>("Vaga");
        colVaga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVaga().getNomeVaga()));



        tableCandidaturas.getColumns().addAll(colCandidato, colCodigo, colVaga);
        //Empresa e2 = new Empresa("Teste","teste@gmail.com","32423423","Rua Manoel de Medeiros","teste123","12321-2121","20","Tecnologia","teste");
        //Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", "8123","Rua das mocas,77","teste","11357", LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
       // tableCandidaturas.getItems().add(new Candidatura(e1, LocalDateTime.now(),new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250D,2,e2,001,RegimeContratacao.Estagio,StatusVaga.Aberta)));
        for(Candidatura c : controllerCandidatura.Listar()){
            tableCandidaturas.getItems().add(c);
        }
    }

    Candidatura c;
    Estudante e;
    @FXML
    public void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2) {
            System.out.println(tableCandidaturas.getSelectionModel().getSelectedItem());
            c = tableCandidaturas.getSelectionModel().getSelectedItem();
            e = c.getCandidato();
        }
    }

    @FXML
    public void onaprovarCandidatoBTaction(ActionEvent event) throws IOException {
        c.setAprovado("Sim");
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setHeaderText("O candidato selecionado foi aprovado na referida vaga! ");
        alerta.setContentText("Candidato aprovado!");
        alerta.showAndWait();
        aprovado = 1;
    }
}
