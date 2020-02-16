/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Gui;

import com.tgt.Entite.Challenge;
import com.tgt.Service.ServiceChallenge;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author soraya
 */
public class GestionChallengeFXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ComboBox<String> comboType;
    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TextArea tfDescription;
    @FXML

    private Button buttonAdd;

    private ObservableList<String> list = FXCollections.observableArrayList("Chant", "Dance", "théatre", "Peinture");
    @FXML
    private Button vider;
    @FXML
    private TextField tfimage;
    @FXML
    private TableView<Challenge> table;
    @FXML
    private TableColumn<Challenge, Integer> col_id_chal;
    @FXML
    private TableColumn<Challenge, String> col_nom_chal;
    @FXML
    private TableColumn<Challenge, String> col_type_chal;
    @FXML
    private TableColumn<Challenge, String> col_date_chal;

    @FXML
    private TableColumn<Challenge, String> col_img_chal;

    public ObservableList<Challenge> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Challenge, String> col_description_chal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        comboType.setItems(list);
    }

    @FXML
    private void AjouterChalAction(ActionEvent event) {

        String nomChal = tfnom.getText();
        String descriptionChal = tfDescription.getText();
        String value = dpDate.getValue().toString();

        String imgC = tfimage.getText();

        Challenge c = new Challenge();
        c.setNom_challenge(nomChal);
        c.setDescription_challenge(descriptionChal);
        c.setDate_challenge(value);
        c.setDate_challenge(dpDate.getEditor().getText());
        c.setType_challenge(comboType.getValue());
        c.setImage_challenge(imgC);

        ServiceChallenge sChal = new ServiceChallenge();

        try {
            sChal.ajouter_Challenge(c);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void viderTableChal(ActionEvent event) {

        tfnom.clear();
        tfDescription.clear();
        dpDate.setValue(null);
        comboType.setValue(null);
        tfimage.clear();
    }

    @FXML
    private void AfficherChal(ActionEvent event) {

        ServiceChallenge sc = new ServiceChallenge();
        try {
            sc.readAll();
        } catch (SQLException e) {
            System.out.println(e);
        }

        col_id_chal.setCellValueFactory(new PropertyValueFactory<>("id_challenge"));
        col_nom_chal.setCellValueFactory(new PropertyValueFactory<>("nom_challenge"));
        col_type_chal.setCellValueFactory(new PropertyValueFactory<>("Type_challenge"));
        col_date_chal.setCellValueFactory(new PropertyValueFactory<>("date_challenge"));
        col_img_chal.setCellValueFactory(new PropertyValueFactory<>("image_challenge"));
        col_description_chal.setCellValueFactory(new PropertyValueFactory<>("description_challenge"));

        table.setItems(data);

    }

    @FXML
    private void ModifierChal(ActionEvent event) {
    }

    @FXML
    private void supprimerChal(ActionEvent event) {
    }

    @FXML
    private void chercherChal(ActionEvent event) {
    }

}
