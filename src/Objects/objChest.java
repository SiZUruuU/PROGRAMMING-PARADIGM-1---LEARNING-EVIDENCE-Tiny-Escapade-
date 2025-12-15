package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objChest extends Entity {

    public objChest(GamePanel gp){
        super(gp);

        name = "Chest";
        down1 = setUp("/objects/chest");
        collision = true;
    }
}
