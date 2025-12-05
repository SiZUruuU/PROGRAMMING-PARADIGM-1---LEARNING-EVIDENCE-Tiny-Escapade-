package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;
    public int orbCount = 0;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
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

        try {

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/left4.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/left5.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/right4.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/right5.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

            String objectName = gp.obj[i].name;

            switch(objectName){

                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("Key: " + hasKey);
                    gp.ui.showMessage("You got " + hasKey + "x keys.");
                    break;
                case "Door":
//                    gp.music.stop();
//                    gp.playMusic(0);
                    if(hasKey > 0){
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You got " + hasKey + "x keys.");
                    }
                    else{

                        gp.ui.showMessage("You dont have enough keys");
                    }
                    break;

                case "Orb":
                    orbCount++;
                    if(orbCount > 3){
                        gp.music.stop();
                        gp.playMusic(1);
                        gp.ui.showMessage("WE ARE CHARLIE KIRK!!");
                    }
                    normalSpeed += 2;
                    System.out.println("Orb: " + orbCount);
                    gp.obj[i] = null;
                    break;

                case "Chest":
                    gp.ui.gameFinished = true;
//                    gp.stopMusic();
//                    gp.playSE(1);
                    break;

            }
        }

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

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x,screenY + solidArea.y, solidArea.width, solidArea.height);


    }
}