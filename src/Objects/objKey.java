package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import Entity.Entity;

public class objKey extends Entity{

        public objKey(GamePanel gp) {
            super(gp);

            name = "Key";                 
                // Used to detect key pickups
            down1 = setUp("/objects/key");
                // Load key sprite
        }
}
