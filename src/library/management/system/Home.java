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
public class Home extends JFrame implements ActionListener {
    
    JButton view,adds,update,remove;
    
    Home(){
        
        setLayout(null);
        
        setSize(900,650);
        setLocation(200,50);
        setVisible(true);
        
              
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("pics/lib.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,650);
        add(image);
        
        JLabel heading=new JLabel("LIBRARY MANAGEMENT SYSTEM");
        heading.setBounds(355,10,1200,60);
        heading.setFont(new Font("serif", Font.BOLD,30));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
         adds=new JButton("ADD STUDENT");
        adds.setBounds(365,100,200,40);
        adds.setFont(new Font("serif", Font.BOLD,15));
        adds.addActionListener(this);
        image.add(adds);
        
         view=new JButton("VIEW RECORD");
        view.setBounds(650,100,200,40);
        view.setFont(new Font("serif", Font.BOLD,15));
        view.addActionListener(this);
        image.add(view);
        
         update=new JButton("UPDATE RECORD");
        update.setBounds(365,170,200,40);
        update.setFont(new Font("serif", Font.BOLD,15));
        update.addActionListener(this);
        image.add(update);
        
         remove=new JButton("REMOVE STUDENT");
        remove.setBounds(650,170,200,40);
        remove.setFont(new Font("serif", Font.BOLD,15));
        remove.addActionListener(this);
        image.add(remove);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==adds){
            setVisible(false);
            new AddStudent();
            
        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewRecord();
            
        }else if(ae.getSource()==update){
            setVisible(false);
            new ViewRecord();
            
        }else{
            setVisible(false);
            new Remove();
            
        }
        
    }
    
    
    public static void main(String args[]){
        new Home();
    }
    
}
