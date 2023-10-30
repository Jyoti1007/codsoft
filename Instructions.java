
package numberguessinggame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Instructions extends JFrame implements ActionListener {
    private JTextArea instruction;
    private JLabel heading;
    private JButton playbtn;
     Font f1=new Font("Times new roman",Font.PLAIN,25);
     Font f2=new Font("Times new roman",Font.BOLD,40);
    Instructions()
    {
    this.setTitle("Number Guessing Game ");
    this.getContentPane().setBackground(Color.WHITE);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setLayout(null);  
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
       
    heading=new JLabel("INSTRUCTIONS");    
    heading.setBounds(560,10,380,60); 
    heading.setFont(f2);
    heading.setForeground(Color.RED);
    this.add(heading);
    
    instruction=new JTextArea(5,50);
    instruction.setBounds(30,150,1000,300);
    instruction.setText("Before starting the game, Here you should consider the rules of this game:\n\n1).This is the game between You & the Computer\n2).The Computer will give you any number between 1 to 100 & you have to guess that number\n3). You will get only 5 chances..\n\n===>Click the Play button to start the game.....");
    instruction.setFont(f1);
    instruction.setEditable(false);
    this.add(instruction);
    
    playbtn=new JButton("START");
    playbtn.setBounds(580,480,200,40);
    playbtn.setFont(f1);
    playbtn.setBackground(Color.RED);
    playbtn.setForeground(Color.WHITE);
    this.add(playbtn);
    playbtn.addActionListener(this);
    
    Container c = this.getContentPane(); //Gets the content layer
    JLabel label = new JLabel(); //JLabel Creation
    label.setIcon(new ImageIcon("inst.png")); //Sets the image to be displayed as an icon
    Dimension size = label.getPreferredSize(); //Gets the size of the image
    label.setBounds(880, 440, size.width, size.height); //Sets the location of the image
    c.add(label); //Adds objects to the container   
    }
 public static void main(String args[])
 {
 new Instructions();
 }
    @Override
    public void actionPerformed(ActionEvent e) {
        new NumberGuessingGame();
    }
    
    
}
