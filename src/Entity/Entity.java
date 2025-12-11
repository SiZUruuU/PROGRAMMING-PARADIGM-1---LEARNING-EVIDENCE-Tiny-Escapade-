package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {

    GamePanel gp;

    public int worldX, worldY;
    public int normalSpeed;

    //Main Character Images
    public BufferedImage left1, left2, left3, left4, left5, left6, left7, left8;
    public BufferedImage right1, right2, right3, right4, right5, right6;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int animationSpeed;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;

    //CHARACTER STATUS
    public int maxLife;
    public int life;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void setAction(){}
    public void speak(){

        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }

        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch(gp.player.direction) {

            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }

    }
    public void update(){

        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);

        if(!collisionOn){

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

            spriteCounter++;
            int animationSpeed = 5;
            if (spriteCounter > animationSpeed) {
                spriteNum++;
                if(spriteNum > 5) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
            else {
            spriteNum = 1;
            spriteCounter = 0;
        }

    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        int screenX =  worldX - gp.player.worldX + gp.player.screenX;
        int screenY =  worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {

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
        }
    }

    public BufferedImage setUp(String imagePath) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{

            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
