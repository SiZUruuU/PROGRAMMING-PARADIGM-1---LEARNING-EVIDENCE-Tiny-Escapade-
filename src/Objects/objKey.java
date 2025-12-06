package Objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class objKey extends SuperObject{

    GamePanel gp;

        public objKey(GamePanel gp) {
            this.gp = gp;

            name = "Key";

            try{
                image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
                uTool.scaleImage(image, gp.tileSize, gp.tileSize);

            }catch(IOException e){

                e.printStackTrace();
            }
        }
}
