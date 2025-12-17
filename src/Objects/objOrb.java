package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objOrb extends Entity {

    public objOrb(GamePanel gp){
        super(gp);

        name = "Orb";             
        // Used for pickup logic (orb counter)
        down1 = setUp("/orb/orb"); 
        // Load the orb sprite
    }
}
