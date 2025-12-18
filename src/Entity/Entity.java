package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {

    GamePanel gp;

    //World State
    public int worldX, worldY;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean keySpawned = false;
    public boolean finalStage = false;

    //KeyHolder NPC State
    public boolean enoughOrb = false;
    public boolean enoughSoul = false;
    public boolean enoughKey = false;
    public boolean completeProgress = false;

    //Final NPC
    public int talkCount = 1;

    //Player State
    public int normalSpeed;
    public int sprintSpeed;
    public int stamina = 100;
    public int maxStamina = 100;
    public int staminaRegenCount = 0;
    boolean sprint = false;
    boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    public String currentFloatingText = "";
    public boolean floatingTextOn = false;

    //Entity Animation Variables
    public String direction = "down";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int animationSpeed;

    //Counter
    public int invincibleCounter = 0;
    public int actionLockCounter;
    int dialogueIndex = 0;
    int dyingCounter = 0;
    int dialogueCount = 0;
    public int healRequirement = 1;
    public int dialogueInterval = 0;
    public int floatingTextTimer = 0;

    //Entity Buffered Images
    public BufferedImage still;
    public BufferedImage left1, left2, left3, left4, left5, left6;
    public BufferedImage right1, right2, right3, right4, right5, right6;
    public BufferedImage up1, up2, up3, up4, up5, up6;
    public BufferedImage down1, down2, down3, down4, down5, down6;
    public BufferedImage rightrun1, rightrun2, rightrun3, rightrun4, rightrun5, rightrun6;
    public BufferedImage leftrun1, leftrun2, leftrun3, leftrun4, leftrun5, leftrun6;
    public BufferedImage atkleft1, atkleft2, atkleft3, atkleft4, atkleft5, atkleft6;
    public BufferedImage atkright1, atkright2, atkright3, atkright4, atkright5, atkright6;
    public BufferedImage image;
    public BufferedImage image1, image2, image3, image4, image5, image6;

    //Extra Variables
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0,10,0,0);
    public boolean collisionOn = false;
    public boolean invincible = false;
    String dialogues[] = new String[20];
    String randomPlayerDialogues[] = new String[10];
    public String name;
    public boolean collision = false;
    public int type; //0 - player, 1 - npc, 2 - monster

    //CHARACTER STATUS
    public int maxLife;
    public int life;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {
    }

    public void speak() {

        if (dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction) {

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
            case "still":
                direction = "still";
                break;
        }
    }

    public void update() {

        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(this.type == 2 && contactPlayer){
            if(!gp.player.invincible){
                if(life > 0) {
                    gp.player.life--;
                    gp.player.invincible = true;
                }
            }
        }

        if (!collisionOn) {
            switch (direction) {

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
                case "still":
                    break;
            }
        }

        spriteCounter++;
        int animationSpeed = 5;
        if (spriteCounter > animationSpeed) {
            spriteNum++;
            if (spriteNum > 5) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        } else {
            spriteNum = 1;
            spriteCounter = 0;
        }

        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 30) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch (direction) {

                case "still":
                    image = still;
                    break;

                case "left":
                    if (spriteNum == 1) {image = left1;}
                    if (spriteNum == 2) {image = left2;}
                    if (spriteNum == 3) {image = left3;}
                    if (spriteNum == 4) {image = left4;}
                    if (spriteNum == 5) {image = left5;}
                    if (spriteNum == 6) {image = left6;}
                    break;


                case "right":
                    if (spriteNum == 1) {image = right1;}
                    if (spriteNum == 2) {image = right2;}
                    if (spriteNum == 3) {image = right3;}
                    if (spriteNum == 4) {image = right4;}
                    if (spriteNum == 5) {image = right5;}
                    if (spriteNum == 6) {image = right6;}
                    break;

                case "down":
                    if (spriteNum == 1) {image = left1;}
                    if (spriteNum == 2) {image = left2;}
                    if (spriteNum == 3) {image = left3;}
                    if (spriteNum == 4) {image = left4;}
                    if (spriteNum == 5) {image = left5;}
                    if (spriteNum == 6) {image = left6;}
                    break;

                case "up":
                    if (spriteNum == 1) {image = right1;}
                    if (spriteNum == 2) {image = right2;}
                    if (spriteNum == 3) {image = right3;}
                    if (spriteNum == 4) {image = right4;}
                    if (spriteNum == 5) {image = right5;}
                    if (spriteNum == 6) {image = right6;}
                    break;
            }

            if (invincible) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F));
            }
            if(dying){
                dyingAnimation(g2);
            }

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1F));

            if (gp.keyH.checkDrawTime) {
                g2.setColor(Color.RED);
                // We use drawRect (outline), not fillRect
                g2.drawRect(
                        screenX + solidArea.x,  // X position
                        screenY + solidArea.y,  // Y position
                        solidArea.width,        // Width
                        solidArea.height        // Height
                );
            }
        }
    }

    public void dyingAnimation(Graphics2D g2){

        dyingCounter++;

        if(dyingCounter <= 5){changeAlpha(g2, 0f);}
        if(dyingCounter > 5 && dyingCounter <= 10){changeAlpha(g2, 1f);}
        if(dyingCounter > 10 && dyingCounter <= 15){
            changeAlpha(g2, 0f);
            gp.playSE(11);
        }
        if(dyingCounter > 15 && dyingCounter <= 20){changeAlpha(g2, 1f);}
        if(dyingCounter > 20 && dyingCounter <= 25){changeAlpha(g2, 0f);}
        if(dyingCounter > 25 && dyingCounter <= 30){changeAlpha(g2, 1f);}
        if(dyingCounter > 30 && dyingCounter <= 35){changeAlpha(g2, 0f);}
        if(dyingCounter > 35 && dyingCounter <= 40){changeAlpha(g2, 1f);}
        if(dyingCounter > 40){
            dying = false;
            alive = false;
        }
    }

    public void changeAlpha(Graphics2D g2, float alphaValue){

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));

    }

    public BufferedImage setUp(String imagePath) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{

            image = ImageIO.read(getClass().getResourceAsStream("/res" + imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage setUp(String imagePath, int width, int height) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/" + imagePath + ".png"));
            image = uTool.scaleImage(image, width, height);

        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
