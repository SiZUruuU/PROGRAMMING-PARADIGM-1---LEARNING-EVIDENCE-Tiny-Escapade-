package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objHealthBar extends SuperObject{

    GamePanel gp;

    public objHealthBar(GamePanel gp) {
        this.gp = gp;

        name = "HealthBar";

        try{
            image1 = ImageIO.read(getClass().getResourceAsStream("/hp/1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/hp/2.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/hp/3.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/hp/4.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/hp/5.png"));
            image1 = uTool.scaleImage(image1, gp.tileSize * 4, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize * 4, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize * 4, gp.tileSize);
            image4 = uTool.scaleImage(image4, gp.tileSize * 4, gp.tileSize);
            image5 = uTool.scaleImage(image5, gp.tileSize * 4, gp.tileSize);

        }catch(IOException e){

            e.printStackTrace();
        }
    }
}
