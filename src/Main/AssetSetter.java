package Main;

import Entity.Prisoner1_NPC;
import Monster.MON_Ghost;
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

        gp.obj[1] = new objOrb(gp);
        gp.obj[1].worldX = gp.tileSize * 2;
        gp.obj[1].worldY = gp.tileSize * 43;

        gp.obj[2] = new objOrb(gp);
        gp.obj[2].worldX = gp.tileSize * 3;
        gp.obj[2].worldY = gp.tileSize * 43;



    }

    public void setNPC() {

        gp.npc[0] = new Prisoner1_NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 46;
        gp.npc[0].worldY = gp.tileSize * 45;

    }

    public void setMonster() {

        gp.monster[0] = new MON_Ghost(gp);
        gp.monster[0].worldX = gp.tileSize * 30;
        gp.monster[0].worldY = gp.tileSize * 39;

        gp.monster[1] = new MON_Ghost(gp);
        gp.monster[1].worldX = gp.tileSize * 30;
        gp.monster[1].worldY = gp.tileSize * 38;

    }
}
