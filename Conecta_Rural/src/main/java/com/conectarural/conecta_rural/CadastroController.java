package com.conectarural.conecta_rural;


import com.conectarural.conecta_rural.exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.models.*;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.conectarural.conecta_rural.HelloApplication.controllerUsuarioSessao;

public class CadastroController {
    @FXML
    private Button cadastrarBT;

    @FXML
    private Button redirecionarLoginBT;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField cnpjField;

    @FXML
    private TextField telefoneField;
    @FXML
    private TextField enderecoField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField areaDaEmpresaField;
    @FXML
    private TextArea descricaoArea;
    @FXML
    private TextField quantidadeDeFuncionariosField;
    @FXML
    private ChoiceBox<String> escolhaPerfil = new ChoiceBox<>();
    @FXML
    private TextField periodoatual;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private ChoiceBox<Curso> escolhaCursos= new ChoiceBox<>();
    @FXML
    private Button voltarBT;

    @FXML
    public void onvoltarBTaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();
    ControllerUsuario controladorUsuario = ControllerUsuario.getInstance();

    @FXML
    public void initialize() {
        escolhaPerfil.getItems().add("Estudante");
        escolhaPerfil.getItems().add("Empresa");
        escolhaCursos.getItems().add(Curso.CienciaDaComputacao) ;
        escolhaCursos.getItems().add(Curso.LicenciaturaEmComputacao) ;
        escolhaCursos.getItems().add(Curso.MedicinaVeterinaria) ;
        escolhaCursos.getItems().add(Curso.Gastronomia) ;
        escolhaCursos.getItems().add(Curso.CienciasBiologias) ;
        escolhaCursos.getItems().add(Curso.LicenciaturaFisica) ;
        escolhaCursos.getItems().add(Curso.SistemasDeInformacao) ;
    }

    @FXML
    public void cadastrarOnAction(ActionEvent event) throws IOException, ElementoJaExistenteException {
//        Parent parent = FXMLLoader.load(getClass().getResource("CadastroRealizado.fxml"));

        //Scene mscene = new Scene(parent, 600, 400 );
        //Stage nstage = new Stage();
        //nstage.setScene(mscene);
       // nstage.show();

        String nome = nameField.getText();
        String email = emailField.getText();
        String cnpj = cnpjField.getText();
        String telefone = telefoneField.getText();
        String endereco = enderecoField.getText();
        String password = passwordField.getText();
        String escolha = escolhaPerfil.getSelectionModel().getSelectedItem();
        String quantidadeFuncionarios = quantidadeDeFuncionariosField.getText();
        String areaDaEmpresa = areaDaEmpresaField.getText();
        String descricao = descricaoArea.getText();
        String periodoAtual= periodoatual.getText();
        Curso cs = escolhaCursos.getSelectionModel().getSelectedItem();
        LocalDate dataNasc = dataNascimento.getValue();

        int cadastrado = 0;

        try{

        if(nome.isBlank() || email.isBlank() || cnpj.isBlank() || telefone.isBlank() || endereco.isBlank() || password.isBlank() || escolha.isBlank()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Campos necessários não preenchidos .");
            alerta.setContentText("Tente novamente.");
            alerta.showAndWait();
        }

        if((escolha.equals("Empresa")) && (!periodoAtual.isBlank() || cs != null || dataNasc != null)){
            System.out.println(periodoAtual);
            System.out.println(cs);
            System.out.println(dataNasc);
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Campos preenchidos incorretamente .");
            alerta.setContentText("Tente novamente.");
            alerta.showAndWait();

        }

        if((escolha.equals("Estudante")) && ((dataNasc == null || cs == null || periodoatual == null)) ){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Campos obrigatórios não preenchidos .");
            alerta.setContentText("Tente novamente.");
            alerta.showAndWait();
        }



        Usuario usuarioLogado = null;

        if(escolha.equals("Estudante") &&  (!quantidadeFuncionarios.isBlank()  || !areaDaEmpresa.isBlank()  || !descricao.isBlank())){
            System.out.println("teste");
            System.out.println(quantidadeFuncionarios);
            System.out.println(areaDaEmpresa);
            System.out.println(descricao);
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Campos preenchidos incorretamente! .");
            alerta.setContentText("Tente novamente.");
            alerta.showAndWait();

        }




        else if((escolha.equals("Estudante")) && (!nome.isBlank() && !email.isBlank() && !cnpj.isBlank() && !telefone.isBlank() && !endereco.isBlank() && !password.isBlank() && !escolha.isBlank() && dataNasc != null && cs != null && periodoatual != null)){
            Estudante estudante = new Estudante(nome,email,telefone,endereco,password,cnpj,dataNasc,cs,periodoAtual);
            Estudante e;
            boolean result = true;
            for(Usuario u : controladorUsuario.listar()){
                if(u instanceof Estudante){
                     e = (Estudante)u;
                    if(e.getEmail().equals(estudante.getEmail()) || e.getCpf().equals(estudante.getCpf())){
                        result = false;

                    }
                }


            }

            if(!result){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("O usuário já existe! .");
                alerta.setContentText("Tente novamente.");
                alerta.showAndWait();
            }else{
                controladorSessao.setUsuarioLogado(estudante);
                controladorUsuario.adicionar(estudante);
                usuarioLogado = estudante;
                cadastrado = 1;
            }




        }else if((escolha.equals("Empresa")) && (!nome.isBlank() && !email.isBlank() && !cnpj.isBlank() && !telefone.isBlank() && !endereco.isBlank() && !password.isBlank() && !escolha.isBlank()  )){
            Empresa empresa = new Empresa(nome,email,telefone,endereco,password,cnpj, quantidadeFuncionarios, areaDaEmpresa, descricao);
            Empresa e;
            boolean result = true;
            for(Usuario u : controladorUsuario.listar()){
                if(u instanceof Empresa){
                   e = (Empresa)u;
                    if(e.getEmail().equals(empresa.getEmail()) || e.getCnpj().equals(empresa.getCnpj())){
                        result = false;

                    }
                }


            }

            if(!result){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("O usuário já existe! .");
                alerta.setContentText("Tente novamente.");
                alerta.showAndWait();
            }else{
                controladorSessao.setUsuarioLogado(empresa);
                controladorUsuario.adicionar(empresa);
                usuarioLogado = empresa;
                cadastrado = 1;
            }

        }



        if(cadastrado == 1){
            controladorSessao.setUsuarioLogado(usuarioLogado);

            Parent root = FXMLLoader.load(HelloApplication.class.getResource("CadastroRealizado.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();}
        }catch(ElementoJaExistenteException e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("O usuário já existe! .");
            alerta.setContentText("Tente novamente.");
            alerta.showAndWait();
            throw new ElementoJaExistenteException();
        }
    }

    @FXML
    public void redirecionarLoginOnAction(ActionEvent event) throws IOException{
        controllerUsuarioSessao.setUsuarioLogado(null);
//        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));

        //Scene mscene = new Scene(parent, 600, 400 );
        //Stage nstage = new Stage();
        //nstage.setScene(mscene);
       // nstage.show();
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    //@Override

}

