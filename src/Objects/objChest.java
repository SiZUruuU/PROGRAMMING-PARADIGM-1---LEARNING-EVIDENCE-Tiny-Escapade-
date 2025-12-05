package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objChest extends SuperObject{

    public objChest(){

        name = "Chest";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));

        }catch(IOException e){

            e.printStackTrace();
        }
        collision = true;
    }
}
