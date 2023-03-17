/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author sanga
 */
public class Remove extends JFrame implements ActionListener{
    Choice cid;
    JLabel lfname,llname,lid,lstream,lbookiss,lbookiss2,lbookiss3;
    JButton Delete,Back;
    
    Remove(){
         setSize(515,580);
        setLocation(380,90);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);//setting the colour of the frame to gray
        setLayout(null);
        
        lid=new JLabel("Student Id");
        lid.setBounds(50,50,100,20);
        add(lid);
        
        cid=new Choice();
        cid.setBounds(230,50,100,30);
        add(cid);
        
        try{
            Conn c=new Conn();
            String query="select*from student";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cid.add(rs.getString("id"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname=new JLabel("FIRST NAME");
        labelname.setBounds(50,100,900,20);
        labelname.setFont(new Font("serif", Font.PLAIN,15));
        labelname.setForeground(Color.DARK_GRAY);
        add(labelname);
        
        lfname=new JLabel();//making fields uneditable
        lfname.setBounds(230,100,150,20);
        add(lfname);
        
        JLabel labellname=new JLabel("LAST NAME");
        labellname.setBounds(50,150,900,20);
        labellname.setFont(new Font("serif", Font.PLAIN,15));
        labellname.setForeground(Color.DARK_GRAY);
        add(labellname);
        
        llname=new JLabel();
        llname.setBounds(230,150,150,20);
        add(llname);
        
        JLabel stream=new JLabel("STREAM");
        stream.setBounds(50,200,900,20);
        stream.setFont(new Font("serif", Font.PLAIN,15));
        stream.setForeground(Color.DARK_GRAY);
        add(stream);
        
        lstream=new JLabel();        
        lstream.setBounds(230,200,150,20);
        add(lstream);
        
        JLabel bookiss=new JLabel("ISSUED BOOK ID");
        bookiss.setBounds(50,250,900,20);
        bookiss.setFont(new Font("serif", Font.PLAIN,15));
        bookiss.setForeground(Color.DARK_GRAY);
        add(bookiss);
        
        lbookiss=new JLabel();
        lbookiss.setBounds(230,250,150,20);
        add(lbookiss);
      
        lbookiss2=new JLabel();
        lbookiss2.setBounds(330,250,150,20);
        add(lbookiss2);
        
        lbookiss3=new JLabel();
        lbookiss3.setBounds(430,250,150,20);
        add(lbookiss3);
        
        try{
            Conn c=new Conn();
            String query="select*from student where id='"+cid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lfname.setText(rs.getString("fname"));
                llname.setText(rs.getString("lname"));
                lstream.setText(rs.getString("course"));
                lbookiss.setText(rs.getString("book1"));
                lbookiss2.setText(rs.getString("book2"));
                lbookiss3.setText(rs.getString("book3"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cid.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            try{
            Conn c=new Conn();
            String query="select*from student where id='"+cid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lfname.setText(rs.getString("fname"));
                llname.setText(rs.getString("lname"));
                lstream.setText(rs.getString("course"));
                lbookiss.setText(rs.getString("book1"));
                lbookiss2.setText(rs.getString("book2"));
                lbookiss3.setText(rs.getString("book3"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }
    });
        
        Delete=new JButton("DELETE RECORD");
        Delete.setBounds(150,350,200,30);
        Delete.setBackground(Color.RED);
        Delete.setForeground(Color.BLACK);
        Delete.addActionListener(this);
        add(Delete);
        
        Back=new JButton("BACK");
        Back.setBounds(150,420,200,30);
        //Back.setBackground(Color.RED);
       // Back.setForeground(Color.BLACK);
        Back.addActionListener(this);
        add(Back);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Delete){
            try{
                Conn c=new Conn();
                String query="delete from student where id='"+cid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student record Deleted Successfully");
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
    new Remove();
}
    
}
