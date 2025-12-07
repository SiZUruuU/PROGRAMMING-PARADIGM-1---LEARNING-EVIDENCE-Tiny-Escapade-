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


    }

    public void setNPC() {

        gp.npc[0] = new Prisoner1_NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;
    }
}
