package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class objKey extends SuperObject{

        public objKey() {

            name = "Key";

            try{
                image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));

            }catch(IOException e){

                e.printStackTrace();
            }
        }
}
