package Main;

import Objects.objKey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Font courier_new_40, impact_80B;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String  message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;

        courier_new_40 = new Font("Courier New", Font.BOLD, 20);
        impact_80B = new Font("Impact", Font.BOLD, 80);
        objKey key = new objKey();
        keyImage = key.image;
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        if(gameFinished){

            g2.setFont(courier_new_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "YOU WIN";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 1);
            g2.drawString(text, x, y);

            text = "Time is: " + dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 3);
            g2.drawString(text, x, y);

            g2.setFont(courier_new_40);
            g2.setColor(Color.yellow);
            text = "CONGRATULATIONS";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 2);
            g2.drawString(text, x, y);

            gp.gameThread = null ;

        }
        else{

            g2.setFont(courier_new_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            //Time
            playTime += (double)1/60;

            //Message

            if(messageOn){

                g2.setFont(g2.getFont().deriveFont(10F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*8);

                messageCounter++;

                if(messageCounter > 100){
                    messageCounter = 0;
                    messageOn = false;
                }

            }

        }


    }
}
