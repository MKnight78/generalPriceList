package com.example.generalpricelist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChargesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChargesApplication.class.getResource("charges-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Animalshttps://www.dropbox.com/sh/yj3svph2wuvqtmf/AAAgY0pnp5jRip0Uvl9oX5D9a?dl=0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}