/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author sangy
 */
public class UpdateRec extends JFrame implements ActionListener{
   JTextField tfstream,tfbookiss,tfbookiss2,tfbookiss3;
   //JComboBox tfstream;
   JButton addst,back;
   String id;
   JLabel lfname,llname,lid;
   
    
    UpdateRec(String id){
        this.id = id;
        
        setSize(900,650);
        setLocation(200,50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);//setting the colour of the frame to gray
        setLayout(null);
        
        JLabel heading=new JLabel("UPDATE STUDENT DETAILS");
        heading.setBounds(280,15,1200,60);
        heading.setFont(new Font("serif", Font.BOLD,27));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        JLabel labelname=new JLabel("FIRST NAME");
        labelname.setBounds(50,110,900,20);
        labelname.setFont(new Font("serif", Font.PLAIN,15));
        labelname.setForeground(Color.DARK_GRAY);
        add(labelname);
        
        lfname=new JLabel();//making fields uneditable
        lfname.setBounds(220,110,150,20);
        add(lfname);
        
        JLabel labellname=new JLabel("LAST NAME");
        labellname.setBounds(450,110,900,20);
        labellname.setFont(new Font("serif", Font.PLAIN,15));
        labellname.setForeground(Color.DARK_GRAY);
        add(labellname);
        
        llname=new JLabel();
        llname.setBounds(630,110,150,20);
        add(llname);
        
        JLabel sid=new JLabel("ID");
        sid.setBounds(50,180,900,20);
        sid.setFont(new Font("serif", Font.PLAIN,15));
        sid.setForeground(Color.DARK_GRAY);
        add(sid);
        
        lid=new JLabel();
        lid.setBounds(220,180,150,20);
        add(lid);
        
        JLabel stream=new JLabel("STREAM");
        stream.setBounds(50,250,900,20);
        stream.setFont(new Font("serif", Font.PLAIN,15));
        stream.setForeground(Color.DARK_GRAY);
        add(stream);
        
        tfstream=new JTextField();        
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
        
        try{
            Conn c=new Conn();
            String query="select*from student where id='"+id+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lfname.setText(rs.getString("fname"));
                llname.setText(rs.getString("lname"));
                lid.setText(rs.getString("id"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        addst=new JButton("UPDATE DETAILS");
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
           
           
            String course=tfstream.getText();
            String book1=tfbookiss.getText();
            String book2=tfbookiss2.getText();
            String book3=tfbookiss3.getText();
            
            
            try{
                Conn conn=new Conn();
                String query="update student set course='"+course+"',book1='"+book1+"',book2='"+book2+"',book3='"+book3+"'where id='"+id+"'";
                conn.s.executeUpdate(query);
                //String sql = "UPDATE book SET bookId = (SELECT CONCAT_WS(',', book1, book2, book3) FROM student WHERE studentId = ?) WHERE bookId IS NULL";
                //conn.s.executeUpdate(sql);

                //String query2="insert into book'"+bookId+'" select('"+book1+"','"+book2+"','"+book3+"' from student)";
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
        new UpdateRec("");
    }
    
}
