package Main;

import Objects.objDoor;
import Objects.objKey;

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

    }
}
