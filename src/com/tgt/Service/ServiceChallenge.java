/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Service;

import com.tgt.Entite.Challenge;
import com.tgt.IService.IServiceChallenge;
import com.tgt.Utils.Challenge_BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author soraya
 */
public class ServiceChallenge implements IServiceChallenge<Challenge>{

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
    public boolean delete_Challenge(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search_Challenge_id(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search_challenge_nom(String nom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_Challenge(Challenge c) throws SQLException {
        
         ste = con.createStatement();
         String requete= "UPDATE challenge SET nom_challenge=? , Type_challenge=? , date_challenge=? , image_challenge=? , descritption_challenge=? WHERE id_challenge=?";
         ste.executeUpdate(requete);
        
        
        
         
    }

    @Override
    public List<Challenge> readAll() throws SQLException {
        
        List<Challenge> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from challenge");
        while (rs.next()) {
            int id_challenge = rs.getInt(1);
            String nom_challenge = rs.getString(2);
            String Type_challenge = rs.getString(3);
            String date_challenge = rs.getString(4);
            String image_challenge = rs.getString(5);
            String description_challenge = rs.getString(6);
            

            Challenge c = new Challenge(id_challenge, nom_challenge, Type_challenge, date_challenge, image_challenge, description_challenge);
            arr.add(c);
        }
        return arr;
    }


}
