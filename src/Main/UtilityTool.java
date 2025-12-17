package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UtilityTool {

    public BufferedImage scaleImage(BufferedImage original, int width, int height){

        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); 
        // New empty image at target size
        Graphics2D g2 = scaledImage.createGraphics();                                             
        // Graphics context for drawing
        g2.drawImage(original, 0,0, width, height, null);                                          
        // Draw original, stretched to fit
        g2.dispose();                                                                              
        // Clean up graphics resources

        return scaledImage;                                                                        
        // Return the resized image

    }
}
