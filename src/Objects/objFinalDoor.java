package Objects;

import Entity.Entity;
import Main.GamePanel;

public class objFinalDoor extends Entity {


    public objFinalDoor(GamePanel gp) {
        super(gp);

        name = "Final Door";
        down1 = setUp("/objects/door");
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
