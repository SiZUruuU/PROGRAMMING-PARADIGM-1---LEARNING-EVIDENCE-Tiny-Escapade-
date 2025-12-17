package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class objStaminaBar extends Entity {

    public objStaminaBar(GamePanel gp) {
        super(gp);

        name = "StaminaBar";                            
        // Identifier used by the UI
        int width = gp.tileSize * 3 + 8;               
        // Bar width
        int height = gp.tileSize / 2 + 10;             
        // Bar height

        // Three visual states for high, medium, and empty stamina
        image1 = setUp("/hp/energy bar 1", width, height);
        image2 = setUp("/hp/energy bar 2", width, height);
        image3 = setUp("/hp/energy bar 3", width, height);

    }
}
