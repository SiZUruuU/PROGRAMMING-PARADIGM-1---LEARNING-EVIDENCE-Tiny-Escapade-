package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class objStaminaBar extends SuperObject{

    GamePanel gp;

    public objStaminaBar(GamePanel gp) {
        this.gp = gp;

        name = "Key";

        try{
            image1 = ImageIO.read(getClass().getResourceAsStream("/hp/energy bar 1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/hp/energy bar 2.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/hp/energy bar 3.png"));
            image1 = uTool.scaleImage(image1, gp.tileSize * 3, (gp.tileSize / 2) + 10);
            image2 = uTool.scaleImage(image2, gp.tileSize * 3, (gp.tileSize / 2) + 10);
            image3 = uTool.scaleImage(image3, gp.tileSize * 3, (gp.tileSize / 2) + 10);

        }catch(IOException e){

            e.printStackTrace();
        }
    }
}
