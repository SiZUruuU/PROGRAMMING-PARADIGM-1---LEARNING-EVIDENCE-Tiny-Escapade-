package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objHealingWisp extends Entity {


    public objHealingWisp(GamePanel gp) {
        super(gp);

        name = "Wisp";
        down1 = setUp("/healing wis/0");
        down2 = setUp("/healing wis/1");
        collision = false;

        solidArea.x = 18;
        solidArea.y = 26;
        solidArea.width = 3;
        solidArea.height = 3;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
