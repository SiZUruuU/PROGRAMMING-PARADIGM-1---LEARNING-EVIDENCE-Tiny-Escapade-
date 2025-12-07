package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

//    public int hasKey = 0;
//    public int orbCount = 0;

    public Player(GamePanel gp, KeyHandler keyH){

        super(gp);
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();

        solidArea = new Rectangle(17,30,13, 13);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        screenX = gp.screenWidth/2 - (gp.tileSize / 2);
        screenY = gp.screenHeight/2 - (gp.tileSize / 2);
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        normalSpeed = 2;
        animationSpeed = 7;
        direction = "down";
    }

    public void getPlayerImage(){

            left1 = setUp("/player/left0");
            left2 = setUp("/player/left1");
            left3 = setUp("/player/left2");
            left4 = setUp("/player/left3");
            left5 = setUp("/player/left4");
            left6 = setUp("/player/left5");

            right1 = setUp("/player/right0");
            right2 = setUp("/player/right1");
            right3 = setUp("/player/right2");
            right4 = setUp("/player/right3");
            right5 = setUp("/player/right4");
            right6 = setUp("/player/right5");

    }



    public void update(){

        boolean isMoving = false;
        // Use separate if statements to allow diagonal movement
        if(keyH.upPressed){
            direction =  "up";
            isMoving = true;
        }
        if(keyH.downPressed){
            direction =  "down";
            isMoving = true;
        }
        if(keyH.leftPressed){
            direction =  "left";
            isMoving = true;
        }
        if(keyH.rightPressed){
            direction = "right";
            isMoving = true;
        }


        //Check Tile Collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //Check Object Collision
        int objIndex = gp.cChecker.checkObject(this,true);
        pickUpObject(objIndex);

        //Check NPC collision
        int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
        interactNPC(npcIndex);


            if(!collisionOn && isMoving){

                switch(direction){

                    case "up":
                        worldY -= normalSpeed;
                        break;
                    case "down":
                        worldY += normalSpeed;
                        break;
                    case "left":
                        worldX -= normalSpeed;
                        break;
                    case "right":
                        worldX += normalSpeed;
                        break;
                }

            }


        if (isMoving) {
            spriteCounter++;
            int animationSpeed = 5;
            if (spriteCounter > animationSpeed) {
                spriteNum++;
                if(spriteNum > 5) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            spriteNum = 1;
            spriteCounter = 0;
        }
    }

    public void pickUpObject(int i){

        if(i != 999){

        }
    }

    public void interactNPC(int i){

        if(i != 999){

            if(gp.keyH.eKeyPressed) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        gp.keyH.eKeyPressed = false;
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch (direction) {
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if(spriteNum == 3){
                    image = left3;
                }
                if(spriteNum == 4){
                    image = left4;
                }
                if(spriteNum == 5){
                    image = left5;
                }
                if(spriteNum == 6){
                    image = left6;
                }
                break;


            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right4;
                }
                if(spriteNum == 5){
                    image = right5;
                }
                if(spriteNum == 6){
                    image = right6;
                }
                break;

            case "down":
                image = right2;
                break;

            case "up":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right4;
                }
                if(spriteNum == 5){
                    image = right5;
                }
                if(spriteNum == 6){
                    image = right6;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize ,null);
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x,screenY + solidArea.y, solidArea.width, solidArea.height);


    }
}