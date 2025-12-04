package Main;

import java.awt.*;

public class UI {

    GamePanel gp;

    public UI(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2){

        g2.setFont(new Font("Arial", Font.PLAIN, 20 ));
    }
}
