package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objHealthBar extends Entity {

    public objHealthBar(GamePanel gp) {
        super(gp);

        name = "HealthBar";
        int width = gp.tileSize * 3 + 8;
        int height = gp.tileSize;

        image1 = setUp("/hp/1", width, height);
        image2 = setUp("/hp/2", width, height);
        image3 = setUp("/hp/3", width, height);
        image4 = setUp("/hp/4", width, height);
        image5 = setUp("/hp/5", width, height);

    }
}
