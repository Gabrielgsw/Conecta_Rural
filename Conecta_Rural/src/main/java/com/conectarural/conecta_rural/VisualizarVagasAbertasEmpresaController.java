package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.exceptions.ElementoNaoExistenteException;
import com.conectarural.conecta_rural.exceptions.ElementosNaoIguaisException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class VisualizarVagasAbertasEmpresaController {

    @FXML
    private Button editarVagasBT;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button voltarTelaBT;
    @FXML
    private TableView<Vaga> tableVagas;
    @FXML
    private Button removerVagaBT;



    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
    ControllerVaga controllerVaga = ControllerVaga.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
    ControllerCandidatura controllerCandidatura = ControllerCandidatura.getInstance();

    @FXML
    public void initialize() throws IOException {
        tableVagas.setEditable(true);
        TableColumn<Vaga, String> colCodigo = new TableColumn<>("Código");
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoVaga().toString()));
       // colCodigo.setCellFactory(TextFieldTableCell.<Vaga>forTableColumn());

        TableColumn<Vaga,String> colNome= new TableColumn<>("Nome");
        colNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomeVaga()));
       // colNome.setCellFactory(TextFieldTableCell.<Vaga>forTableColumn());
        TableColumn<Vaga, String> colCandidatados = new TableColumn<>("Candidatados");
        colCandidatados.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQuantidadeCandidatos().toString()));
        //colCandidatados.setCellFactory(TextFieldTableCell.<Vaga>forTableColumn());
        TableColumn<Vaga, String> colQuantidade= new TableColumn<>("Quantidade");
        colQuantidade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQuantidadeVagas().toString()));
        //colQuantidade.setCellFactory(TextFieldTableCell.<Vaga>forTableColumn());

        tableVagas.getColumns().addAll(colCodigo,colNome,colCandidatados,colQuantidade);
        Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", "8123","Rua das mocas,77","teste","11357", LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        Empresa e2 = new Empresa("Teste","teste@gmail.com","32423423","Rua Manoel de Medeiros","teste123","12321-2121","20","Tecnologia","teste");
        tableVagas.getItems().add(new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250D,2,e2,001, RegimeContratacao.Estagio, StatusVaga.Aberta));
        //Empresa e2 = new Empresa("Teste","teste@gmail.com",32423423L,"Rua Manoel de Medeiros","teste123","12321-2121",20,"Tecnologia","teste");
        //Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", 8123L,"Rua das mocas,77","teste",11357L, LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        //tabelaCandidatura.getItems().add(new Candidatura(e1,LocalDateTime.now(),new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250,2,e2,001,RegimeContratacao.Estagio,StatusVaga.Aberta)));
        for(Vaga v : controllerVaga.listar()){
            tableVagas.getItems().add(v);

        }
    }

    Vaga vaga;
    @FXML
    public void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2){
            System.out.println(tableVagas.getSelectionModel().getSelectedItem());
            vaga = tableVagas.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    public void onremoverVagaBTaction(ActionEvent event) throws IOException, ElementoNaoExistenteException {

        for(Vaga v : controllerVaga.listar()){
            controllerVaga.excluirVaga(v);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vaga removida com sucesso!");
        alert.setHeaderText("Vaga removida.");
        alert.setContentText("confirmation");
        alert.show();
    }



    @FXML
    public void onvoltarTelaBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void oneditarVagasBTaction(ActionEvent event) throws IOException, ElementoNaoExistenteException, ElementosNaoIguaisException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaEditarVagasAbertas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        /*Vaga v = tableVagas.getSelectionModel().getSelectedItem();

        for(Vaga vaga : controllerVaga.listar()){
            if(vaga.getCodigoVaga() == v.getCodigoVaga()){
                controllerVaga.atualizarVaga(vaga,v);
            }
        }*/


    }

}
