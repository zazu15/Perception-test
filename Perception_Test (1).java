/*A program that administers a perception test with Zener Cards.
  Alfred Okorocha
  Chiamaka Onwude
  csc281
  11/3/2022
*/
import javax.swing.*;
import java.util.*;
public class Perception_Test {
    public static void main(String[] args) {
        String[] colors ={"red","blue","green","yellow","black"};
        String[] shapes={"square","circle","star","wavy","plus"};
        String game_name = "Perception Game";
        
        Random rand_gen = new Random();
        int color = rand_gen.nextInt(5);
        int shape =rand_gen.nextInt(5);
        String filename = "psi_cards/"+colors[color]+"And"+shapes[shape]+".png";
        String[] choices = {"Shape","Color","Both","Quit"};
        boolean play = true;
        String game_choice = "";
        
        ImageIcon icon = new ImageIcon(filename);
        ImageIcon intro_image = new ImageIcon("psi_cards/question.png");
        ImageIcon guess_image = new ImageIcon("psi_cards/unknown.png");
        
        String intro_message ="Welcome to the Precption test. "
                + "\nYou will guess the shape or color you wish to test"
                + "\nClick Start to continue";
        String[] start_Quit = {"Start","Quit"};
        int start = JOptionPane.showOptionDialog(null, intro_message, game_name, 0, 0, intro_image, start_Quit, start_Quit[0]);
        String game_mode ="Which Perception Test would you like to perform";
        int perception_count = 0;
        
        if(start == 0 )
        {
            int score = 0;
            while(play == true)
            {
                game_choice += "Shapes";
                int choice = JOptionPane.showOptionDialog(null, game_mode, game_name, 0, 0, intro_image, choices, choices[0]);
                int game_round = 5;
                int round = 0;
                if(choice == 0)
                {
                    while(round < game_round)
                    {
                        shape =rand_gen.nextInt(5);
                        filename = "psi_cards/"+colors[color]+"And"+shapes[shape]+".png";
                        icon = new ImageIcon(filename);
                        String shape_guess_message = "Guess the shape ";
                        int shape_guess = JOptionPane.showOptionDialog(null,shape_guess_message,game_name , 0, 0, guess_image, shapes,shapes[0]);
                        String result_acumulator ="You picked "+shapes[shape_guess]+" and the computer picked "+shapes[shape];
                        if(shapes[shape_guess]==shapes[shape])
                        {
                            result_acumulator += " you are correct good guess";
                            JOptionPane.showMessageDialog(null, ""+result_acumulator, game_name, 0, icon);
                            score += 1;
                        }
                        else
                        {
                            result_acumulator += " you are wrong ";
                            JOptionPane.showMessageDialog(null, ""+result_acumulator, game_name, 0, icon);
                        }
                        round += 1;
                    }
                }
                if(choice == 1)
                {
                    game_choice += "Colors";
                    while(round < game_round)
                    {
                        color = rand_gen.nextInt(5);
                        filename = "psi_cards/"+colors[color]+"And"+shapes[shape]+".png";
                        icon = new ImageIcon(filename);
                        String color_guess_message = "Guess the color ";
                        int color_guess = JOptionPane.showOptionDialog(null,color_guess_message,game_name , 0, 0, guess_image, colors,colors[0]);
                        String result_acumulator ="You picked "+colors[color_guess]+" and the computer picked "+colors[color];
                        if(colors[color_guess]== colors[color])
                        {
                            result_acumulator += " you are correct good guess";
                            JOptionPane.showMessageDialog(null, ""+result_acumulator, game_name, 0, icon);
                            score += 1;
                        }
                        else
                        {
                            result_acumulator += " you are wrong ";
                            JOptionPane.showMessageDialog(null, ""+result_acumulator, game_name, 0, icon);
                        }
                        round += 1;
                    }
                }
                if(choice == 2)
                {
                    game_choice += "Shape and Color";
                    while(round < game_round)
                    {
                        color = rand_gen.nextInt(5);
                        shape =rand_gen.nextInt(5);
                        filename = "psi_cards/"+colors[color]+"And"+shapes[shape]+".png";
                        icon = new ImageIcon(filename);
                        String color_guess_message = "First Guess the color ";
                        String shape_guess_message = "Now Guess the shape ";
                        int color_guess = JOptionPane.showOptionDialog(null,color_guess_message,game_name , 0, 0, guess_image, colors,colors[0]);
                        int shape_guess = JOptionPane.showOptionDialog(null,shape_guess_message,game_name , 0, 0, guess_image, shapes,shapes[0]);
                        String result_acumulator ="You picked a "+colors[color_guess]+" "+ shapes[shape_guess]+ " and the computer picked "+colors[color]+" "+shapes[shape];
                        if(colors[color_guess]== colors[color] && shapes[shape_guess]==shapes[shape])
                        {
                            result_acumulator += " you are correct good guess";
                            JOptionPane.showMessageDialog(null, ""+result_acumulator, game_name, 0, icon);
                            score += 1;
                        }
                        else
                        {
                            result_acumulator += " you are wrong ";
                            JOptionPane.showMessageDialog(null, ""+result_acumulator, game_name, 0, icon);
                        }
                        round += 1;
                    }
                }
                if(choice == 3)
                {
                    break;
                }
                perception_count += 5;
                String final_results = "You have tested "+game_choice+" perception test "+perception_count+" times and have a score of "+score;
                String[] playAgain_Quit = {"Quit","Add another 5 perceptions"};
                int play_again = JOptionPane.showOptionDialog(null, final_results,"Final Results", 0, 0, intro_image, playAgain_Quit, playAgain_Quit[0]);
                game_choice = "";
                if(play_again == 0)
                {
                    break;
                }
            }
        }
    } 
}
