/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.tgt.Entite.Challenge;
import com.tgt.Service.ServiceChallenge;
import java.sql.SQLException;

/**
 *
 * @author soraya
 */
public class test {
    public static void main(String[] args) throws SQLException {
        Challenge c1=new Challenge("lol","lol","lol","lol","lol");
        ServiceChallenge sc=new ServiceChallenge();
        sc.ajouter_Challenge(c1);
    }
    
}
