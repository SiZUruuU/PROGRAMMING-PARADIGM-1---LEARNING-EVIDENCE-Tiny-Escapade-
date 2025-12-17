package Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public BufferedImage image;                
    // Tile sprite
    public boolean collision = false;         
    // True if this tile blocks movement

    public Rectangle solidArea = new Rectangle(0, 0, 16, 16); // Precise collision box
    public int solidAreaDefaultX = 0;        
    // Default X offset for resetting
    public int solidAreaDefaultY = 0;        
    // Default Y offset for resetting

    public boolean front = false;           
    // If true, drawn in front of entities
}
