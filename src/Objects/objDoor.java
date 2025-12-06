package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objDoor extends SuperObject{

    GamePanel gp;

    public objDoor(GamePanel gp) {

        this.gp = gp;

        name = "Door";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }catch(IOException e){

            e.printStackTrace();
        }
        collision = true;
    }
}
