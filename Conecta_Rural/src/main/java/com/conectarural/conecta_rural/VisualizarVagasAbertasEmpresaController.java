package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Vaga;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import com.conectarural.conecta_rural.negocio.ControllerVaga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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
    private TableView<Vaga> tabelaVagas;
    @FXML
    private TableColumn<Vaga, Integer> codigoColumn;
    @FXML
    private TableColumn<Vaga, String> nomeColumn;
    @FXML
    private TableColumn<Vaga, Integer> candidatadosColumn;
    @FXML
    private TableColumn<Vaga, Integer> quantidadeColumn;
    @FXML
    private Button buscarVagasBT;

    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
    ControllerVaga controllerVaga = ControllerVaga.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();

    @FXML
    public void onbuscarVagasBTaction(ActionEvent event) throws IOException {
        tabelaVagas = new TableView<>();
        codigoColumn = new TableColumn<Vaga,Integer>("Código");
        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeColumn = new TableColumn<>("nome");
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        candidatadosColumn = new TableColumn<>("candidatados");
        candidatadosColumn.setCellValueFactory(new PropertyValueFactory<>("candidatados"));
        quantidadeColumn = new TableColumn<>("quantidade");
        quantidadeColumn.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tabelaVagas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaVagas.getColumns().add(codigoColumn);
        tabelaVagas.getColumns().add(nomeColumn);
        tabelaVagas.getColumns().add(candidatadosColumn);
        tabelaVagas.getColumns().add(quantidadeColumn);


       // for(Vaga v : controllerVaga.listar()){
     //       tabelaVagas.getItems().add(v);
        //}
        tabelaVagas.getItems().add(new Vaga(1111,"teste",0,1));
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
    public void oneditarVagasBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaEditarVagasAbertas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
