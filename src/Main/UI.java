package Main;

import Entity.Entity;
import Objects.objHealthBar;
import Objects.objStaminaBar;

import javax.swing.plaf.ColorUIResource;
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
    BufferedImage staminaBar1, staminaBar2, staminaBar3;
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
            InputStream is = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/res/font/Purisa Bold.ttf");
            PurisaB = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //CREATE HUD OBJECT
        Entity heart = new objHealthBar(gp);
        healthBar1 = heart.image1;
        healthBar2 = heart.image2;
        healthBar3 = heart.image3;
        healthBar4 = heart.image4;
        healthBar5 = heart.image5;

        Entity staminaBar = new objStaminaBar(gp);
        staminaBar1 = staminaBar.image1;
        staminaBar2 = staminaBar.image2;
        staminaBar3 = staminaBar.image3;
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

        //GUIDESTATE
        if(gp.gameState == gp.guideState){
            drawGuideScreen();
        }
        //PLAY STATE
        if(gp.gameState == gp.playState){
            drawPlayerLife();
            drawPlayerStaminaBar(g2);
            drawStaminaBar();
            drawMessage();
            drawPlayerFloatingText();
        }

        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPlayerLife();
            drawPauseScreen();
            drawStaminaBar();
            drawPlayerStaminaBar(g2);
        }
        //DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawPlayerLife();
            drawPlayerStaminaBar(g2);
            drawStaminaBar();
            drawDialogueScreen();
        }
        //GAME OVER STATE
        if(gp.gameState == gp.gameOverState || gp.gameState == gp.endGameState){
            drawGameOverScreen();
        }
    }
    public void drawGameOverScreen(){

        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));

        if (gp.gameState == gp.endGameState) {
            // === WINNING SCREEN ===

            text = "TRIAL COMPLETE";
            g2.setColor(Color.black); // Shadow
            x = getXforCenteredText(text);
            y = gp.tileSize * 4;
            g2.drawString(text, x, y);

            g2.setColor(Color.yellow); // Main Color
            g2.drawString(text, x-4, y-4);

            // Win Menu Options
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
            text = "Back to Title";
            x = getXforCenteredText(text);
            y = gp.tileSize * 6;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">>", x-40, y);
            }
        }
        else {

            text = "GAME OVER";
            g2.setColor(Color.black); // Shadow
            x = getXforCenteredText(text);
            y = gp.tileSize * 4;
            g2.drawString(text, x, y);

            g2.setColor(Color.white); // Main Color
            g2.drawString(text, x-4, y-4);

            // Lose Menu Options
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
            text = "Retry";
            x = getXforCenteredText(text);
            y = gp.tileSize * 6;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">>", x-40, y);
            }

            text = "Quit";
            x = getXforCenteredText(text);
            y = gp.tileSize * 7;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">>", x-40, y);
            }
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

    public void drawMessage() {
        if (messageOn) {

            messageCounter++;
            int alpha = 0;

            if (messageCounter <= 30) {

                alpha = messageCounter * (255 / 30);
            }

            else if (messageCounter > 30 && messageCounter <= 180) {alpha = 255;}

            else if (messageCounter > 180 && messageCounter <= 210) {
                int progress = messageCounter - 180;
                alpha = 255 - (progress * (255 / 30));
            }

            else {
                messageCounter = 0;

                if (message.equals("THE TRIAL HAS BEGUN")) {

                    message = "Kill All Ghosts!";
                    messageCounter = -60;
                    messageOn = true;
                }
                else {
                    messageOn = false;
                }
            }

            if (alpha < 0) alpha = 0;
            if (alpha > 255) alpha = 255;

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
            int x = getXforCenteredText(message);
            int y = gp.tileSize * 5;

            g2.setColor(new Color(0, 0, 0, alpha));
            g2.drawString(message, x + 2, y + 2);

            g2.setColor(new Color(255, 255, 255, alpha));
            g2.drawString(message, x, y);
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

    public void drawGuideScreen(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        if(gp.guidePage == 0) {
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));

            String text = "Controls";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 2;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
            text = "Movement:";
            x = getXforCenteredText(text);
            y = gp.tileSize * 3;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "W - Walk Up";
            x = getXforCenteredText(text);
            y = gp.tileSize * 4;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "S - Walk Down";
            x = getXforCenteredText(text);
            y = gp.tileSize * 5;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "A - Walk Right";
            x = getXforCenteredText(text);
            y = gp.tileSize * 6;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "D - Walk Left";
            x = getXforCenteredText(text);
            y = gp.tileSize * 7;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "Shift - Sprint";
            x = getXforCenteredText(text);
            y = gp.tileSize * 8;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "E - Interact";
            x = getXforCenteredText(text);
            y = gp.tileSize * 9;
            g2.drawString(text, x, y);
        }
        else if(gp.guidePage == 1){

            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));

            String text = "Sprint Mechanics";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 2;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));
            text = "This is your Stamina Bar";
            x = getXforCenteredText(text);
            y = gp.tileSize * 4;
            g2.drawString(text, x, y);

            x = getXforCenteredText(text) + 65;
            y = gp.tileSize * 5 - 15;
            g2.drawImage(staminaBar1, x, y, null);

            text = "You can only sprint for as long";
            x = getXforCenteredText(text);
            y = gp.tileSize * 8;
            g2.drawString(text, x, y);

            text = "as your stamina bar is filled";
            x = getXforCenteredText(text);
            y = gp.tileSize * 9;
            g2.drawString(text, x, y);

        }
        else if(gp.guidePage == 2){

            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));

            String text = "HOW TO WIN?";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 2;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));
            text = "Collect orbs, keys to unlock the main room! (Its that simple)";
            x = getXforCenteredText(text);
            y = gp.tileSize * 5;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "Be Careful! Nasty critters lurk the area...";
            x = getXforCenteredText(text);
            y = gp.tileSize * 7;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "Do you best to avoid getting hurt!";
            x = getXforCenteredText(text);
            y = gp.tileSize * 8;
            g2.drawString(text, x, y);
        }
        if (gp.guideTimer > 180) {

            g2.setFont(g2.getFont().deriveFont(20F));
            g2.setColor(Color.yellow);

            String text = ">>PRESS ENTER TO CONTINUE<< ";
            // If it's the last page, maybe change text to "START GAME"
            if(gp.guidePage == 2) {
                text = ">>>PRESS ENTER TO START<<<";
            }

            int x = getXforCenteredText(text);
            int y = gp.screenHeight - (gp.tileSize * 2);
            g2.drawString(text, x, y);
        }
    }

    public void drawPlayerFloatingText() {

        if (gp.player.floatingTextOn) {

            String text = gp.player.currentFloatingText;

            // 1. Calculate Position (Above and slightly right of player)
            // Adjust these numbers based on your sprite size
            int x = getXforCenteredText(text) - 10;
            int y = gp.player.screenY + 9;

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 11F));

            // 3. Draw Text Shadow
            g2.setColor(Color.black);
            g2.drawString(text, x + 1, y + 1);

            // 4. Draw Main Text
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
        }
    }

    public void drawPauseScreen(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);

    }

    public void drawPlayerStaminaBar(Graphics2D g2) {

        //StaminaBar Position
        int x = gp.tileSize / 3 + 5;
        int y = gp.tileSize + 11;
        int width = gp.tileSize * 5 + 6;
        int height = 14;

        double oneScale = (double)width / ((double) gp.player.maxStamina / 2);
        double currentBarWidth = ((oneScale * gp.player.stamina) / 4) - 10;


        if(currentBarWidth < 0) { currentBarWidth = 0; }


        g2.setColor(new Color(255, 255, 0));
        g2.fillRect(x, y, (int)currentBarWidth, height);
    }

    public void drawStaminaBar() {

        int x = gp.tileSize / 3;
        int y = gp.tileSize;
        int i = 0;

        //DRAW STAMINA BAR
        if(gp.player.stamina <= 100 && gp.player.stamina >= 51) {
            g2.drawImage(staminaBar1, x, y, null);
        }
        else if(gp.player.stamina <= 50 && gp.player.stamina >= 1) {
            g2.drawImage(staminaBar2, x, y, null);
        }
        else if(gp.player.stamina == 0) {
            g2.drawImage(staminaBar3, x, y, null);
        }
    }

    public void drawDialogueScreen(){

        //WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 3;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
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

