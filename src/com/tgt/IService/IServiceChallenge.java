/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.IService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author soraya
 * @param <C>
 */
public interface IServiceChallenge<C> {

    void ajouter_Challenge(C c) throws SQLException;

    boolean delete_Challenge(int id) throws SQLException;

    void search_Challenge_id(int id) throws SQLException;

    void search_challenge_nom(String nom) throws SQLException;

    void update_Challenge(C c) throws SQLException;

    List<C> readAll() throws SQLException;

}
