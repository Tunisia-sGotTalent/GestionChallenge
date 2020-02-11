/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Entite;

/**
 *
 * @author soraya
 */
public class Challenge {

    int id_challenge;
    String nom_challenge;
    String type_challenge;
    String date_challenge;
    String image_challenge;
    String description_challenge;
    int nbrReact_challenge;

    public Challenge(String nom_challenge, String type_challenge, String date_challenge, String image_challenge, String description_challenge, int nbrReact_challenge) {
        this.nom_challenge = nom_challenge;
        this.type_challenge = type_challenge;
        this.date_challenge = date_challenge;
        this.image_challenge = image_challenge;
        this.description_challenge = description_challenge;
        this.nbrReact_challenge = nbrReact_challenge;
    }

    public Challenge(int id_challenge, String nom_challenge, String type_challenge, String date_challenge, String image_challenge, String description_challenge, int nbrReact_challenge) {
        this.id_challenge = id_challenge;
        this.nom_challenge = nom_challenge;
        this.type_challenge = type_challenge;
        this.date_challenge = date_challenge;
        this.image_challenge = image_challenge;
        this.description_challenge = description_challenge;
        this.nbrReact_challenge = nbrReact_challenge;
    }

    public int getId_challenge() {
        return id_challenge;
    }

    public String getNom_challenge() {
        return nom_challenge;
    }

    public String getType_challenge() {
        return type_challenge;
    }

    public String getDate_challenge() {
        return date_challenge;
    }

    public String getImage_challenge() {
        return image_challenge;
    }

    public String getDescription_challenge() {
        return description_challenge;
    }

    public int getNbrReact_challenge() {
        return nbrReact_challenge;
    }

    public void setId_challenge(int id_challenge) {
        this.id_challenge = id_challenge;
    }

    public void setNom_challenge(String nom_challenge) {
        this.nom_challenge = nom_challenge;
    }

    public void setType_challenge(String type_challenge) {
        this.type_challenge = type_challenge;
    }

    public void setDate_challenge(String date_challenge) {
        this.date_challenge = date_challenge;
    }

    public void setImage_challenge(String image_challenge) {
        this.image_challenge = image_challenge;
    }

    public void setDescription_challenge(String description_challenge) {
        this.description_challenge = description_challenge;
    }

    public void setNbrReact_challenge(int nbrReact_challenge) {
        this.nbrReact_challenge = nbrReact_challenge;
    }

    @Override
    public String toString() {
        return "Challenge{" + "id_challenge=" + id_challenge + ", nom_challenge=" + nom_challenge + ", type_challenge=" + type_challenge + ", date_challenge=" + date_challenge + ", image_challenge=" + image_challenge + ", description_challenge=" + description_challenge + ", nbrReact_challenge=" + nbrReact_challenge + '}';
    }

}
