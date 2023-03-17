/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import java.sql.*;

/**
 *
 * @author sanga
 */
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///librarymanagementsystem","root","Sanga03@");
            s=c.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
