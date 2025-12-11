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

        tile = new Tile[100];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {

//            setUp(0, "grasses3", false);
//            setUp(1, "grasses11", false);
//            setUp(2, "grasses4", false);
//            setUp(3, "grasses5", false);
//            setUp(4, "grasses6", false);
//            setUp(5, "grasses7", false);
//            setUp(6, "grasses9", false);
//            setUp(7, "grasses10", false);
//            setUp(8, "grasses2", false);
//            setUp(9, "grasses12", false);
//            setUp(10, "grasses13", false);
//            setUp(11, "grasses14", false);
//            setUp(12, "grasses15", false);
//            setUp(13, "grasses19", false);
//            setUp(14, "grasses20", false);
//            setUp(15, "grasses21", false);
//            setUp(16, "grasses22", false);
//            setUp(17, "tree", true);
//            setUp(18, "dark tree", true);

        setUp(0, "80", false);
        setUp(1, "1", true);
        setUp(2, "2", true);
        setUp(3, "3", true);
        setUp(4, "4", true);
        setUp(5, "5", true);
        setUp(6, "6", true);
        setUp(7, "7", true);
        setUp(8, "8", true);
        setUp(9, "9", true);
        setUp(10, "10", true);
        setUp(11, "11", true);
        setUp(12, "12", true);
        setUp(13, "13", true);
        setUp(14, "14", true);
        setUp(15, "15", true);
        setUp(16, "16", true);
        setUp(17, "17", true);
        setUp(18, "18", true);
        setUp(19, "19", true);
        setUp(20, "20", true);
        setUp(21, "21", true);
        setUp(22, "22", false);
        setUp(23, "23", false);
        setUp(24, "24", true);
        setUp(25, "25", true);
        setUp(26, "26", false);
        setUp(27, "27", false);
        setUp(28, "28", true);
        setUp(29, "29", true);
        setUp(30, "30", true);
        setUp(31, "31", true);
        setUp(32, "32", false);
        setUp(33, "33", false);
        setUp(34, "34", true);
        setUp(35, "35", true);
        setUp(36, "36", false);
        setUp(37, "37", false);
        setUp(38, "38", true);
        setUp(39, "39", true);
        setUp(40, "40", true);
        setUp(41, "41", true);
        setUp(42, "42", true);
        setUp(43, "43", true);
        setUp(44, "44", true);
        setUp(45, "45", true);
        setUp(46, "46", true);
        setUp(47, "47", true);
        setUp(48, "48", true);
        setUp(49, "49", true);
        setUp(50, "50", true);
        setUp(51, "51", true);
        setUp(52, "52", true);
        setUp(53, "53", true);
        setUp(54, "54", true);
        setUp(55, "55", true);
        setUp(56, "56", true);
        setUp(57, "57", true);
        setUp(58, "58", true);
        setUp(59, "59", true);
        setUp(60, "60", true);
        setUp(61, "61", false);
        setUp(62, "62", false);
        setUp(63, "63", false);
        setUp(64, "64", false);
        setUp(65, "65", true);
        setUp(66, "66", false);
        setUp(67, "67", false);
        setUp(68, "68", true);
        setUp(69, "69", true);
        setUp(70, "70", false);
        setUp(71, "71", false);
        setUp(72, "72", false);
        setUp(73, "73", false);
        setUp(74, "74", false);
        setUp(75, "75", true);
        setUp(76, "76", true);
        setUp(77, "77", true);
        setUp(78, "78", true);
        setUp(79, "79", true);




    }
    public void setUp(int index, String imageName, boolean collision){

        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/newtiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }catch(IOException e){
            e.printStackTrace();

        }

    }

    public void loadMap() {

        try{

            InputStream is = getClass().getResourceAsStream("/maps/newmap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){

                    String numbers[] = line.split(",");

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
