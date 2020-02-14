/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Gui;

import com.tgt.Entite.Challenge;
import com.tgt.Service.ServiceChallenge;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;

    List<Challenge> arr = new ArrayList<>();
    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker tfDate;
    @FXML
    private TextArea tfDescription;
    @FXML
    private Button Annuler;
    @FXML
    private TextField tfImage;
    @FXML
    private TableView<Challenge> table_Challenge;
    @FXML
    private TableColumn<Challenge, Integer> Col_Id_Chal;
    @FXML
    private TableColumn<Challenge, String> Col_Nom_Chal;
    @FXML
    private TableColumn<Challenge, String> Col_Date_Chal;
  
    @FXML
    private TableColumn<Challenge, String> col_Type_Chal;
    
//c'est quoi ObservableList ?
    ObservableList<Challenge> obList=FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        label.setText("Challenge ajouté");

        Challenge c = new Challenge();
        c.setNom_challenge(tfnom.getText());
        c.setImage_challenge(tfImage.getText());
        String value = tfDate.getValue().toString();
        c.setDate_challenge(value);
        c.setDate_challenge(tfDate.getEditor().getText());
        c.setDescription_challenge(tfDescription.getText());
        ServiceChallenge sChal = new ServiceChallenge();

        try {
            sChal.ajouter_Challenge(c);
            List<Challenge> listChallenge = sChal.readAll();
            System.out.println(listChallenge);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
       ServiceChallenge serChal=new ServiceChallenge();
          

           Col_Id_Chal.setCellValueFactory(new PropertyValueFactory<>("id_challenge"));
           Col_Nom_Chal.setCellValueFactory(new PropertyValueFactory<>("nom_challenge"));
           Col_Date_Chal.setCellValueFactory(new PropertyValueFactory<>("date_challenge"));
           col_Type_Chal.setCellValueFactory(new PropertyValueFactory<>("type_challenge"));
      
         try {
            arr = serChal.readAll();
            table_Challenge.setItems(obList);
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void handleButtonStop(ActionEvent event) {

    }

}
