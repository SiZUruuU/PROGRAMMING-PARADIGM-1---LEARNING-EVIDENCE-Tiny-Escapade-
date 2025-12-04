package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int normalSpeed;

    //Main Character Images
    public BufferedImage left1, left2, left3, left4, left5, left6;
    public BufferedImage right1, right2, right3, right4, right5, right6;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int animationSpeed;
    public Rectangle solidArea;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean collisionOn = false;
}
