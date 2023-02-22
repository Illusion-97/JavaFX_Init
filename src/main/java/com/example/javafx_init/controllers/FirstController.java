package com.example.javafx_init.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FirstController {
    public TextField produitTF;
    public Button ajouterBtn;
    public ListView<String> produitLv;


    @FXML
    protected void onAjouterButtonClick() {
        String produit = produitTF.getText();
        if(!produit.isBlank()){
            produitLv.getItems().add(produit); // Get ObservableList from ListView
        } else {
            new Alert(Alert.AlertType.WARNING, "Nom de produit invalide.", ButtonType.CLOSE).showAndWait();
        }
        produitTF.clear();
    }
}