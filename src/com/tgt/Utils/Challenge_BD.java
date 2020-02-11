/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author soraya
 */
public class Challenge_BD {

    String url = "jdbc:mysql://localhost:3306/tgt";
    String login = "root";
    String pwd = "";
    public static Challenge_BD challengeDb;
    public Connection con;

    private Challenge_BD() {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static Challenge_BD getInstance() {
        if (challengeDb == null) {
            challengeDb = new Challenge_BD();
        }
        return challengeDb;
    }

}
