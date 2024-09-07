package com.conectarural.conecta_rural;


import com.conectarural.conecta_rural.exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.exceptions.ElementoNaoExistenteException;
import com.conectarural.conecta_rural.exceptions.ElementosNaoIguaisException;
import com.conectarural.conecta_rural.models.Vaga;
import com.conectarural.conecta_rural.negocio.ControllerVaga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class EdicaoVagaController {

    //falta atualizar os tipos enumerados com base no menu (statusVaga e regime contratacao)

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private TextField nomeVagaField;

    @FXML
    private TextField codigoField;

    @FXML
    private TextArea descricaoArea;

    @FXML
    private MenuItem menuAberta;

    @FXML
    private MenuItem menuEmAndamento;

    @FXML
    private MenuItem menuEncerrada;

    @FXML
    private TextField quantidadeVagasField;

    @FXML
    private TextField remuneracaoField;

    @FXML
    private MenuButton statusMenu;

    @FXML
    private Button salvarButton;

    private Integer codigoVaga;

    private Vaga nova;

    private Vaga vagaAntiga;

    ControllerVaga controladorVaga = ControllerVaga.getInstance();

    @FXML
    public void initialize() throws ElementoNaoExistenteException {

        codigoVaga = EditarVagasController.getCodigo();

        //vagaAntiga = controladorVaga.recuperarVaga(codigoVaga);

        for(Vaga v : controladorVaga.listar()){

            if(v.getCodigoVaga() == codigoVaga){
                vagaAntiga = v;
            }

        }

        codigoField.setText(Integer.toString(vagaAntiga.getCodigoVaga()));
        descricaoArea.setText(vagaAntiga.getDescricaoVaga());
        quantidadeVagasField.setText(Integer.toString(vagaAntiga.getQuantidadeVagas()));
        remuneracaoField.setText(Double.toString(vagaAntiga.getRemuneracao()));
        nomeVagaField.setText(vagaAntiga.getNomeVaga());

    }

public void onSalvarButtonAction(ActionEvent event) throws IOException, ElementoNaoExistenteException, ElementosNaoIguaisException, ElementoJaExistenteException {


        try {
           // Integer codigo = parseInt(codigoField.getText());
            String descricao = descricaoArea.getText();
            Integer quantidade = parseInt(quantidadeVagasField.getText());
            Double remuneracao = parseDouble(remuneracaoField.getText());
            String nome = nomeVagaField.getText();

            nova = new Vaga();

            nova.setCodigoVaga(vagaAntiga.getCodigoVaga());
            nova.setNomeVaga(nome);
            nova.setDescricaoVaga(descricao);
            nova.setQuantidadeVagas(quantidade);
            nova.setRemuneracao(remuneracao);
            nova.setCandidaturas(vagaAntiga.getCandidaturas());
            nova.setEmpresa(vagaAntiga.getEmpresa());
            nova.setQuantidadeCandidatos(vagaAntiga.getQuantidadeCandidatos());


            controladorVaga.atualizarVaga(vagaAntiga, nova);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edição Inválida!");
            alert.setHeaderText("Não Foi Possível Editar a Vaga.");
            alert.setContentText("Algum Campo Está Preenchido Incorretamente.");
            alert.show();
        } finally {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaEditarVagasAbertas.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

}




}
