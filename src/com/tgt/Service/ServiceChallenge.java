/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Service;

import com.mysql.jdbc.PreparedStatement;
import com.tgt.Entite.Challenge;
import com.tgt.IService.IServiceChallenge;
import com.tgt.Utils.Challenge_BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author soraya
 */
public class ServiceChallenge implements IServiceChallenge<Challenge> {

    private final Connection con;
    private Statement ste;
    private ResultSet rs;

    public ServiceChallenge() {

        con = Challenge_BD.getInstance().getConnection();

    }

    @Override
    public void ajouter_Challenge(Challenge c) throws SQLException {

        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tgt`.`challenge` (`id_challenge`, `nom_challenge`, `Type_challenge`, `date_challenge`, `image_challenge`, `description_challenge`) VALUES (NULL, '" + c.getNom_challenge() + "', '" + c.getType_challenge() + "', '" + c.getDate_challenge() + "','" + c.getImage_challenge() + "','" + c.getDescription_challenge() + "' );";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public void search_challenge_nom(String nom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_Challenge(Challenge c, int id) throws SQLException {

        try {
            if ((c.getNom_challenge() != "") && (c.getType_challenge() != "") && (c.getDate_challenge() != "") && (c.getImage_challenge() != "") && (c.getDescription_challenge() != "")) {
                String query = "update challenge set nom_challenge='" + c.getNom_challenge() + "',Type_challenge='" +c.getType_challenge()+ "',date_challenge='" + c.getDate_challenge() + "',image_challenge='" + c.getImage_challenge() + "',description_Challenge='" + c.getDescription_challenge() + "' where challenge.id_challenge=" + c.getId_challenge();

                ste = con.createStatement();
                ste.executeUpdate(query);

                System.out.println("bien modifiée");

            } else {
                System.out.println("tu dois inserer tous les elements");
            }
        } catch (SQLException ex) {

        }
    }


    public ObservableList<Challenge> readAll(Challenge c) throws SQLException {

        ObservableList<Challenge> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from challenge");
        while (rs.next()) {
            int id_challenge = rs.getInt(1);
            String nom_challenge = rs.getString(2);
            String Type_challenge = rs.getString(3);
            String date_challenge = rs.getString(4);
            String image_challenge = rs.getString(5);
            String description_challenge = rs.getString(6);

            arr.add(new Challenge(id_challenge, nom_challenge, Type_challenge, date_challenge, image_challenge, description_challenge));
            
        }
        return arr;
    }
    
 

   

    @Override
    public void delete_Challenge(int id) throws SQLException {
        try {
            ste = con.createStatement();
            String requeteDelete = " DELETE FROM `challenge` WHERE `challenge`.`id_challenge` = " + id;
            ste.executeUpdate(requeteDelete);
            System.out.println("Le Challenge a bien été supprimé");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Challenge search_Challenge_id(int id) throws SQLException {

        Challenge c = new Challenge();
        try {
            ste = con.createStatement();
            String requeteSearch = "SELECT * FROM challenge WHERE id_challenge = " + id;
            rs = ste.executeQuery(requeteSearch);
            if (rs.next()) {
                c.setId_challenge(rs.getInt(1));
                c.setNom_challenge(rs.getString(2));
                c.setType_challenge(rs.getString(3));
                c.setDate_challenge(rs.getString(4));
                c.setImage_challenge(rs.getString(4));
                c.setDescription_challenge(rs.getString(5));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }




}
