package Main;

import Objects.objKey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font courier_new_40, impact_80B;
//    BufferedImage keyImage;
    public boolean messageOn = false;
    public String  message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public String currentDialogue = "";

    public UI(GamePanel gp) {
        this.gp = gp;

        courier_new_40 = new Font("Courier New", Font.BOLD, 20);
        impact_80B = new Font("Impact", Font.BOLD, 80);
//        objKey key = new objKey(gp);
//        keyImage = key.image;
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        this.g2 =  g2;

        g2.setFont(courier_new_40);
        g2.setColor(Color.white);

        //PLAY STATE
        if(gp.gameState == gp.playState){
        }
        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }
    }

    public void drawPauseScreen(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);

    }

    public void drawDialogueScreen(){

        //WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 3;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 20;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color c = new Color(0,0,0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height,35,35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);

    }

    public int getXforCenteredText(String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;

    }
}
