/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Gui;

import com.tgt.Entite.Challenge;
import com.tgt.Service.ServiceChallenge;
import com.tgt.Utils.Challenge_BD;
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

    public ObservableList<Challenge> arr = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Challenge, String> col_description_chal;
    @FXML
    private TextField tfsearch;

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
        Challenge c = new Challenge();
        col_id_chal.setCellValueFactory(new PropertyValueFactory<>("id_challenge"));
        col_nom_chal.setCellValueFactory(new PropertyValueFactory<>("nom_challenge"));
        col_type_chal.setCellValueFactory(new PropertyValueFactory<>("Type_challenge"));
        col_date_chal.setCellValueFactory(new PropertyValueFactory<>("date_challenge"));
        col_img_chal.setCellValueFactory(new PropertyValueFactory<>("image_challenge"));
        col_description_chal.setCellValueFactory(new PropertyValueFactory<>("description_challenge"));

        try {
            ServiceChallenge sc = new ServiceChallenge();
            arr = sc.readAll(c);
        } catch (SQLException e) {
            System.out.println(e);
        }

        table.setItems((ObservableList<Challenge>) arr);

    }

    @FXML
    private void chercherChal(ActionEvent event) {

        String Chalid = tfsearch.getText();
        int id = Integer.parseInt(Chalid);

//        tfnom.setText(c.getNom_challenge());
//        dpDate.setText(c.getDate_challenge());
//        comboType.setText(c.getType_challenge());
    }

    @FXML
    private void ModifierChal(ActionEvent event) {

        Challenge c = new Challenge();
        ServiceChallenge sc = new ServiceChallenge();

        col_id_chal.setCellValueFactory(new PropertyValueFactory<>("id_challenge"));
        col_nom_chal.setCellValueFactory(new PropertyValueFactory<>("nom_challenge"));
        col_type_chal.setCellValueFactory(new PropertyValueFactory<>("Type_challenge"));
        col_date_chal.setCellValueFactory(new PropertyValueFactory<>("date_challenge"));
        col_img_chal.setCellValueFactory(new PropertyValueFactory<>("image_challenge"));
        col_description_chal.setCellValueFactory(new PropertyValueFactory<>("description_challenge"));

        try {

            arr = sc.readAll(c);
            table.setItems((ObservableList<Challenge>) arr);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        c.setNom_challenge(tfnom.getText());
        c.setDate_challenge(dpDate.getEditor().getText());
        c.setType_challenge(comboType.getValue());
        c.setImage_challenge(tfimage.getText());
        c.setDescription_challenge(tfDescription.getText());
        c.setId_challenge(Integer.parseInt(tfsearch.getText()));

        try {
//         
            sc.update_Challenge(c, Integer.parseInt(tfsearch.getText()));
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void supprimerChal(ActionEvent event) {

        Challenge c = new Challenge();
        ServiceChallenge sc = new ServiceChallenge();
        col_id_chal.setCellValueFactory(new PropertyValueFactory<>("id_challenge"));
        col_nom_chal.setCellValueFactory(new PropertyValueFactory<>("nom_challenge"));
        col_type_chal.setCellValueFactory(new PropertyValueFactory<>("Type_challenge"));
        col_date_chal.setCellValueFactory(new PropertyValueFactory<>("date_challenge"));
        col_img_chal.setCellValueFactory(new PropertyValueFactory<>("image_challenge"));
        col_description_chal.setCellValueFactory(new PropertyValueFactory<>("description_challenge"));

        try {
            arr = sc.readAll(c);
            table.setItems((ObservableList<Challenge>) arr);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        c.setId_challenge(Integer.parseInt(tfsearch.getText()));

        try {
            sc.delete_Challenge(Integer.parseInt(tfsearch.getText()));
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
