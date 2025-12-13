package Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public BufferedImage image;
    public boolean collision = false;

    public Rectangle solidArea = new Rectangle(0, 0, 16, 16);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public boolean front = false;
}
