package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.Vaga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerEditarVaga {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private Button buscarVagaBT;
    @FXML
    private Button editarVagaBT;
    @FXML
    private Button voltarTelaBT;
    @FXML
    private TableView<Vaga> tableVagas;

    @FXML
    public void onvoltarTelaBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaVisualizarVagasAbertas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onbuscarVagaBTaction(ActionEvent event) throws IOException {
        System.out.println("test");
    }

}
