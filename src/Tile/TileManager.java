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

        setUp(0, "80", false, 0, 0, 16, 16);
        setUp(1, "1", true,0, 0, 48, 48);
        setUp(2, "2", true,0, 0, 48, 48);
        setUp(3, "3", true,0, 0, 48, 48);
        setUp(4, "4", true,0, 0, 48, 48);
        setUp(5, "5", true,0, 0, 16, 16);
        setUp(6, "6", true,0, 0, 16, 16);
        setUp(7, "7", true,0, 0, 16, 16);
        setUp(8, "8", true,0, 0, 16, 16);
        setUp(9, "9", true,0, 0, 16, 16);
        setUp(10, "10", true,0, 0, 16, 16);
        setUp(11, "11", true,0, 0, 48, 48);
        setUp(12, "12", true,0, 0, 48, 48);
        setUp(13, "13", true,0, 0, 48, 48);
        setUp(14, "14", true,0, 0, 16, 16);
        setUp(15, "15", true,0, 0, 16, 16);
        setUp(16, "16", true,0, 0, 16, 16);
        setUp(17, "17", true,0, 0, 16, 16);
        setUp(18, "18", true,0, 0, 16, 16);
        setUp(19, "19", true,0, 0, 16, 16);
        setUp(20, "20", true,0, 0, 16, 16);
        setUp(21, "21", true,0, 0, 16, 48);
        setUp(22, "22", false,0, 0, 16, 16);
        setUp(23, "23", false,0, 0, 16, 16);
        setUp(24, "24", true,0, 0, 16, 16);
        setUp(25, "25", true,0, 0, 16, 16);
        setUp(26, "26", false,0, 0, 16, 16);
        setUp(27, "27", false,0, 0, 16, 16);
        setUp(28, "28", true,0, 0, 16, 16);
        setUp(29, "29", true,0, 0, 16, 16);
        setUp(30, "30", true,0, 0, 16, 16);
        setUp(31, "31", true,0, 0, 16, 16);
        setUp(32, "32", false,0, 0, 16, 16);
        setUp(33, "33", false,0, 0, 16, 16);
        setUp(34, "34", true,0, 0, 16, 16);
        setUp(35, "35", true,0, 0, 16, 16);
        setUp(36, "36", false,0, 0, 16, 16);
        setUp(37, "37", false,0, 0, 16, 16);
        setUp(38, "38", true,0, 0, 16, 16);
        setUp(39, "39", true,0, 0, 16, 16);
        setUp(40, "40", true,0, 0, 16, 16);
        setUp(41, "41", true,0, 0, 16, 16);
        setUp(42, "42", true,0, 0, 16, 16);
        setUp(43, "43", true,0, 0, 16, 16);
        setUp(44, "44", true,0, 0, 16, 16);
        setUp(45, "45", true,0, 0, 16, 16);
        setUp(46, "46", true,0, 0, 16, 16);
        setUp(47, "47", true,0, 0, 16, 16);
        setUp(48, "48", true,0, 0, 16, 16);
        setUp(49, "49", true,0, 0, 16, 16);
        setUp(50, "50", true,0, 0, 16, 16);
        setUp(51, "51", true,0, 0, 16, 16);
        setUp(52, "52", true,0, 0, 16, 16);
        setUp(53, "53", true,0, 0, 16, 16);
        setUp(54, "54", true,0, 0, 16, 16);
        setUp(55, "55", true,0, 0, 16, 16);
        setUp(56, "56", true,0, 0, 16, 16);
        setUp(57, "57", true,0, 0, 16, 16);
        setUp(58, "58", true,0, 0, 16, 16);
        setUp(59, "59", true,0, 0, 16, 16);
        setUp(60, "60", true,0, 0, 16, 16);
        setUp(61, "61", false,0, 0, 16, 16);
        setUp(62, "62", false,0, 0, 16, 16);
        setUp(63, "63", false,0, 0, 16, 16);
        setUp(64, "64", false,0, 0, 16, 16);
        setUp(65, "65", true,0, 0, 16, 16);
        setUp(66, "66", false,0, 0, 16, 16);
        setUp(67, "67", false,0, 0, 16, 16);
        setUp(68, "68", true,0, 0, 16, 16);
        setUp(69, "69", true,0, 0, 16, 16);
        setUp(70, "70", false,0, 0, 16, 16);
        setUp(71, "71", false,0, 0, 16, 16);
        setUp(72, "72", false,0, 0, 16, 16);
        setUp(73, "73", false,0, 0, 16, 16);
        setUp(74, "74", false,0, 0, 16, 16);
        setUp(75, "75", true,0, 0, 16, 16);
        setUp(76, "76", true,0, 0, 16, 16);
        setUp(77, "77", true,0, 0, 16, 16);
        setUp(78, "78", true,0, 0, 16, 16);
        setUp(79, "79", true,0, 0, 16, 16);




    }
    public void setUp(int index, String imageName, boolean collision, int x, int y, int width, int height){

        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/newtiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

            tile[index].solidArea.x = x;
            tile[index].solidArea.y = y;
            tile[index].solidArea.width = width;
            tile[index].solidArea.height = height;

            // Save default values for resetting later (important for doors/interactions)
            tile[index].solidAreaDefaultX = x;
            tile[index].solidAreaDefaultY = y;

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
                g2.drawRect(screenX + tile[tileNum].solidArea.x,
                        screenY + tile[tileNum].solidArea.y,
                        tile[tileNum].solidArea.width,
                        tile[tileNum].solidArea.height);
            }

            worldCol++;

                if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
