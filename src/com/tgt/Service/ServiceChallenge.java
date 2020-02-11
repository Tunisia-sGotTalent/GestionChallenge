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
public class ServiceChallenge implements IServiceChallenge<Challenge> {

    private Connection con;
    private Statement ste;
    private ResultSet rs;

    public ServiceChallenge() {

        con = Challenge_BD.getInstance().getConnection();

    }

    @Override
    public void ajouter_Challenge(Challenge c) throws SQLException {

        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tgt`.`challenge` (`id_challenge`, `nom_challenge`, `Type_challenge`, `date_challenge`, `image_challenge`, `description_challenge`, `nbrReact_challenge`) VALUES (NULL, '" + c.getNom_challenge() + "', '" + c.getType_challenge() + "', '" + c.getDate_challenge() + "','" + c.getImage_challenge() + "','" + c.getDescription_challenge() + "','" + c.getNbrReact_challenge() + "' );";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete_Challenge(int id) throws SQLException {

        try {
            ste = con.createStatement();
            String requeteDelete = " DELETE FROM `challenge` WHERE `challenge`.`id_challenge` = " + id;
            ste.executeUpdate(requeteDelete);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
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
            int nbReact_challenge = rs.getInt(7);

            Challenge c = new Challenge(id_challenge, nom_challenge, Type_challenge, date_challenge, image_challenge, description_challenge, nbReact_challenge);
            arr.add(c);
        }
        return arr;

    }

    @Override
    public void search_Challenge_id(int id) throws SQLException {
        try {

            ste = con.createStatement();
            String requeteSearch = "SELECT * FROM challenge WHERE id_challenge = " + id;
            rs = ste.executeQuery(requeteSearch);
            rs.last();
            int nbrRow = rs.getRow();

            if (nbrRow != 0) {
                System.out.println("Challenge trouvé");
            } else {
                System.out.println("Challenge non trouvé");
            }

        } catch (SQLException ex) {

            System.out.println(ex);
        }
    }

    @Override
    /* public void search_challenge_nom(String nom) throws SQLException {

        try {
            //String tal = "'"+talent+"'";
            ste = con.createStatement();
            String requeteSearch = "SELECT * FROM challenge WHERE nom_challenge=" +"'"+nom+"'";
            rs = ste.executeQuery(requeteSearch);
            rs.last();
            int nbrRow = rs.getRow();

            if (nbrRow != 1) {
                System.out.println("Challenge trouvé");
            } else {
                System.out.println("Challenge non trouvé");
            }

        } catch (SQLException ex) {

            System.out.println(ex);
        }

    }*/

    //RECHERCHE AVEC NOM POUR LES USERS
    public void search_challenge_nom(String nom) throws SQLException {
        {
            String nomC = "'" + nom + "'";
            String req = "select * from challenge where nom_challenge =" + nomC;
            try {
                ste = con.createStatement();
                rs = ste.executeQuery(req);

                while (rs.next()) {
                    System.out.println("le nom du challenge est: \t " + rs.getString("nom_challenge") + "\n"
                            + " le Type est : \t " + rs.getString("Type_challenge") + "\n"
                            + " la date est: \t " + rs.getString("date_challenge") + "\n"
                            + "l'image du challenge est: \t " + rs.getString("image_challenge") + "\n"
                            + " la description du challenge: \t " + rs.getString("description_challenge"));
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void update_Challenge(int idC, String nomC, String typeC, String dateC, String imageC, String descriptionC) throws SQLException {

        try {
            ste = con.createStatement();
            String requeteUpdate = "UPDATE challenge SET nom_challenge='" + nomC + "',Type_challenge='" + typeC + "',date_challenge='" + dateC + "',image_challenge='" + imageC + "',description_challenge='" + descriptionC + "' where challenge.id_challenge=" + idC;
            ste.executeUpdate(requeteUpdate);
            System.out.println("le challenge a bien été modifié");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
