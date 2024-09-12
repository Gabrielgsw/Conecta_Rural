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
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.conectarural.conecta_rural.CurriculoController.qtdCurriculos;

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
    @FXML
    private Button visualizarCurriculoBT;
    @FXML
    private ChoiceBox<Curso> cursos = new ChoiceBox<>();

    ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
    ControllerVaga controllerVaga = ControllerVaga.getInstance();
    ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
    ControllerCandidatura controllerCandidatura = ControllerCandidatura.getInstance();


    Estudante est;
    @FXML
    public void onvoltarTelaBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaPrincipalEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML void initialize() throws IOException {
        cursos.getItems().add(Curso.CienciaDaComputacao) ;
        cursos.getItems().add(Curso.LicenciaturaEmComputacao) ;
        cursos.getItems().add(Curso.MedicinaVeterinaria) ;
        cursos.getItems().add(Curso.Gastronomia) ;
        cursos.getItems().add(Curso.CienciasBiologias) ;
        cursos.getItems().add(Curso.LicenciaturaFisica) ;
        cursos.getItems().add(Curso.SistemasDeInformacao) ;
        TableColumn<Estudante, String> colEstudante = new TableColumn<>("Estudante");
        colEstudante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));

        TableColumn<Estudante,String> colEmail= new TableColumn<>("E-mail");
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        TableColumn<Estudante, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));

        TableColumn<Estudante, String> colCurso = new TableColumn<>("Curso");
        colCurso.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCurso().toString()));

        tableBuscarEstudantes.getColumns().addAll(colEstudante,colEmail,colTelefone,colCurso);
        //Empresa e2 = new Empresa("Teste","teste@gmail.com","32423423","Rua Manoel de Medeiros","teste123","12321-2121","20","Tecnologia","teste");
        //Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", "8123","Rua das mocas,77","teste","11357", LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        //tableBuscarEstudantes.getItems().add(e1);



      //  for(Usuario e : controllerUsuario.listar()){
       //     if(e.getClass() == Estudante.class){
       //         Estudante estudante = (Estudante)e;
       //         tableBuscarEstudantes.getItems().add(estudante);
      //      }
       // }





    }
    @FXML
    public void onbuscarEstudantesBTaction(ActionEvent event) throws IOException{
        for(Usuario e : controllerUsuario.listarPorCurso(cursos.getSelectionModel().getSelectedItem())){
            if(e instanceof Estudante){
                Estudante estudante = (Estudante)e;
                tableBuscarEstudantes.getItems().add(estudante);
            }
        }
    }

    @FXML
    public void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2) {
            System.out.println(tableBuscarEstudantes.getSelectionModel().getSelectedItem());
            est = tableBuscarEstudantes.getSelectionModel().getSelectedItem();
        }
    }


    @FXML
    public void onvisualizarCurriculoBTaction(ActionEvent event) throws IOException{

        try{
        if(est != null){
            int i = tableBuscarEstudantes.getSelectionModel().getSelectedIndex();

            java.awt.Desktop.getDesktop().browse(URI.create("file:///C:/Users/Gabriel%20Germano/Desktop/proj%20ultimo%20commit/Conecta_Rural/Conecta_Rural/documento"+(i+1)+".pdf"));





        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro ao acessar o currículo! .");
            alerta.setContentText("Tente novamente.");
            alerta.showAndWait();
        }}catch (Exception e){
            e.printStackTrace();
        }
    }


}
