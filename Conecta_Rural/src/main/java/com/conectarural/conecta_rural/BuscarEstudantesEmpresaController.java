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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BuscarEstudantesEmpresaController {

    @FXML
    private Button voltarTelaBT;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private TableView<Estudante> tableBuscarEstudantes;
    @FXML
    private Button buscarEstudantesBT;

    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
    ControllerVaga controllerVaga = ControllerVaga.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
    ControllerCandidatura controllerCandidatura = ControllerCandidatura.getInstance();


    @FXML
    public void onvoltarTelaBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML void initialize() throws IOException {
        TableColumn<Estudante, String> colEstudante = new TableColumn<>("Estudante");
        colEstudante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));

        TableColumn<Estudante,String> colEmail= new TableColumn<>("E-mail");
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        TableColumn<Estudante, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone().toString()));

        TableColumn<Estudante, String> colCurso = new TableColumn<>("Curso");
        colCurso.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCurriculoEstudante().getCurso().toString()));

        tableBuscarEstudantes.getColumns().addAll(colEstudante,colEmail,colTelefone,colCurso);
        Empresa e2 = new Empresa("Teste","teste@gmail.com","32423423","Rua Manoel de Medeiros","teste123","12321-2121","20","Tecnologia","teste");
        Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", "8123","Rua das mocas,77","teste","11357", LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        tableBuscarEstudantes.getItems().add(e1);



        for(Usuario e : controllerUsuario.listar()){
            if(e.getClass() == Estudante.class){
                Estudante estudante = (Estudante)e;
                tableBuscarEstudantes.getItems().add(estudante);
            }
        }




    }
}
