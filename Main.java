//Name: Enzo La
//Project: Craps Game
/*  A player rolls two dice.  Each die has six faces. 
These faces contain 1, 2, 3, 4, 5, and 6 spots.  After
the dice have come to rest, the sum of the spots on
the two upward faces is calculated.  If the sum is 7
or 11 on the first throw, the player wins.  If the sum
is 2, 3, or 12 on the first throw (called “craps”),
the player loses (i.e., the “house” wins).  If the sum
is 4, 5, 6, 8, 9, or 10 on the first throw, then that
sum becomes the player’s “point.”  To win, you must
continue rolling the dice until you “make your point.”
The player loses by rolling a 7 before making the
point.

Write a program that simulates this game.  It only has
to output the rolls of the dice.
It should output each roll and whether the player has
won or lost.  The point should be identified also.

Use the variable GameStatus to keep track of whether a
person wins, loses, or continues.

You need two classes for the project.
The main class and the calculations "game" class.
You need to pass the sum of the dice over to your game class.
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Main extends JFrame implements ActionListener {
    // declares the variables
    JTextArea txaOutput = new JTextArea("", 10, 40);
    JButton btnRoll = new JButton("Roll!");
  
    // ints to hold our data
    double dice1 = 0;
    double dice2 = 0;
    int dicesum = 0;
  
    public static void main(String[] args) {
      Main frame = new Main();
      frame.setSize(330, 500);
      frame.setVisible(true);
    }
  
    public Main() {
      super("Craps");
      txaOutput.setLineWrap(true);
      txaOutput.setWrapStyleWord(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // set layout manager
      setLayout(new FlowLayout());
      // add components to form  
      add(btnRoll);
      add(txaOutput);
  
      // add listener to the button
      btnRoll.addActionListener(this);
    }
  
    public void actionPerformed(ActionEvent event) {
      Object objSource = event.getSource();
      if (objSource == btnRoll) {
        String outputString = "";
        
        dice1 = Math.floor(Math.random()*6) + 1;
        dice2 = Math.floor(Math.random()*6) + 1;
        dicesum = (int)dice1 + (int)dice2;
        String winLossString = "";
        CalculationsClass makeTheRoll = new CalculationsClass(dicesum);
        winLossString = makeTheRoll.getString();
        outputString = "First dice: " + dice1 + "\n" + "Second Dice: " + dice2 + "\n" + "Sum of dice: " + dicesum + "\n" + winLossString;
        
        txaOutput.setText(outputString);
      }
    }
  
  }
  