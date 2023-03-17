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
 * @author sanga
 */
public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpass;
    
    Login(){
        
        setSize(700,400);//setting frame size
        setLocation(280,80);//center aligning the frame(by default it will be on the left side otherwise
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);//setting the colour of the frame to gray
        setLayout(null);
        
        JLabel heading=new JLabel("ADMIN LOGIN");
        heading.setBounds(110,20,150,30);
        heading.setFont(new Font("serif", Font.BOLD,15));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        JLabel username=new JLabel("Username");
        username.setBounds(40,70,100,30);
        username.setForeground(Color.WHITE);
        add(username);
        
        tfusername=new JTextField();
        tfusername.setBounds(150,70,150,30);
        add(tfusername);
        
        
        
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,120,100,30);
        pass.setForeground(Color.WHITE);
        add(pass);
        
        tfpass=new JTextField();
        tfpass.setBounds(150,120,150,30);
        add(tfpass);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(150,170,150,30);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("pics/icons.png"));
        Image i2=i1.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,50,150,150);
        add(image);    
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username=tfusername.getText();
            String pass=tfpass.getText();
            
            Conn c=new Conn();
            String query="select * from login where username='"+username+"'and pass='"+pass+"'";
            
            ResultSet rs=c.s.executeQuery(query);   
            if(rs.next()){
                setVisible(false);//current page will shut
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid credentials");
                setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}