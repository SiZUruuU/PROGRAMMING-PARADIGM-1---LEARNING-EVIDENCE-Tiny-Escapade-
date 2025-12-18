package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import Entity.Entity;

public class objKey extends Entity{

        public objKey(GamePanel gp) {
            super(gp);

            direction = "still";

            name = "Key";
            still = setUp("/objects/key");

        }
}
