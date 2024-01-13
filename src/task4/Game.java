
package task4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame implements ActionListener
  {
    
    String questions[][] = new String[10][4];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
     
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3;
    ButtonGroup group;
    JButton next,submit;
    
    public static int timer = 10;
    public static int ans_given = 0;
    public static int count = 0;
    public static int scores = 0;
    
    String name;
    
    Game(String name)
    {
     this.name = name;  
     setBounds(50,0,1440,850); 
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
     JLabel image = new JLabel(i1);
     image.setBounds(50,0,1000,392);
     add(image);
     
      qno = new JLabel();
     qno.setBounds(100, 450, 50, 30);
     qno.setFont(new Font("Times New Roman",Font.PLAIN,24));
     add(qno);
     
      question = new JLabel();
     question.setBounds(150, 450, 900, 30);
     question.setFont(new Font("Times New Roman",Font.PLAIN,24));
     add(question);
     
     questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        

     questions[1][0] = "What planet is closest to the sun?";
        questions[1][1] = "Earth";
        questions[1][2] = "Mercury";
        questions[1][3] = "Venus";
       

     questions[2][0] = "How many hearts does an octopus have?";
        questions[2][1] = "1";
        questions[2][2] = "2";
        questions[2][3] = "3";
        

     questions[3][0] = "What is the most expensive spice in the world by weight?";
        questions[3][1] = "Vanilla";
        questions[3][2] = "Saffron";
        questions[3][3] = "Black Pepper";
        

     questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Heap Memory";
        

     questions[5][0] = "What country drinks the most coffee?";
        questions[5][1] = "USA";
        questions[5][2] = "Brazil";
        questions[5][3] = "Finland";
        

     questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
      

     questions[7][0] = "What is the most consumed fruit in the world?";
        questions[7][1] = "Apple";
        questions[7][2] = "Banana";
        questions[7][3] = "StrawBerry";
       

     questions[8][0] = "What color are Mickey Mouse's shoes?";
        questions[8][1] = "Red";
        questions[8][2] = "Yellow";
        questions[8][3] = "Blue";
        

     questions[9][0] = "Who was the first Disney princess?";
        questions[9][1] = "Snow White";
        questions[9][2] = "Cinderella";
        questions[9][3] = "Rupanzel";
        
        
        answers[0][1] = "JDB";
        answers[1][1] = "Mercury";
        answers[2][1] = "3";
        answers[3][1] = "Saffron";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Finland";
        answers[6][1] = "import";
        answers[7][1] = "Banana";
        answers[8][1] = "Yellow";
        answers[9][1] = "Snow White";
        
    
     opt1 = new JRadioButton();
     opt1.setBounds(170,500,700,30);
     opt1.setBackground(Color.WHITE);
     add(opt1);
   
     opt2 = new JRadioButton();
     opt2.setBounds(170,540,700,30);
     opt2.setBackground(Color.WHITE);
     add(opt2);
   
     opt3 = new JRadioButton();
     opt3.setBounds(170,580,700,30);
     opt3.setBackground(Color.WHITE);
     add(opt3);
   
      group = new ButtonGroup();
     group.add(opt1);
     group.add(opt2);
     group.add(opt3);
         
      next = new JButton("Next");
     next.setBounds(1100,550,200,40);
     next.setFont(new Font("Tahoma",Font.PLAIN,22));
     next.setBackground(new Color(30,144,255));
     next.setForeground(Color.WHITE);
     next.addActionListener(this);
     add(next);
     
      submit = new JButton("Submit");
     submit.setBounds(1100,630,200,40);
     submit.setFont(new Font("Tahoma",Font.PLAIN,22));
     submit.setBackground(new Color(30,144,255));
     submit.setForeground(Color.WHITE);
     submit.setEnabled(false);
     submit.addActionListener(this);
     add(submit);
     
     start(count);
        
     setVisible(true);
    } 
    
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==next)
       {
           repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
           
           ans_given = 1;
           if(group.getSelection()==null)
            {
            useranswers[count][0] = ""; 
            }
            else
            {
               useranswers[count][0] = group.getSelection().getActionCommand();             
            }
           if(count ==8)
           {
             next.setEnabled(false);
             submit.setEnabled(true);
           }
           
           count++;
           start(count);
       }
       else
       {
           ans_given = 1;
          if(group.getSelection()==null)
            {
            useranswers[count][0] = ""; 
            }
            else
            {
               useranswers[count][0] = group.getSelection().getActionCommand();             
            } 
          for(int i=0;i<useranswers.length;i++)
          {
              if(useranswers[i][0].equals(answers[i][1]))
              {
                  scores += 10;
              }else{
                  scores += 0;
              }
          }
          setVisible(false);
          new Score(name,scores);
       }
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        String time = "Time left: "+timer + " seconds"; //10
        g.setColor(Color.RED);
        g.setFont(new Font("Serif",Font.BOLD,25));
        
        if(timer>0)
        {
            g.drawString(time,1100,500);
            
        }
        else
        {
          g.drawString("Times up!!", 1100,500);
        }
        timer--; //9
        
        try
        {
         Thread.sleep(1000); 
         repaint();
        }
        catch(Exception e)
        {
           e.printStackTrace(); 
        }
        
        if(ans_given ==1)
        {
            ans_given = 0;
            timer = 10;
        }
        else if(timer<0)
        {
            timer = 10;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            
            if(count==8)
            {
               next.setEnabled(false);
               submit.setEnabled(true);
            }
           
            if(count==9)      //submit button
            {
             if(group.getSelection()==null){
                useranswers[count][0] = ""; 
            }
            else
            {
               useranswers[count][0] = group.getSelection().getActionCommand();             
            } 
             for(int i=0;i<useranswers.length;i++)
             {
                 if(useranswers[i][0].equals(answers[i][1]))
                 {
                   scores+=10;  
                 }else{
                     scores+=0;
                 }
             }
             setVisible(false);
             new Score(name, scores);
            } 
            else{           //next button   
            if(group.getSelection()==null)
            {
            useranswers[count][0] = ""; 
            }
            else
            {
               useranswers[count][0] = group.getSelection().getActionCommand();             
            }
            count++; //0 //1
            start(count);
            }
        }
    }
    
    public void start(int count)
    {
      qno.setText(""+(count+1)+". ");
      question.setText(questions[count][0]);
      
      opt1.setText(questions[count][1]);
      opt1.setActionCommand(questions[count][1]);
      
      opt2.setText(questions[count][2]);
      opt2.setActionCommand(questions[count][1]);
      
      opt3.setText(questions[count][3]);
      opt3.setActionCommand(questions[count][1]);
      
      group.clearSelection();
      
    }
    
    public static void main(String args[])
    {
        new Game("User");
    }
}
