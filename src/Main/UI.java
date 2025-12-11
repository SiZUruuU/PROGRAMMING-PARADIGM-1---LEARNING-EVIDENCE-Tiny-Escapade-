package Main;

import Objects.SuperObject;
import Objects.objHealthBar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font maruMonica, PurisaB;
    BufferedImage healthBar1, healthBar2, healthBar3, healthBar4, healthBar5;
    public boolean messageOn = false;
    public String  message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public String currentDialogue = "";
    public int commandNum = 0;

    public UI(GamePanel gp) {
        this.gp = gp;


        try {
            InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/Purisa Bold.ttf");
            PurisaB = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //CREATE HUD OBJECT
        SuperObject heart = new objHealthBar(gp);
        healthBar1 = heart.image1;
        healthBar2 = heart.image2;
        healthBar3 = heart.image3;
        healthBar4 = heart.image4;
        healthBar5 = heart.image5;
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        this.g2 =  g2;

        g2.setFont(maruMonica);
        g2.setColor(Color.white);

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        //PLAY STATE
        if(gp.gameState == gp.playState){
            drawPlayerLife();
        }

        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPlayerLife();
            drawPauseScreen();
        }
        //DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawPlayerLife();
            drawDialogueScreen();
        }
    }

    public void drawPlayerLife(){

        int x = gp.tileSize / 3;
        int y = gp.tileSize / 9;
        int i = 0;

        //DRAW HEALTH BAR
        switch(gp.player.life){

            case 5:
                g2.drawImage(healthBar1, x, y, null);
                break;
            case 4:
                g2.drawImage(healthBar2, x, y, null);
                break;
            case 3:
                g2.drawImage(healthBar3, x, y, null);
                break;
            case 2:
                g2.drawImage(healthBar4, x, y, null);
                break;
            case 1:
                g2.drawImage(healthBar5, x, y, null);
                break;

        }





    }

    public void drawTitleScreen(){

        g2.setColor(new Color(90,90,100));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String text = "DAYS BREAK";
        int x =  getXforCenteredText(text);
        int y =  gp.tileSize * 3;

        //SHADOW
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        //TEXT
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        text = "Start Game";
        x = getXforCenteredText(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">" , x - gp.tileSize, y);
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        text = "Load Game";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">" , x - gp.tileSize, y);
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        text = "Quit Game";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">" , x - gp.tileSize, y);
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
