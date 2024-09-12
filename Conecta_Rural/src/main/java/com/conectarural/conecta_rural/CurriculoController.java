package com.conectarural.conecta_rural;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import com.conectarural.conecta_rural.models.*;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;


public class CurriculoController {

    private int quantidadeAtividades = 0;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button botaoGerarCurriculo;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea resumoEstudanteCurriculo;

    @FXML
    private TextField areaAtividade;

    @FXML
    private TextField atividadeNome;

    @FXML
    private ChoiceBox<String> atividadesEstudanteCurriculo = new ChoiceBox<>();

    @FXML
    private DatePicker dataFimAtividade;

    @FXML
    private DatePicker dataInicioAtividade;

   @FXML
   private TextField txtCurso;

    @FXML
    private TextField periodoAtualCurriculo;

    @FXML
    private TextArea resumoCurriculo;

    @FXML
    private Button salvarAtividades;

    @FXML
    private Button botaoSalvarCurriculo;

    @FXML
    private TextField tecnologiaAtividade;


    //Curriculo curriculo;

    ControllerUsuarioSessao controladorSessao = ControllerUsuarioSessao.getInstance();

    Estudante e = (Estudante)controladorSessao.getUsuarioLogado();

    public static int qtdCurriculos = 0;


    public void setDadosCurriculo(Curso curso, String periodo) {
        periodoAtualCurriculo.setText(periodo);
    }

    @FXML
    public void initialize(){
        atividadesEstudanteCurriculo.getItems().add("Estágio");
        atividadesEstudanteCurriculo.getItems().add("Projeto");
        atividadesEstudanteCurriculo.getItems().add("Trabalho");
        /*opcaoCurso.getItems().add(Curso.CienciaDaComputacao) ;
        opcaoCurso.getItems().add(Curso.LicenciaturaEmComputacao) ;
        opcaoCurso.getItems().add(Curso.MedicinaVeterinaria) ;
        opcaoCurso.getItems().add(Curso.Gastronomia) ;
        opcaoCurso.getItems().add(Curso.CienciasBiologias) ;
        opcaoCurso.getItems().add(Curso.LicenciaturaFisica) ;
        opcaoCurso.getItems().add(Curso.SistemasDeInformacao) ;*/
    }

    /*@FXML
    public void acaoBotaoGerarCurriculo(ActionEvent event) throws IOException {
        System.out.println("acaoBotaoGerarCurriculo");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("TelaCurriculo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    public void acaoBotaoVoltar(ActionEvent event) throws IOException{
        System.out.println("acaoBotaoVoltar");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("PerfilEstudante.fxml"));
        Parent root = loader.load();
        PerfilEstudanteController perfilEstudanteController = loader.getController();
        Usuario usuarioLogado = controladorSessao.getUsuarioLogado();

        if (usuarioLogado instanceof Estudante) {
            Estudante estudante = (Estudante) usuarioLogado;
            perfilEstudanteController.setDadosEstudante(estudante.getNome(), estudante.getEmail(), estudante.getTelefone(),estudante.getCpf(),estudante.getDataNascimento(),estudante.getCurso(),estudante.getPeriodoAtual());
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void acaoSalvar(ActionEvent event) throws IOException {
        //Estudante e = (Estudante)controladorSessao.getUsuarioLogado();

        if(e == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao cadastrar atividades");
            alert.setHeaderText("Currículo não existente");
            alert.setContentText("erro");
            alert.show();
        }else{
            //curriculo.
            Atividade a = null;
            System.out.println(atividadesEstudanteCurriculo.getSelectionModel().getSelectedItem());
            if(atividadesEstudanteCurriculo.getSelectionModel().getSelectedItem().equals("Estágio")){
                a = new Estagio(atividadeNome.getText(),resumoCurriculo.getText(),areaAtividade.getText(),tecnologiaAtividade.getText(),dataInicioAtividade.getValue(),dataFimAtividade.getValue());
            }
            if (atividadesEstudanteCurriculo.getSelectionModel().getSelectedItem().equals("Projeto")){
                a = new Projeto(atividadeNome.getText(),resumoCurriculo.getText(),areaAtividade.getText(),tecnologiaAtividade.getText(),dataInicioAtividade.getValue(),dataFimAtividade.getValue());
            }

            if(atividadesEstudanteCurriculo.getSelectionModel().getSelectedItem().equals("Trabalho")){
                a = new Projeto(atividadeNome.getText(),resumoCurriculo.getText(),areaAtividade.getText(),tecnologiaAtividade.getText(),dataInicioAtividade.getValue(),dataFimAtividade.getValue());
            }
            quantidadeAtividades++;
            e.getCurriculoEstudante().setAtividades(a);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Atividades cadastradas no curriculo");
            alert.setHeaderText("Sucesso ao cadastrar atividades");
            alert.setContentText("Sucesso");
            alert.show();
           atividadeNome.setText("");
           resumoCurriculo.setText("");
           areaAtividade.setText("");
           tecnologiaAtividade.setText("");
           dataInicioAtividade.setValue(null);
           dataFimAtividade.setValue(null);
           quantidadeAtividades = 0;
        }

    }



    @FXML
    public void acaoBotaoSalvarCurrículo(ActionEvent event) throws IOException {
        Curriculo curriculo = new Curriculo( resumoEstudanteCurriculo.getText(), parseInt(periodoAtualCurriculo.getText()),txtCurso.getText());
        //Estudante e = (Estudante)controladorSessao.getUsuarioLogado();
        System.out.println(curriculo);
        e.setCurriculoEstudante(curriculo);
        System.out.println(e.getCurriculoEstudante());
        System.out.println("curriculo criado");
        qtdCurriculos++;
        System.out.println(qtdCurriculos);

    }

    @FXML
    public void acaoBotaoGerarCurriculo(ActionEvent event) throws IOException{
        String caminhoArquivo = "documento"+qtdCurriculos+".pdf";

        try {
            // Cria o PdfWriter e o PdfDocument
            PdfWriter writer = new PdfWriter(caminhoArquivo);
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Cria um documento
            Document documento = new Document(pdfDoc);

            // Adiciona um parágrafo de texto ao documento
            int i = 0;

            documento.add(new Paragraph(e.getNome()));
            documento.add(new Paragraph("E-mail: "+e.getEmail()));
            documento.add(new Paragraph("Telefone: "+e.getTelefone()));
            documento.add(new Paragraph("Curso: "+e.getCurso()));
            documento.add(new Paragraph("Periodo: "+e.getPeriodoAtual()));
            documento.add(new Paragraph("Data de Nascimento: "+e.getDataNascimento()));
            documento.add(new Paragraph("Resumo: "+e.getCurriculoEstudante().getResumo()));
            documento.add(new Paragraph("Atividades: \n"));
            for(Atividade a : e.getCurriculoEstudante().getAtividades()){
                documento.add(new Paragraph("Nome da atividade: "+a.getNome()));
                //documento.add(new Paragraph("\n"));
                documento.add(new Paragraph("Resumo atividade: "+a.getResumo()));
                //documento.add(new Paragraph("\n"));
                documento.add(new Paragraph("Area: "+a.getArea()));
                documento.add(new Paragraph("Tecnologias: "+a.getTecnologias()));
                documento.add(new Paragraph("Data inicial: "+a.getData().toString()));
                documento.add(new Paragraph("Data final: "+a.getDataFinal().toString()));

            }


            // Fecha o documento
            documento.close();

            System.out.println("PDF gerado com sucesso!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}