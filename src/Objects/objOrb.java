package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objOrb extends SuperObject{

    public objOrb(){

        name = "Orb";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/orb/1.png"));
        }catch(IOException e){

            e.printStackTrace();
        }

    }
}
