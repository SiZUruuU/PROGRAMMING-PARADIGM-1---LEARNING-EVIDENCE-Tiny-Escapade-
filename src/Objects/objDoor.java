package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objDoor extends SuperObject{

    public objDoor() {

        name = "Door";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));

        }catch(IOException e){

            e.printStackTrace();
        }
    }
}
