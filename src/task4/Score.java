
package task4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Score extends JFrame implements ActionListener {
    
    Score(String name , int scores)
    {
     setBounds(600,150,750,550); 
     getContentPane().setBackground(Color.lightGray);
     setLayout(null);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
     Image i2 = i1.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,200,300,250);
     add(image);
     
     JLabel top = new JLabel("Thank You "+name+" for playing QuizGame.");
     top.setBounds(45,30,700,35);
     top.setFont(new Font("Viner Hand",Font.PLAIN,30));
     top.setForeground(Color.BLUE);
     add(top);
     
     JLabel score = new JLabel("Your score is "+scores);
     score.setBounds(350,200,300,30);
     score.setFont(new Font("Viner Hand",Font.PLAIN,25));
     score.setForeground(Color.RED);
     add(score);
     
     JButton play = new JButton("Play Again!!");
     play.setBounds(400,270,190,35);
     play.setFont(new Font("TIMES New Roman",Font.PLAIN,20));
     play.setForeground(Color.BLUE);
     play.addActionListener(this);
     add(play);
     
     
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
       setVisible(false);
       new Login();
    }
    
    public static void main(String args[])
    {
        new Score("User",0);
    }
}
