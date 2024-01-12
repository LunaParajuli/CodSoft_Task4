
package task4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Rules extends JFrame implements ActionListener {
    
    String name;
    JButton Start,back;
    
    Rules(String name)
    {
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel welcome = new JLabel("Welcome "+ name+ " to the Game");
        welcome.setBounds(20,20,580,45);
        welcome.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        welcome.setForeground(Color.BLUE);
        add(welcome);
        
        JLabel rules = new JLabel("Rules:");
        rules.setBounds(20,65,120,45);
        rules.setFont(new Font("SERIF",Font.BOLD,40));
        rules.setForeground(Color.black);
        add(rules);
        
        JLabel rule = new JLabel();
        rule.setBounds(22,90,700,350);
        rule.setFont(new Font("Times New Roman",Font.PLAIN,16));
        rule.setText
                (
                  "<html>"+
                          "1. Participation in the quiz is free."+"<br><br>"+
                          "2. A complete game consists of 20 questions."+"<br><br>"+
                          "3. You will be provided 10 seconds for each question."+"<br><br>"+
                          "4. Use your own mind to know your knowledge."+"<br><br>"+
                          "5. Just be relaxed and Good Luck."+"<br><br>"+
                  "<html>"        
                );
        add(rule);
        
        Start = new JButton("Start");
        Start.setBounds(300,500,80,30);
        Start.setBackground(Color.WHITE);
        add(Start);
        Start.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(400,500,80,30);
        back.setBackground(Color.WHITE);
        add(back);
        back.addActionListener(this);
        
        
        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()== Start)
      {
        setVisible(false);
        new Login();
      }
    }
    
    
    public static void main(String args[])
    {
        new Rules("User");
    }
}
