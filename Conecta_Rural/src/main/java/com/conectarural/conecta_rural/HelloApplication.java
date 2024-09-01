package com.conectarural.conecta_rural;

import com.conectarural.conecta_rural.models.*;
import com.conectarural.conecta_rural.negocio.ControllerCandidatura;
import com.conectarural.conecta_rural.negocio.ControllerUsuario;
import com.conectarural.conecta_rural.negocio.ControllerUsuarioSessao;
import com.conectarural.conecta_rural.negocio.ControllerVaga;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //Scene scene = new Scene(parent);
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Conecta Rural");
        stage.setResizable(false);
        stage.show();
    }

   static ControllerVaga controllerVaga = ControllerVaga.getInstance();
   static ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
   static ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
   static ControllerCandidatura controllerCandidatura = ControllerCandidatura.getInstance();



    public static void main(String[] args) {

        Estudante e1 = new Estudante("Gabriel","ggermanow279@gmail.com", 8123L,"Rua das mocas,77","teste",11357L, LocalDate.of(2003,01,26),new Curriculo("Teste descrição",3, Curso.CienciaDaComputacao));
        Empresa e2 = new Empresa("Teste","teste@gmail.com",32423423L,"Rua Manoel de Medeiros","teste123","12321-2121",20,"Tecnologia","teste");

        Vaga v1 = new Vaga("Estágio em Desenvolvimento de sistemas","teste",0,1250D,2,e2,001,RegimeContratacao.Estagio,StatusVaga.Aberta);
        Candidatura c1 = new Candidatura(e1, LocalDateTime.now(),v1);

        launch();
    }
}