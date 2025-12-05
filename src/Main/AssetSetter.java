package Main;

import Objects.objChest;
import Objects.objDoor;
import Objects.objKey;
import Objects.objOrb;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){

        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new objKey();
        gp.obj[0].worldX = 25 * gp.tileSize;
        gp.obj[0].worldY = 20 * gp.tileSize;

        gp.obj[1] = new objKey();
        gp.obj[1].worldX = 25 * gp.tileSize;
        gp.obj[1].worldY = 30 * gp.tileSize;

        gp.obj[2] = new objKey();
        gp.obj[2].worldX = 25 * gp.tileSize;
        gp.obj[2].worldY = 13 * gp.tileSize;

        gp.obj[3] = new objDoor();
        gp.obj[3].worldX = 25 * gp.tileSize;
        gp.obj[3].worldY = 16 * gp.tileSize;

        gp.obj[4] = new objOrb();
        gp.obj[4].worldX = 19 * gp.tileSize;
        gp.obj[4].worldY = 15 * gp.tileSize;

        gp.obj[5] = new objOrb();
        gp.obj[5].worldX = 22 * gp.tileSize;
        gp.obj[5].worldY = 15 * gp.tileSize;

        gp.obj[6] = new objOrb();
        gp.obj[6].worldX = 21 * gp.tileSize;
        gp.obj[6].worldY = 15 * gp.tileSize;

        gp.obj[7] = new objOrb();
        gp.obj[7].worldX = 20 * gp.tileSize;
        gp.obj[7].worldY = 15 * gp.tileSize;

        gp.obj[8] = new objChest();
        gp.obj[8].worldX = 28 * gp.tileSize;
        gp.obj[8].worldY = 15 * gp.tileSize;


    }
}
