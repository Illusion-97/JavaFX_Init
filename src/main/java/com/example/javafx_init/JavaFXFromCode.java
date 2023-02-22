package com.example.javafx_init;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXFromCode extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp);
        ImageView imageView = new ImageView("C:\\Users\\Admin Stagiaire\\IdeaProjects\\JavaFX_Init_02_2023\\src\\main\\resources\\com\\example\\javafx_init\\img\\jfxstage.png");
        imageView.setOnMouseClicked(mouseEvent -> openNewStage(stage));
        bp.setCenter(imageView);
        stage.setScene(scene);
        stage.show(); // Keep at last
    }

    private void openNewStage(Stage parent) {
        Stage newStage = new Stage();
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout,800,600); // Scene with dimensions
        newStage.setScene(scene);
        newStage.setOnCloseRequest(windowEvent -> parent.show());
        Button ajouterBtn = new Button("Ajouter");
        TextField produitTF = new TextField();
        Label label = new Label("Produit : ");
        HBox topHB = new HBox(label,produitTF,ajouterBtn); // Created with children
        ObservableList<String> produitOL = FXCollections.observableArrayList("Piles Alcalines", "Nain de jardin");
        produitOL.addAll("Sirop d'érable","I'm a Teapot");
        ListView<String> produitLV = new ListView<>(produitOL); // Linked to the ObservableList
        layout.setCenter(produitLV);
        layout.setTop(topHB);

        ajouterBtn.setOnAction(actionEvent -> {
            String produit = produitTF.getText(); // Read TextField Value
            if(!produit.isBlank()) {
                produitOL.add(produit); // Will be displayed automatically
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Nom du produit est vide.",ButtonType.CLOSE);
                alert.showAndWait(); // Wait for interaction with Alert
            }
            produitTF.clear();
        });
        parent.hide();
        newStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}