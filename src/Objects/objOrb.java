package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objOrb extends SuperObject{

    GamePanel gp;

    public objOrb(GamePanel gp){

        this.gp = gp;

        name = "Orb";

        try{

            image = ImageIO.read(getClass().getResourceAsStream("/orb/1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }catch(IOException e){

            e.printStackTrace();
        }

    }
}
