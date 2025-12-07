package Main;

import javax.swing.JFrame;

public class MainClass {

    public static void main(String [] args) {

        JFrame window = new JFrame(); //Creaptes new variable for JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Allows for process to close on exit
        window.setResizable(false);  //Sets window to unresizable
        window.setTitle("2D Game");  //Sets Game Title

        GamePanel gamePanel = new GamePanel();  //Creates new variable for GamePanel class
        window.add(gamePanel);  //Allows for GamePanel class to be visible in JFrame

        window.pack(); //Automatically sizes window to fit all contents

        window.setLocationRelativeTo(null); //Sets window location to center of screen
        window.setVisible(true);  //Allows for window to be visible

        gamePanel.setupGame();
        gamePanel.startGameThread();  //Calls "startGameThreat" method from GamePanel class
    }

}