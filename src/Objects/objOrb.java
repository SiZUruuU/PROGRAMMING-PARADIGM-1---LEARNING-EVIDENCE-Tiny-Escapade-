package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objOrb extends Entity {

    public objOrb(GamePanel gp){
        super(gp);

        name = "Orb";
        down1 = setUp("/orb/orb");


    }
}
