package Projektet;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TomAndJerry extends  JPanel{
    //these variables are for the positions of Tom and Jerry
    int jerryHorizontal =300; // this should be zero but for me not to write left, left 100 times I made it closer
    int jerryVertical = 300;

    int tomHorizontal = 400;

    int tomVertical = 400;
    
    String lostGameText = "";

    boolean truthValue = true;

    public  TomAndJerry() {



        //here im creating the object JFrame to create a frame and draw on it
        JFrame frame = new JFrame();
        //setting a title
        frame.setTitle("Tom and Jerry game");
        //setting the size of the frame
        frame.setSize(800,800);
        //making the frame show
        frame.setVisible(true);
        //this makes it, so it knows from where to draw it in this case
        // from this class if I wanted to access another class id use the object which it initializes the class
        frame.getContentPane().add(this);


        //this variable is so we know which one will be playing next
        int player = 0;


        //I created an infinite loop, so it keeps playing until a player is caught
        while (truthValue) {


            // this is so the player 1 plays aka Jerry
            if (player%2 == 0) {

                    //it increments the player number so the next player will play in the next while loop
                    player++;

                    //created a scanner, so I get keywords to move the "users"
                    Scanner scanner = new Scanner(System.in);

                    String scannerInput;

                    scannerInput = scanner.nextLine();

                    //made this so it tells the user who played last
                    System.out.println("Jerry moved " + scannerInput);

                    //created this switch statement so that it gets some cases in which the player should move
                    //such as "up, down, right, left"
                    switch (scannerInput) {
                        //in the case up (this is for player jerry) if the player is already at the top he cant
                        //go further up, if he isn't he will be going up by 35 pixels
                        case "up":
                            if(jerryVertical < 35) {
                                System.out.println("You cant move here");

                            } else {
                                jerryVertical-=35;
                                // A call to repaint() calls update() which means that it will re-render all the components
                                repaint();
                            }
                            break;

                        case "down":
                            if(jerryVertical > 765) {
                                System.out.println("You cant move here");
                            } else {
                                jerryVertical+=35;
                                repaint();
                            }
                            break;

                        case "left":
                            if(jerryHorizontal < 35) {
                                System.out.println("You cant move here");
                            } else {
                                jerryHorizontal-=35;
                                repaint();
                            }
                            break;

                        case "right":
                            if(jerryHorizontal > 740) {
                                System.out.println("You cant move here");
                            } else {
                                jerryHorizontal+=35;
                                repaint();
                            }
                            break;
                    }
                if(
                    // If corners touch  then Tom caught Jerry
                        tomHorizontal == jerryHorizontal+35 && tomVertical == jerryVertical+35
                                || tomHorizontal == jerryHorizontal + 35 && tomVertical == jerryVertical
                                || tomVertical == jerryVertical + 35 && tomHorizontal == jerryHorizontal
                                || tomHorizontal == jerryHorizontal -35 && tomVertical == jerryVertical + 35
                                || tomHorizontal == jerryHorizontal -35 && tomVertical == jerryVertical
                                || tomHorizontal == jerryHorizontal - 35 && tomVertical == jerryVertical - 35
                                || tomHorizontal == jerryHorizontal && tomVertical == jerryVertical -35
                                || tomHorizontal == jerryHorizontal + 35 && tomVertical == jerryVertical -35
                                // if tom is inside jerry then tom caught jerry

                                ||  jerryHorizontal-35<tomHorizontal&&tomHorizontal<jerryHorizontal+35
                                && jerryVertical - 35 < tomVertical && tomVertical < jerryVertical + 35

                                || tomHorizontal- 35 < jerryHorizontal && jerryHorizontal< tomHorizontal + 35
                                && tomVertical- 35 < jerryVertical && jerryVertical< tomVertical + 35
                ){
                    lostGameText = "TOM CAUGHT JERRY";
                    repaint();
                    truthValue = false;
                    System.out.println(lostGameText);


                }
                    if (!truthValue) {
                        scanner.close();
                    }

            } else {

                player++;

                Scanner scanner = new Scanner(System.in);
                String player2Move;

                player2Move = scanner.nextLine();

                System.out.println("Tom moved " + player2Move);

                switch (player2Move) {

                    case "up":
                        if(tomVertical < 35) {
                            System.out.println("You cant move here");
                        } else {
                            tomVertical-=35;
                            repaint();
                        }
                        break;
                    case "down":

                        if(tomVertical > 739) {
                            System.out.println("You cant move here");
                        } else {
                            tomVertical+=35;
                            repaint();}
                        break;

                    case "left":
                        if(tomHorizontal < 35) {
                            System.out.println("You cant move here");
                        } else {
                            tomHorizontal-=35;
                            repaint();
                        }
                        break;

                    case "right":
                        if(tomHorizontal > 764) {
                            System.out.println("You cant move here");
                        } else {
                            tomHorizontal+=35;
                            repaint();
                        }
                        break;
                }
                if(
                    // If corners touch  then Tom caught Jerry
                        tomHorizontal == jerryHorizontal+35 && tomVertical == jerryVertical+35
                                || tomHorizontal == jerryHorizontal + 35 && tomVertical == jerryVertical
                                || tomVertical == jerryVertical + 35 && tomHorizontal == jerryHorizontal
                                || tomHorizontal == jerryHorizontal -35 && tomVertical == jerryVertical + 35
                                || tomHorizontal == jerryHorizontal -35 && tomVertical == jerryVertical
                                || tomHorizontal == jerryHorizontal - 35 && tomVertical == jerryVertical - 35
                                || tomHorizontal == jerryHorizontal && tomVertical == jerryVertical -35
                                || tomHorizontal == jerryHorizontal + 35 && tomVertical == jerryVertical -35
                                // if tom is inside jerry then tom caught jerry

                                ||  jerryHorizontal-35<tomHorizontal&&tomHorizontal<jerryHorizontal+35
                                && jerryVertical - 35 < tomVertical && tomVertical < jerryVertical + 35

                                || tomHorizontal- 35 < jerryHorizontal && jerryHorizontal< tomHorizontal + 35
                                && tomVertical- 35 < jerryVertical && jerryVertical< tomVertical + 35
                ){
                    lostGameText = "TOM CAUGHT JERRY";
                    repaint();
                    truthValue = false;
                    System.out.println(lostGameText);

                }

                if (!truthValue){
                    scanner.close();
                }

            }
        }
    }
    /**     <-   TO DO LIST: NUK PO UM BOJNE CASES PER SHKAK SE METODA ESHTE JASHT SCANNER WHATEVER
     *
     * ->       **/

        public void paint(Graphics graphics) {

            super.paint(graphics);
            graphics.setColor(new Color(204,204,255));
            graphics.fillRect(0,0,800,800);

            graphics.setColor(new Color(204,102,0));
            graphics.fillOval(jerryHorizontal, jerryVertical, 35, 35);

            graphics.setColor(new Color(0,102,102));
            graphics.fillOval(tomHorizontal, tomVertical, 35,35);
            
            if (lostGameText.equals("TOM CAUGHT JERRY")) {
                graphics.setColor(Color.red);
                graphics.drawString(lostGameText, 350,40);
            } else {
                graphics.setColor(new Color(0,150,30));
                graphics.drawString("Tom is chasing jerry", 350 , 40);
            }
        }

    public static void main(String[] args) {

        new TomAndJerry();

    }
}
