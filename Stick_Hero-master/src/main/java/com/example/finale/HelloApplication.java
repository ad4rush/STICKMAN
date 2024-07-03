package com.example.finale;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.finale.HelloController.home_page;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Stick Hero");
        stage.setScene(home_page());
        stage.setResizable(false);
        stage.show();
    }

    public static ImageView gif_viewer;

    public static void main(String[] args) {
        launch();
    }
}