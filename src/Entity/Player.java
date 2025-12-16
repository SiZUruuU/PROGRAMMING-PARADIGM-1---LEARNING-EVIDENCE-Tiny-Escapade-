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

    public int hasKey = 0;
    public int orbCount = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
        getPlayerAtk();

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

        //PLAYER STATUS
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

        if (attacking) {
            attacking();
        } else if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.shiftPressed) {
            // Use separate if statements to allow diagonal movement
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

        //Check Tile Collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //Check Object Collision
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);

        //Check NPC collision
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

        //Check Event
        gp.eHandler.CheckEvent();

        //Check Monster Collision
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);

        if (keyH.shiftPressed && isMoving && stamina > 0) {
            sprint = true;
            normalSpeed = sprintSpeed;
            stamina--;

            if (stamina <= 0) {
                sprint = false;
                if (sprintSpeed > 2) {
                    sprintSpeed = 2;
                    stamina = 0;
                }
            }
        } else {

            sprint = false;
            normalSpeed = 2;

            if (!keyH.shiftPressed && stamina < 100) {
                staminaRegenCount++;
            }
            if (staminaRegenCount > 120) {
                stamina++;
                if (keyH.shiftPressed) {
                    staminaRegenCount = 0;
                }
                if (stamina == 100) {
                    staminaRegenCount = 0;
                }
            }
            if (stamina > 0 && sprintSpeed < 6) {
                sprintSpeed++;
            }
        }

        if (!collisionOn && isMoving) {

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
            }

        }

        if (isMoving) {
            spriteCounter++;
            int animationSpeed = 5;
            if (spriteCounter > animationSpeed) {
                spriteNum++;
                if (spriteNum > 5) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {

            if (attacking == false) {
                spriteNum = 1;
                spriteCounter = 0;
            }
        }

        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void attacking() {

        spriteCounter++;

        // Change "<=" to ">" so it waits 5 frames before switching
        if (spriteCounter > 5) {

            // 1. Move to the next frame
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;

                //Saves current worldX, worldy and solid area
                int currentWorldX = worldX;
                int currentWorldY = worldY;
                int solidAreaWidth = solidArea.width;
                int solidAreaHeight = solidArea.height;

                //Adjust worldX, worldY and solid area for attackArea
                switch (direction) {
                    case "up":
                        worldY -= attackArea.height;
                        break;
                    case "down":
                        worldY += gp.tileSize;
                        break;
                    case "left":
                        worldX -= attackArea.width;
                        break;
                    case "right":
                        worldX += attackArea.width;
                        break;

                }

                //Attack Area becomes Solid Area
                solidArea.width = attackArea.width;
                solidArea.height = attackArea.height;

                //Checks Monster Collision
                int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
                damageMonster(monsterIndex);

                //Rewrites original data after checking monster collision
                worldX = currentWorldX;
                worldY = currentWorldY;
                solidArea.width = solidAreaWidth;
                solidArea.height = solidAreaHeight;
            } else if (spriteNum == 3) {
                spriteNum = 4;

                //Saves current worldX, worldy and solid area
                int currentWorldX = worldX;
                int currentWorldY = worldY;
                int solidAreaWidth = solidArea.width;
                int solidAreaHeight = solidArea.height;

                //Adjust worldX, worldY and solid area for attackArea
                switch (direction) {
                    case "up":
                        worldY -= attackArea.height;
                        break;
                    case "down":

                        worldY += gp.tileSize;
                        break;
                    case "left":
                        worldX -= attackArea.width;
                        break;
                    case "right":
                        worldX += attackArea.width;
                        break;

                }

                //Attack Area becomes Solid Area
                solidArea.width = attackArea.width;
                solidArea.height = attackArea.height;

                //Checks Monster Collision
                int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
                damageMonster(monsterIndex);

                //Rewrites original data after checking monster collision
                worldX = currentWorldX;
                worldY = currentWorldY;
                solidArea.width = solidAreaWidth;
                solidArea.height = solidAreaHeight;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
            } else if (spriteNum == 6) {
                spriteNum = 1;// Stop attacking AFTER frame 6 plays
                attacking = false;
            }
            spriteCounter = 0;

        }
    }

    public void pickUpObject(int i) {

        if (i != 999) {

            String objectName = gp.obj[i].name;

            switch (objectName) {

                case "Key":
                    if (orbCount < 3) {

                    } else {
                        hasKey++;
                        gp.obj[i] = null;
                        System.out.print("Key" + hasKey);
                    }
                    break;
                case "Door":
                    if (hasKey > 0) {
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    break;
                case "Orb":
                    gp.playSE(5);
                    gp.obj[i] = null;
                    orbCount++;
                    break;
            }

        }
    }

    public void interactNPC(int i) {

        if (gp.keyH.eKeyPressed) {

            if (gp.keyH.eKeyPressed) {

                if (i != 999) {

                    // 1. Dialogue Branch
                    gp.gameState = gp.dialogueState;
                    gp.npc[i].speak();
                    gp.playSE(4);

                    gp.keyH.eKeyPressed = false;

                } else {

                    attacking = true;
                    gp.keyH.eKeyPressed = false;
                }
            }
        }
    }

    public void contactMonster(int i) {

        if (i != 999) {
            if (!invincible) {
                if (life > 0) {
                    Random random = new Random();
                    int j = random.nextInt(3) + 1;
                    switch(j){
                        case 1:
                            gp.playSE(8);
                            break;
                        case 2:
                            gp.playSE(9);
                            break;
                        case 3:
                            gp.playSE(10);
                            break;

                    }
                    life -= 1;
                } else {
                }
                invincible = true;
            }
        }
    }

    public void damageMonster(int i) {

        if (i != 999) {
            if(!gp.monster[i].invincible){
                gp.playSE(6);
                gp.monster[i].life -= 1;
                gp.monster[i].invincible = true;

                if(gp.monster[i].life < 0){
                    gp.monster[i].dying = true;
                }
            }
        } else {
            gp.playSE(7);
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        if (!sprint) {
            switch (direction) {
                case "left":
                    if (!attacking) {
                        if (spriteNum == 1) {
                            image = left1;
                        }
                        if (spriteNum == 2) {
                            image = left2;
                        }
                        if (spriteNum == 3) {
                            image = left3;
                        }
                        if (spriteNum == 4) {
                            image = left4;
                        }
                        if (spriteNum == 5) {
                            image = left5;
                        }
                        if (spriteNum == 6) {
                            image = left6;
                        }
                    } else if (attacking) {
                        if (spriteNum == 1) {
                            image = atkleft1;
                        }
                        if (spriteNum == 2) {
                            image = atkleft2;
                        }
                        if (spriteNum == 3) {
                            image = atkleft3;
                        }
                        if (spriteNum == 4) {
                            image = atkleft4;
                        }
                        if (spriteNum == 5) {
                            image = atkleft5;
                        }
                        if (spriteNum == 6) {
                            image = atkleft6;
                        }
                    }
                    break;


                case "right":
                    if (!attacking) {
                        if (spriteNum == 1) {
                            image = right1;
                        }
                        if (spriteNum == 2) {
                            image = right2;
                        }
                        if (spriteNum == 3) {
                            image = right3;
                        }
                        if (spriteNum == 4) {
                            image = right4;
                        }
                        if (spriteNum == 5) {
                            image = right5;
                        }
                        if (spriteNum == 6) {
                            image = right6;
                        }
                    } else if (attacking) {
                        if (spriteNum == 1) {
                            image = atkright1;
                        }
                        if (spriteNum == 2) {
                            image = atkright2;
                        }
                        if (spriteNum == 3) {
                            image = atkright3;
                        }
                        if (spriteNum == 4) {
                            image = atkright4;
                        }
                        if (spriteNum == 5) {
                            image = atkright5;
                        }
                        if (spriteNum == 6) {
                            image = atkright6;
                        }
                    }
                    break;

                case "down":
                    if (!attacking) {
                        image = right2;
                    } else if (attacking) {
                        if (spriteNum == 1) {
                            image = atkright1;
                        }
                        if (spriteNum == 2) {
                            image = atkright2;
                        }
                        if (spriteNum == 3) {
                            image = atkright3;
                        }
                        if (spriteNum == 4) {
                            image = atkright4;
                        }
                        if (spriteNum == 5) {
                            image = atkright5;
                        }
                        if (spriteNum == 6) {
                            image = atkright6;
                        }
                    }
                    break;

                case "up":
                    if (!attacking) {
                        if (spriteNum == 1) {
                            image = right1;
                        }
                        if (spriteNum == 2) {
                            image = right2;
                        }
                        if (spriteNum == 3) {
                            image = right3;
                        }
                        if (spriteNum == 4) {
                            image = right4;
                        }
                        if (spriteNum == 5) {
                            image = right5;
                        }
                        if (spriteNum == 6) {
                            image = right6;
                        }
                    } else if (attacking) {
                        if (spriteNum == 1) {
                            image = atkleft1;
                        }
                        if (spriteNum == 2) {
                            image = atkleft2;
                        }
                        if (spriteNum == 3) {
                            image = atkleft3;
                        }
                        if (spriteNum == 4) {
                            image = atkleft4;
                        }
                        if (spriteNum == 5) {
                            image = atkleft5;
                        }
                        if (spriteNum == 6) {
                            image = atkleft6;
                        }
                    }

                    break;
            }
        }
        if (sprint) {

            switch (direction) {
                case "left":
                    if (spriteNum == 1) {
                        image = leftrun1;
                    }
                    if (spriteNum == 2) {
                        image = leftrun2;
                    }
                    if (spriteNum == 3) {
                        image = leftrun3;
                    }
                    if (spriteNum == 4) {
                        image = leftrun4;
                    }
                    if (spriteNum == 5) {
                        image = leftrun5;
                    }
                    if (spriteNum == 6) {
                        image = leftrun6;
                    }
                    break;


                case "right":
                    if (spriteNum == 1) {
                        image = rightrun1;
                    }
                    if (spriteNum == 2) {
                        image = rightrun2;
                    }
                    if (spriteNum == 3) {
                        image = rightrun3;
                    }
                    if (spriteNum == 4) {
                        image = rightrun4;
                    }
                    if (spriteNum == 5) {
                        image = rightrun5;
                    }
                    if (spriteNum == 6) {
                        image = rightrun6;
                    }
                    break;

                case "down":
                    image = right2;
                    break;

                case "up":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    }
                    if (spriteNum == 4) {
                        image = right4;
                    }
                    if (spriteNum == 5) {
                        image = right5;
                    }
                    if (spriteNum == 6) {
                        image = right6;
                    }
                    break;
            }

        }

        if (invincible) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3F));
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

        //RESET ALPHA
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1F));

        if (gp.keyH.checkDrawTime) {

            // 1. Draw the Player's standard Solid Area (Red Box)
            g2.setColor(Color.red);
            g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);

            if (attacking) {

                int tempScreenX = screenX;
                int tempScreenY = screenY;
                int atkX = 0;
                int atkY = 0;

                // Attack hitbox dimensions are fixed (48x48)
                int atkWidth = attackArea.width;
                int atkHeight = attackArea.height;

                // --- CALCULATE ATTACK AREA DRAWING POSITION ---

                // This logic determines where the attack area starts relative
                // to the player's screen position (screenX, screenY) based on
                // the player's direction and the attackArea offset (-5, 30).

                switch (direction) {
                    case "up":
                        // Start X is adjusted by the offset X (-5)
                        atkX = screenX + attackArea.x;
                        // Start Y is adjusted by the offset Y (30), MINUS the height of the attack box (48)
                        // This moves the box up by 48, but starts the drawing at the offset Y (30) from the sprite origin.
                        atkY = screenY + attackArea.y - atkHeight;
                        break;

                    case "down":

                        atkX = screenX + attackArea.x;

                        // Start Y position is set to the bottom edge of the player's tile.
                        // This prevents the attack box from overlapping the player.
                        atkY = screenY + gp.tileSize;
                        break;

                    case "left":
                        // Start X is adjusted by the offset X (-5), MINUS the width of the attack box (48)
                        // This places the box to the left, starting at X=-5 from the sprite origin.
                        atkX = screenX + attackArea.x - atkWidth;
                        // Start Y is adjusted by the offset Y (30)
                        atkY = screenY + attackArea.y;
                        break;

                    case "right":
                        atkX = screenX + attackArea.x + gp.tileSize;
                        atkY = screenY + attackArea.y;
                        break;
                }

                // Draw the actual attack box (Green)
                g2.setColor(new Color(0, 255, 0, 150));
                g2.fillRect(atkX, atkY, atkWidth, atkHeight);

                // Draw the outline of the attack box
                g2.setColor(Color.GREEN);
                g2.drawRect(atkX, atkY, atkWidth, atkHeight);
            }
        }
    }
}