package Main;

import javax.swing.JFrame;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char res;

            System.out.println("\nThis game is a horrible depiction of the origins of the First Supreme King of Cahtlacun.");
            System.out.println("Do you wish to proceed?");
            System.out.print("Yes[Y] or No[N]?");
            res = in.next().charAt(0);

            if (res == 'y' || res == 'Y') {

                JFrame window = new JFrame(); //Creates new variable for JFrame
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Allows for process to close on exit
                window.setResizable(false);  //Sets window to unresizable
                window.setTitle("The Origin of the First Supreme King of Cahtlacun");  //Sets Game Title

                GamePanel gamePanel = new GamePanel();  //Creates new variable for GamePanel class
                window.add(gamePanel);  //Allows for GamePanel class to be visible in JFrame

                window.pack(); //Automatically sizes window to fit all contents

                window.setLocationRelativeTo(null); //Sets window location to center of screen
                window.setVisible(true);  //Allows for window to be visible

                gamePanel.setupGame();
                gamePanel.startGameThread();  //Calls "startGameThreat" method from GamePanel class
            }else {
                System.out.print("Very well...");
                System.exit(0);
            }
        }
    }