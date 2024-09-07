package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.dados.VagasRepository;
import com.conectarural.conecta_rural.exceptions.ElementoNaoExistenteException;
import com.conectarural.conecta_rural.models.Vaga;
import com.conectarural.conecta_rural.negocio.ControllerVaga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.conectarural.conecta_rural.HelloApplication.controllerVaga;

public class EditarVagasController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button buscarVagaBT;

    @FXML
    private TextField codigoDaVagaField;

    @FXML
    private TableView<?> tableVagas;

    @FXML
    private Button voltarTelaBT;

    private static Integer vaga;

    public void voltarTela(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaVisualizarVagasAbertas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void onBuscarVagaBTaction(ActionEvent event) throws IOException, ElementoNaoExistenteException {

        try {
            if (codigoDaVagaField.getText() == null || codigoDaVagaField.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro na Busca");
                alert.setHeaderText("Existem campos vazios");
                alert.setContentText("Digite um Código Válido");
                alert.show();

            } else {

                boolean existe = false;

                for (Vaga v : controllerVaga.listar()) {

                    if (v.getCodigoVaga() == Integer.parseInt(codigoDaVagaField.getText())) {

                        vaga = v.getCodigoVaga();

                        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaEdicaoDeVaga.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        existe = true;


                    }

                }
                if (!existe) {
                    throw new ElementoNaoExistenteException();
                }

            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro na Busca");
            alert.setHeaderText("Vaga Não Existe");
            alert.setContentText("Digite um Código Válido");
            alert.show();
        }

    }

    public static Integer getCodigo() {
        return vaga;
    }

}
