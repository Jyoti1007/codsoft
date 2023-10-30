package numberguessinggame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class NumberGuessingGame extends JFrame implements ActionListener{
  private JLabel numLabel ,msgLabel,counter,imgLabel,msg2Label,chance,roundLabel,round,scoreLabel,scores;
  private JTextField num;
  private JButton guessBtn,guessAgainBtn,playAgainBtn;
  private int number=(int)(Math.random()*100);
  private int count=5,rounds=1,score=0, user_num;
  
  Font f1=new Font("Arial Rounded MT",Font.BOLD,20);
  Font f2=new Font("Segoe Script",Font.BOLD,20);
  Font f3=new Font("Stencil",Font.PLAIN,25);
 
  NumberGuessingGame()
  {
    this.getContentPane().setBackground(Color.WHITE);
    this.setTitle("Number Guessing Game ");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setLayout(null);  
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
   
    roundLabel=new JLabel("Round:");
    roundLabel.setBounds(90,40,120,50);
    roundLabel.setFont(f1);
    roundLabel.setForeground(Color.BLACK);
    this.add(roundLabel);
    
    round=new JLabel(String.valueOf(rounds));
    round.setBounds(180,43,50,50);
    round.setFont(f3);
    round.setForeground(Color.RED);
    this.add(round);
    
    chance=new JLabel("Number of Attempts Remained:");
    chance.setBounds(90,95,300,50);
    chance.setFont(f1);
    chance.setForeground(Color.BLACK);
    this.add( chance);
    
    counter=new JLabel("5");
    counter.setBounds(395,97,50,50);
    counter.setFont(f3);
    counter.setForeground(Color.RED);
    this.add(counter);
  
    
    scoreLabel=new JLabel("Score:");
    scoreLabel.setBounds(1125,40,100,50);
    scoreLabel.setFont(f1);
    scoreLabel.setForeground(Color.BLACK);
    this.add( scoreLabel);
    
    scores=new JLabel("0");
    scores.setBounds(1200,43,50,50);
    scores.setFont(f3);
    scores.setForeground(Color.RED);
    this.add(scores);
  
    numLabel=new JLabel("Enter Your Number Here:");
    numLabel.setBounds(300,200,250,50);
    numLabel.setFont(f1);
    numLabel.setForeground(Color.BLACK);
    this.add(numLabel);
    
    num=new JTextField();
    num.setBounds(600,200,250,40);
    num.setFont(f1);
    this.add(num);
    
    msgLabel=new JLabel("BEST OF LUCK..");
    msgLabel.setBounds(490,315,550,40);
    msgLabel.setForeground(Color.RED);
    msgLabel.setFont(f2);
    this.add(msgLabel);
    
    msg2Label=new JLabel("Msg will be shown here");
    msg2Label.setBounds(490,365,550,40);
    msg2Label.setForeground(Color.RED);
    msg2Label.setFont(f2);
    msg2Label.setVisible(false);
    this.add(msg2Label);
    
    guessBtn=new JButton("GUESS");
    guessBtn.setBounds(590,440,120,50);
    guessBtn.setBackground(Color.CYAN);
    guessBtn.setForeground(Color.BLACK);
    guessBtn.setFont(f1);
    this.add(guessBtn);
    guessBtn.addActionListener(this);
    
    guessAgainBtn=new JButton("GUESS AGAIN");
    guessAgainBtn.setBounds(590,440,180,50);
    guessAgainBtn.setBackground(Color.CYAN);
    guessAgainBtn.setForeground(Color.BLACK);
    guessAgainBtn.setFont(f1);
    guessAgainBtn.setVisible(false);
    this.add(guessAgainBtn);
    guessAgainBtn.addActionListener(this);
    
    playAgainBtn=new JButton("PLAY AGAIN");
    playAgainBtn.setBounds(590,440,180,50);
    playAgainBtn.setBackground(Color.CYAN);
    playAgainBtn.setForeground(Color.BLACK);
    playAgainBtn.setFont(f1);
    playAgainBtn.setVisible(false);
    this.add(playAgainBtn);
    playAgainBtn.addActionListener(this);
    
    
    Container c = this.getContentPane(); //Gets the content layer
    JLabel label = new JLabel(); //JLabel Creation
    label.setIcon(new ImageIcon("giphy.gif")); //Sets the image to be displayed as an icon
    Dimension size = label.getPreferredSize(); //Gets the size of the image
    label.setBounds(800, 300, size.width, size.height); //Sets the location of the image
    c.add(label); //Adds objects to the container
  }
 
   
 
    public void guessNumber()
    {
     
    user_num=Integer.parseInt(num.getText());
    if(user_num>number){
    msgLabel.setText("The number is too large, Guess minimum number...");
    }
     
    else if(user_num<number){
    msgLabel.setText("The number is too less, Guess maximum number...");
    }
    
    else
    {
     msgLabel.setText("Wohooo...You guessed it..");  
     guessBtn.setVisible(false);
     guessAgainBtn.setVisible(true);
     score+=10;
     scores.setText(String.valueOf(score));
     msg2Label.setText("The number is "+String.valueOf(number));
     msg2Label.setVisible(true);
     num.setText("");
     if(rounds>=3 && count>=1)
     {
     playAgainBtn.setVisible(true);
     guessBtn.setVisible(false);
     guessAgainBtn.setVisible(false);
     }
     } 
   
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==guessBtn)
        {
       
        counter.setText(String.valueOf(count));
        guessNumber();
        count--;
        }
    if(count==1)
    {
        msg2Label.setText("It's your last chance...");
    }
        if(count<1 && rounds<=3 && user_num!=number)
        {
            counter.setText(String.valueOf(0));
            msgLabel.setText("Sorry,You loose..");
            msg2Label.setText("The number is "+String.valueOf(number));
            msg2Label.setVisible(true);
            guessBtn.setVisible(false);
            guessAgainBtn.setVisible(true);
            num.setText("");
        }
        
        if(e.getSource()==guessAgainBtn)
        {
         number=(int)(Math.random()*100);
         count=5;
         rounds+=1;
         counter.setText(String.valueOf(count));
         round.setText(String.valueOf(rounds));
         msg2Label.setVisible(false);
         msgLabel.setText("BEST OF LUCK...");
         guessAgainBtn.setVisible(false);
         guessBtn.setVisible(true);
         num.setText("");
        }
        if(rounds>3)
        {
         guessAgainBtn.setVisible(false);
         guessBtn.setVisible(false);
         rounds=0;
         round.setText(String.valueOf(rounds));
         counter.setText(String.valueOf(0));
         msgLabel.setText("Game Ended...");
         msg2Label.setText("Your Scores are: "+String.valueOf(score));
         msg2Label.setVisible(true);
         num.setText("");
         playAgainBtn.setVisible(true);
        }
        
        if(e.getSource()==playAgainBtn)
        {
        rounds=1;
        count=5;
        score=0;
        counter.setText(String.valueOf(count));
        round.setText(String.valueOf(rounds));
        msg2Label.setVisible(false);
        msgLabel.setText("BEST OF LUCK...");
        playAgainBtn.setVisible(false);
        guessAgainBtn.setVisible(false);
        guessBtn.setVisible(true);
        num.setText("");
        }
       }
}
