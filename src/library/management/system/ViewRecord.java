/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sangy
 */
public class ViewRecord extends JFrame implements ActionListener{
    JTable table;
    Choice studid;
    JButton searchb, update, back;
    ViewRecord(){
         setSize(900,650);
        setLocation(200,50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);//setting the colour of the frame to gray
        setLayout(null);
        
        JLabel search=new JLabel("Search by Student id");
        search.setBounds(50,15,150,20);
        add(search);
        
        studid=new Choice();
        studid.setBounds(150,15,150,20);
        add(studid);
        
        table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from student");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                studid.add(rs.getString("id"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                studid.add(rs.getString("id"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jp=new JScrollPane(table);//adding scroll bar
        jp.setBounds(50,100,800,600);
        add(jp);
        
        searchb=new JButton("SEARCH");
        searchb.setBounds(60,60,120,20);
        searchb.addActionListener(this);
        add(searchb);
        
        update=new JButton("UPDATE");
        update.setBounds(380,60,120,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("BACK");
        back.setBounds(720,60,120,20);
        back.addActionListener(this);
        add(back);
        
        
                
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==searchb){
            String query="select*from student where id='"+studid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
           setVisible(false);
           new UpdateRec(studid.getSelectedItem());
            
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]){
        new ViewRecord();
    }
}
