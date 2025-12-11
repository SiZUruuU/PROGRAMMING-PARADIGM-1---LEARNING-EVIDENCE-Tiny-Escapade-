package Tile;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){

        this.gp = gp;

        tile = new Tile[19];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {

            setUp(0, "grasses3", false);
            setUp(1, "grasses11", false);
            setUp(2, "grasses4", false);
            setUp(3, "grasses5", false);
            setUp(4, "grasses6", false);
            setUp(5, "grasses7", false);
            setUp(6, "grasses9", false);
            setUp(7, "grasses10", false);
            setUp(8, "grasses2", false);
            setUp(9, "grasses12", false);
            setUp(10, "grasses13", false);
            setUp(11, "grasses14", false);
            setUp(12, "grasses15", false);
            setUp(13, "grasses19", false);
            setUp(14, "grasses20", false);
            setUp(15, "grasses21", false);
            setUp(16, "grasses22", false);
            setUp(17, "tree", true);
            setUp(18, "dark tree", true);

//              setUp(1, "14", false);
//              setUp(2, "2", false);
//              setUp(3, "3", false);
//              setUp(4, "4", true);
//              setUp(5, "5", true);
//              setUp(6, "14", false);
//              setUp(7, "2", false);
//              setUp(8, "3", false);
//              setUp(9, "4", true);
//              setUp(10, "5", true);



    }
    public void setUp(int index, String imageName, boolean collision){

        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }catch(IOException e){
            e.printStackTrace();

        }

    }

    public void loadMap() {

        try{

            InputStream is = getClass().getResourceAsStream("/maps/worldmap1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
;

        }catch(Exception e){}
    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldCol) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX =  worldX - gp.player.worldX + gp.player.screenX;
            int screenY =  worldY - gp.player.worldY + gp.player.screenY;

//            System.out.println(tileNum + " ");

            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            if(tile[tileNum].collision) {
                g2.setColor(Color.RED);
                g2.drawRect(screenX, screenY, gp.tileSize, gp.tileSize);
            }

            worldCol++;

                if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
