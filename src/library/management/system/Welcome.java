/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author sanga
 */
public class Welcome extends JFrame implements ActionListener {
    
    Welcome(){
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        
        
        JLabel heading=new JLabel("LIBRARY MANAGEMENT SYSTEM");
        heading.setBounds(140,30,1200,60);
        heading.setFont(new Font("serif", Font.BOLD,35));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("pics/libr.jpeg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(17,100,850,500);
        add(image);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(391,500,100,50);
        //login.setBackground(Color.BLACK);
        //login.setForeground(Color.WHITE);
        login.setFont(new Font("serif", Font.BOLD,15));
        login.addActionListener(this);
        add(login);
        
        
        setSize(900,650);
        setLocation(200,50);
        setVisible(true);
        
        while(true){
            heading.setVisible(true);
            try{
                Thread.sleep(1500);
            }catch(Exception e){
                
            }
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            
        }
        
       
    }
    public void actionPerformed(ActionEvent ae){//overriding the abstract method
        setVisible(false);//current frame will close
        new Login();
    }
    
    public static void main(String args[]){
        new Welcome();
    }
    
}
