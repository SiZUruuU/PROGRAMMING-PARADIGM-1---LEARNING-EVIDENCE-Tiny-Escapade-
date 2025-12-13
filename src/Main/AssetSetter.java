package Main;

import Entity.Prisoner1_NPC;
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

        gp.obj[0] = new objDoor(gp);
        gp.obj[0].worldX = gp.tileSize * 22;
        gp.obj[0].worldY = gp.tileSize * 33;

    }

    public void setNPC() {

        gp.npc[0] = new Prisoner1_NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 46;
        gp.npc[0].worldY = gp.tileSize * 45;

    }
}
