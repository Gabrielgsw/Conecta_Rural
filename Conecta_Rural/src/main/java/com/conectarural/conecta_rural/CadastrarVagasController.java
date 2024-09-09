package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.models.Empresa;
import com.conectarural.conecta_rural.models.RegimeContratacao;
import com.conectarural.conecta_rural.models.StatusVaga;
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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastrarVagasController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private Button cadastrarVagaBtn;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button voltarTelaBT;

    @FXML
    private TextField codigoVagaField;

    @FXML
    private TextArea descricaoVagaArea;

    @FXML
    private TextField nomeDaVagaField;

    @FXML
    private TextField numeroDeVagasField;

    @FXML
    private MenuItem regimeClt;

    @FXML
    private MenuItem regimeEstagio;

    @FXML
    private MenuItem regimeFreelancer;

    @FXML
    private MenuItem regimePj;

    private MenuButton regimeContratacaoMenu;

    @FXML
    private MenuItem regimeTemporario;

    @FXML
    private TextField valorRemuneracaoField;

    @FXML
    private ChoiceBox<RegimeContratacao> regimeContratacao;

    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
    ControllerVaga controllerVaga = ControllerVaga.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();

    @FXML
    public void initialize(){
        regimeContratacao.getItems().add(RegimeContratacao.Estagio);
        regimeContratacao.getItems().add(RegimeContratacao.Freelancer);
        regimeContratacao.getItems().add(RegimeContratacao.CLT);
        regimeContratacao.getItems().add(RegimeContratacao.PessoaJuridica);
        regimeContratacao.getItems().add(RegimeContratacao.Temporario);
    }

    //@FXML
    private void criarVaga() throws ElementoJaExistenteException {
       /* Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCadastrarVagas.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/


        int codigoVaga = Integer.parseInt(codigoVagaField.getText());
        String descricaoVaga = descricaoVagaArea.getText();
        String nomeDaVaga = nomeDaVagaField.getText();
        String numeroDeVaga = numeroDeVagasField.getText();
        Double remuneracao = Double.parseDouble(valorRemuneracaoField.getText());
        RegimeContratacao rg = regimeContratacao.getSelectionModel().getSelectedItem();
        //RegimeContratacao rg = null;
        //var rg = RegimeContratacao.valueOf(regimeContratacaoMenu.getText());

        Vaga vaga = new Vaga(nomeDaVaga,descricaoVaga,0,remuneracao,1,(Empresa)controllerUsuarioSessao.getUsuarioLogado(),codigoVaga,rg,StatusVaga.Aberta);


        if(!controllerVaga.listar().isEmpty()){
            for(Vaga v : controllerVaga.listar()){
                if(v.equals(vaga) || v.getCodigoVaga() == vaga.getCodigoVaga()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro na criação da vaga");
                    alert.setHeaderText("Existem campos inválidos.");
                    alert.setContentText("Vaga já existente!");
                    alert.show();
                    break;
                }else{
                    controllerVaga.cadastrarVaga(vaga);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Vaga criada com sucesso!");
                    alert.setHeaderText("Sua vaga foi criada com as informações preenchidas.");
                    alert.setContentText("confirmation");
                    alert.show();
                    break;
                }

            }
        }else{
            controllerVaga.cadastrarVaga(vaga);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vaga criada com sucesso!");
            alert.setHeaderText("Sua vaga foi criada com as informações preenchidas.");
            alert.setContentText("confirmation");
            alert.show();
        }


        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaVagaCadastrada.fxml"));
        //stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //scene = new Scene(root);
        //stage.setScene(scene);
        //stage.show();



        codigoVagaField.setText("");
        numeroDeVagasField.setText("");
        descricaoVagaArea.setText("");
        nomeDaVagaField.setText("");
        valorRemuneracaoField.setText("");
        //regimeContratacao.getItems().clear();



    }

    private boolean verificar(){
        String erro = "";

        if(codigoVagaField.getText() == null || codigoVagaField.getText().length() == 0)
            erro += "Código Inválido!\n";
        if(nomeDaVagaField.getText() == null || nomeDaVagaField.getText().length() == 0)
            erro += "Nome Inválido!\n";
        if(valorRemuneracaoField.getText() == null ||valorRemuneracaoField.getText().length() == 0 )
            erro += "Remuneração Inválida!\n";
        if(descricaoVagaArea.getText() == null || descricaoVagaArea.getText().length() == 0)
            erro += "Descrição Inválida!\n";
        if(regimeContratacao.getSelectionModel().getSelectedItem() == null )
            erro += "Descrição Inválida!\n";

        if(erro.length() != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro na criação da vaga");
            alert.setHeaderText("Existem campos inválidos.");
            alert.setContentText(erro);
            alert.show();
            return false;
        }
        else{
            return true;
        }
    }

    @FXML
     public void onCadastrarVagaBtnaction(ActionEvent event) throws ElementoJaExistenteException {
        if(verificar())
            criarVaga();
    }

    public void onvoltarTelaBTaction(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCadastrarVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void onvoltarBtn(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
