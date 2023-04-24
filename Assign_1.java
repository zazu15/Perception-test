/*
  This program is to perform a perception test with Zener Cards.
  Marvellous Adeniyi
  CSCI281
  03/24/2023
 */

import javax.swing.*;
import java.util.*;

public class Assign_1 {
    public static void main(String[] args)
    {
        String[] colors = {"red", "blue", "green", "yellow", "black"};
        String[] shapes = {"square", "circle", "star", "wavy", "plus"};
        String gameName = "My Percerption_Test";
        
        Random randGen = new Random();
        int color = randGen.nextInt(6);
        int shape = randGen.nextInt(6);
        
        String fileName = "psi_cards/"+colors[color]+"AND"+shapes[shape]+".png";
        String[] choices = {"color","shape","both","Quit"};
        boolean play = true;
        String gameChoice = "";
        
        ImageIcon icon = new ImageIcon(fileName);
        ImageIcon introIcon = new ImageIcon("psi_cards/question.png");
        ImageIcon questionIcon = new ImageIcon("psi_cards/unknown.png");
        
        String introMessage = "Would you love to take a Precption test? "
                +"\nCan you guess the shape or color in this test"
                + "\nClick Start to continue";
        String[] startquit = {"Start","Quit"};
        int start = JOptionPane.showOptionDialog(null, introMessage, gameName, 0, 0, introIcon, startquit, startquit[0]);
        String gameMode ="Which Perception Test would you like to perform";
        int perceptionCount = 0;
        
        if(start == 0 )
        {
            int score = 0;
            while(play == true)
            {
                gameChoice += "colors";
                int choice = JOptionPane.showOptionDialog(null, gameMode, gameName, 0, 0, introIcon, choices, choices[0]);
                int gameRound = 5;
                int round = 0;
                if(choice == 0)
                {
                    while(round < gameRound)
                    {
                       color = randGen.nextInt(5);
                        fileName = "psi_cards/"+colors[color]+"And"+shapes[shape]+".png";
                        icon = new ImageIcon(fileName);
                        String color_guess_message = "Guess the color ";
                        int colorGuess = JOptionPane.showOptionDialog(null,color_guess_message,gameName , 0, 0, questionIcon, colors,colors[0]);
                        String resultAcumulator ="You picked "+colors[colorGuess]+" and the computer picked "+colors[color];
                        if(colors[colorGuess]== colors[color])
                        {
                            resultAcumulator += " you are correct ";
                            JOptionPane.showMessageDialog(null, ""+resultAcumulator, gameName, 0, icon);
                            score += 1;
                        }
                        else
                        {
                            resultAcumulator += " you are wrong ";
                            JOptionPane.showMessageDialog(null, ""+resultAcumulator, gameName, 0, icon);
                        }
                        round += 1; 
                    }
                }
                if(choice == 1)
                {
                    System.out.print("Its working");
                    gameChoice += "shapes";
                    while(round < gameRound)
                    {
                       shape = randGen.nextInt(5);
                        fileName = "psi_cards/"+colors[color]+"And"+shapes[shape]+".png";
                        icon = new ImageIcon(fileName);
                        String shape_guess_message = "Guess the shape ";
                        int shapeGuess = JOptionPane.showOptionDialog(null,shape_guess_message,gameName , 0, 0, questionIcon, shapes,shapes[0]);
                        String resultAcumulator ="You picked "+shapes[shapeGuess]+" and the computer picked "+shapes[shape];
                        if(shapes[shapeGuess]==shapes[shape])
                        {
                            resultAcumulator += " you are correct ";
                            JOptionPane.showMessageDialog(null, ""+resultAcumulator, gameName, 0, icon);
                            score += 1;
                        }
                        else
                        {
                            resultAcumulator += " you are wrong ";
                            JOptionPane.showMessageDialog(null, ""+resultAcumulator, gameName, 0, icon);
                        }
                        round += 1;
                    }
                }
                if(choice == 2)
                {
                    gameChoice += "Shape and Color";
                    while(round < gameRound)
                    {
                        color = randGen.nextInt(5);
                        shape =randGen.nextInt(5);
                        fileName = "psi_cards/"+colors[color]+"And"+shapes[shape]+".png";
                        icon = new ImageIcon(fileName);
                        String color_guess_message = "First Guess the color ";
                        String shape_guess_message = "Now Guess the shape ";
                        int colorGuess = JOptionPane.showOptionDialog(null,color_guess_message,gameName , 0, 0, questionIcon, colors,colors[0]);
                        int shapeGuess = JOptionPane.showOptionDialog(null,shape_guess_message,gameName , 0, 0, questionIcon, shapes,shapes[0]);
                        String resultAcumulator ="You picked a "+colors[colorGuess]+" "+ shapes[shapeGuess]+ " and the computer picked "+colors[color]+" "+shapes[shape];
                        if(colors[colorGuess]== colors[color] && shapes[shapeGuess]==shapes[shape])
                        {
                            resultAcumulator += " you are correct ";
                            JOptionPane.showMessageDialog(null, ""+resultAcumulator, gameName, 0, icon);
                            score += 1;
                        }
                        else
                        {
                            resultAcumulator += " you are wrong ";
                            JOptionPane.showMessageDialog(null, ""+resultAcumulator, gameName, 0, icon);
                        }
                        round += 1;
                    }
                }
                if(choice == 3)
                {
                    break;
                }
                perceptionCount += 5;
                String finalResults = "You tested "+gameChoice+" perception test "+perceptionCount+" times and a score of "+score;
                String[] playAgain_Quit = {"Quit","Add 5 new perceptions"};
                int play_again = JOptionPane.showOptionDialog(null, finalResults,"Final Results", 0, 0, introIcon, playAgain_Quit, playAgain_Quit[0]);
                gameChoice = "";
                if(play_again == 0)
                {
                    break;
                }
            }
        }
    }        
    }
}
