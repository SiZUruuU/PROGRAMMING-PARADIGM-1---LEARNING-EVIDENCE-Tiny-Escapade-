package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objChest extends SuperObject{

    GamePanel gp;

    public objChest(GamePanel gp){
        this.gp = gp;

        name = "Chest";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }catch(IOException e){

            e.printStackTrace();
        }
        collision = true;
    }
}
