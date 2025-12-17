package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;      // Player key count
    public int orbCount = 0;    // Orbs collection count

    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);
        this.keyH = keyH;
        setDefaultValues();     // Starting position and stats
        getPlayerImage();       // Load walk sprites
        getPlayerAtk();         // Load attack sprites

        solidArea = new Rectangle(14, 30, 20, 15);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackArea.width = 40;
        attackArea.height = 40;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 47;
        worldY = gp.tileSize * 45;
        normalSpeed = 2;
        sprintSpeed = 6;
        animationSpeed = 7;
        direction = "down";

        // Player health setup
        maxLife = 5;
        life = maxLife;
    }

    public void getPlayerImage() {

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

        leftrun1 = setUp("/player/leftrun0");
        leftrun2 = setUp("/player/leftrun1");
        leftrun3 = setUp("/player/leftrun2");
        leftrun4 = setUp("/player/leftrun3");
        leftrun5 = setUp("/player/leftrun4");
        leftrun6 = setUp("/player/leftrun5");

        rightrun1 = setUp("/player/rightrun0");
        rightrun2 = setUp("/player/rightrun1");
        rightrun3 = setUp("/player/rightrun2");
        rightrun4 = setUp("/player/rightrun3");
        rightrun5 = setUp("/player/rightrun4");
        rightrun6 = setUp("/player/rightrun5");


    }

    public void getPlayerAtk() {

        atkleft1 = setUp("/player/attack0left1", gp.tileSize, gp.tileSize);
        atkleft2 = setUp("/player/attack0left2", gp.tileSize, gp.tileSize);
        atkleft3 = setUp("/player/attack0left3", gp.tileSize, gp.tileSize);
        atkleft4 = setUp("/player/attack0left4", gp.tileSize, gp.tileSize);
        atkleft5 = setUp("/player/attack0left5", gp.tileSize, gp.tileSize);
        atkleft6 = setUp("/player/attack0left6", gp.tileSize, gp.tileSize);

        atkright1 = setUp("/player/attack0", gp.tileSize, gp.tileSize);
        atkright2 = setUp("/player/attack1", gp.tileSize, gp.tileSize);
        atkright3 = setUp("/player/attack2", gp.tileSize, gp.tileSize);
        atkright4 = setUp("/player/attack3", gp.tileSize, gp.tileSize);
        atkright5 = setUp("/player/attack4", gp.tileSize, gp.tileSize);
        atkright6 = setUp("/player/attack5", gp.tileSize, gp.tileSize);
    }


    public void update() {

        boolean isMoving = false;

        // Handle basic movement and attack state
        if (attacking) {
            attacking();
        } else if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.shiftPressed) {
            // Separate checks allow diagonal input
            if (keyH.upPressed) {
                direction = "up";
                isMoving = true;
            }
            if (keyH.downPressed) {
                direction = "down";
                isMoving = true;
            }
            if (keyH.leftPressed) {
                direction = "left";
                isMoving = true;
            }
            if (keyH.rightPressed) {
                direction = "right";
                isMoving = true;
            }
        }

        // Tile collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        // Objects
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);

        // NPCs
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

        // Map events
        gp.eHandler.CheckEvent();

        // Monsters
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);

        // Sprint / stamina system
        if (keyH.shiftPressed && isMoving && stamina > 0) {
            sprint = true;
            normalSpeed =
