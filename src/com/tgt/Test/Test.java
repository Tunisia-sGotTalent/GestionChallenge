/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Test;

import com.tgt.Entite.Challenge;
import com.tgt.Service.ServiceChallenge;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author soraya
 */
public class Test {

    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        
       ServiceChallenge Sc=new ServiceChallenge();
       Challenge ch=new Challenge("hjhj","hjhjh","djhzjdhzjhd","jkjkjkj","jhjhjh",2);
       Challenge ch1=new Challenge("Dance monkey","14/12/2020","dance","skan","blabla",3);
       Challenge ch2=new Challenge("LOL","14/12/2020","dance","skan","blabla",3);
       
       try{
       Sc.ajouter_Challenge(ch1);
       //System.out.println(Sc.delete_Challenge(10));
       
       //Sc.search_Challenge_id(1);
       //Sc.update_Challenge(1,"nomChallenge1","dance","unee","ima","bla bla bla");
       Sc.search_challenge_nom("Dance monkey");
       
       //Sc.search_Challenge_id(8);
       List<Challenge> list = Sc.readAll();
       System.out.println(list);
       }catch(SQLException ex)
       {
           System.out.println(ex);
       }

        
        


    }

}
