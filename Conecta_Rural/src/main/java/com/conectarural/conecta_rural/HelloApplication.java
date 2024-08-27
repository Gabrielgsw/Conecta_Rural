package com.conectarural.conecta_rural;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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

    public static void main(String[] args) {
        launch();
    }
}