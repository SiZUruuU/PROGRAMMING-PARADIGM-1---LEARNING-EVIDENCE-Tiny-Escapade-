package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objOrb extends Entity {

    public objOrb(GamePanel gp){
        super(gp);

        direction = "still";
        name = "Orb";
        still = setUp("/orb/orb");
    }
}
