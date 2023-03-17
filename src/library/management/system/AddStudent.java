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
 * @author sangy
 */
public class AddStudent extends JFrame implements ActionListener{
   JTextField tfname,tflname,tfid,tfbookiss,tfbookiss2,tfbookiss3;
   JComboBox tfstream;
   JButton addst,back;
   
    
    AddStudent(){
        
        setSize(900,650);
        setLocation(200,50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);//setting the colour of the frame to gray
        setLayout(null);
        
        JLabel heading=new JLabel("ADD STUDENT DETAILS");
        heading.setBounds(280,15,1200,60);
        heading.setFont(new Font("serif", Font.BOLD,27));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        JLabel labelname=new JLabel("FIRST NAME");
        labelname.setBounds(50,110,900,20);
        labelname.setFont(new Font("serif", Font.PLAIN,15));
        labelname.setForeground(Color.DARK_GRAY);
        add(labelname);
        
         tfname=new JTextField();
        tfname.setBounds(220,110,150,20);
        add(tfname);
        
        JLabel labellname=new JLabel("LAST NAME");
        labellname.setBounds(450,110,900,20);
        labellname.setFont(new Font("serif", Font.PLAIN,15));
        labellname.setForeground(Color.DARK_GRAY);
        add(labellname);
        
         tflname=new JTextField();
        tflname.setBounds(630,110,150,20);
        add(tflname);
        
        JLabel id=new JLabel("ID");
        id.setBounds(50,180,900,20);
        id.setFont(new Font("serif", Font.PLAIN,15));
        id.setForeground(Color.DARK_GRAY);
        add(id);
        
         tfid=new JTextField();
        tfid.setBounds(220,180,150,20);
        add(tfid);
        
        JLabel stream=new JLabel("STREAM");
        stream.setBounds(50,250,900,20);
        stream.setFont(new Font("serif", Font.PLAIN,15));
        stream.setForeground(Color.DARK_GRAY);
        add(stream);
        
        String courses[]={"ECE","CSE","IT","MCA"};        
         tfstream=new JComboBox(courses);
        tfstream.setBounds(220,250,150,20);
        add(tfstream);
        
        JLabel bookiss=new JLabel("ISSUED BOOK ID");
        bookiss.setBounds(50,320,900,20);
        bookiss.setFont(new Font("serif", Font.PLAIN,15));
        bookiss.setForeground(Color.DARK_GRAY);
        add(bookiss);
        
         tfbookiss=new JTextField();
        tfbookiss.setBounds(220,320,150,20);
        add(tfbookiss);
      
         tfbookiss2=new JTextField();
        tfbookiss2.setBounds(428,320,150,20);
        add(tfbookiss2);
        
        tfbookiss3=new JTextField();
        tfbookiss3.setBounds(628,320,150,20);
        add(tfbookiss3);
        
         addst=new JButton("ADD STUDENT");
        addst.setBounds(250,460,150,20);
        addst.addActionListener(this);
        add(addst);
        
         back=new JButton("BACK");
        back.setBounds(458,460,150,20);
        back.addActionListener(this);        
        add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addst){
            String fname=tfname.getText();
            String lname=tflname.getText();
            String id=tfid.getText();
            String course=(String)tfstream.getSelectedItem();
            String book1=tfbookiss.getText();
            String book2=tfbookiss2.getText();
            String book3=tfbookiss3.getText();
            
            
            try{
                Conn conn=new Conn();
                String query="insert into student values('"+fname+"','"+lname+"','"+id+"','"+course+"','"+book1+"','"+book2+"','"+book3+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
            new Home();
        }
            
}
    public static void main(String args[]){
        new AddStudent();
    }
    
}
