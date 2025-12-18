package Monster;

import Entity.Entity;
import Main.GamePanel;

import java.util.Random;

public class MON_Ghost extends Entity {

    public MON_Ghost(GamePanel gp) {
        super(gp);

        type = 2;

        name = "Ghost";
        normalSpeed = 1;
        maxLife = 3;
        life = maxLife;

        //Collision Box of Ghost
        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 40;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {

        //Imports Ghost Images

        left1 = setUp("/Ghost/left");
        right1 = setUp("/Ghost/right");
        up1 = setUp("/Ghost/left");
        down1 = setUp("/Ghost/right");
    }

    public void setAction(){

        //Sets random npc path

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }

            actionLockCounter = 0;
        }

    }
}
