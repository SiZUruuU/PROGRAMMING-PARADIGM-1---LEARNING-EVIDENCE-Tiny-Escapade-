package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objDoor extends Entity {


    public objDoor(GamePanel gp) {
        super(gp);

        name = "Door";                    
        // Used to identify this object in game logic
        down1 = setUp("/objects/door");   
        // Load the door sprite
        collision = true;                 
        // Make the door non‑walkable

        // Define the door's collision area (only lower part is solid)
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
