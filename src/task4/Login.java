
package task4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{
    
    JTextField tfname;
    JButton enter,exit;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(10,10,600,300);
        add(image);
        
        JLabel heading = new JLabel("The QuizGame");
        heading.setBounds(750,60,300,45);
        heading.setFont(new Font("Viner Hand",Font.BOLD,40));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(810,150,300,20);
        name.setFont(new Font("SERIF",Font.BOLD,18));
        name.setForeground(Color.black);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(735,200,300,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);
        
        enter = new JButton("Enter");
        enter.setBounds(735,270,120,25);
        enter.setBackground(Color.GREEN);
        add(enter);
        enter.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.setBounds(915,270,120,25);
        exit.setBackground(Color.RED);
        add(exit);
        exit.addActionListener(this);
        
        setSize(1200,500);
        setLocation(200,150);
        
        setVisible(true);
        
    }    
        public void actionPerformed(ActionEvent e){
         if(e.getSource()== enter)
         {
           String name = tfname.getText();
           setVisible(false);
           new Rules(name);  
         }
         else if(e.getSource()==exit)
         {
             setVisible(false);
         }
        }
    
    
    
    public static void main(String args[])
    {
        new Login();
    }   
}
