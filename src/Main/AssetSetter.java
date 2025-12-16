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
        gp.obj[1].worldY = gp.tileSize * 41;

        gp.obj[2] = new objOrb(gp);
        gp.obj[2].worldX = gp.tileSize * 3;
        gp.obj[2].worldY = gp.tileSize * 41;

        gp.obj[3] = new objOrb(gp);
        gp.obj[3].worldX = gp.tileSize * 4;
        gp.obj[3].worldY = gp.tileSize * 41;

        gp.obj[4] = new objOrb(gp);
        gp.obj[4].worldX = gp.tileSize * 5;
        gp.obj[4].worldY = gp.tileSize * 41;

        gp.obj[5] = new objOrb(gp);
        gp.obj[5].worldX = gp.tileSize * 6;
        gp.obj[5].worldY = gp.tileSize * 41;

        gp.obj[6] = new objOrb(gp);
        gp.obj[6].worldX = gp.tileSize * 7;
        gp.obj[6].worldY = gp.tileSize * 41;

        gp.obj[7] = new objOrb(gp);
        gp.obj[7].worldX = gp.tileSize * 3;
        gp.obj[7].worldY = gp.tileSize * 41;

        gp.obj[8] = new objKey(gp);
        gp.obj[8].worldX = gp.tileSize * 5;
        gp.obj[8].worldY = gp.tileSize * 43;

        gp.obj[9] = new objOrb(gp);
        gp.obj[9].worldX = gp.tileSize * 3;
        gp.obj[9].worldY = gp.tileSize * 28;

        gp.obj[10] = new objOrb(gp);
        gp.obj[10].worldX = gp.tileSize * 9;
        gp.obj[10].worldY = gp.tileSize * 27;

        gp.obj[11] = new objOrb(gp);
        gp.obj[11].worldX = 6;
        gp.obj[11].worldY = gp.tileSize * 26;

        gp.obj[12] = new objOrb(gp);
        gp.obj[12].worldX = 6;
        gp.obj[12].worldY = gp.tileSize * 27;

        gp.obj[13] = new objOrb(gp);
        gp.obj[13].worldX = 6;
        gp.obj[13].worldY = gp.tileSize * 28;

        gp.obj[14] = new objOrb(gp);
        gp.obj[14].worldX = 6;
        gp.obj[14].worldY = gp.tileSize * 29;

        gp.obj[15] = new objOrb(gp);
        gp.obj[15].worldX = gp.tileSize * 5 - 10;
        gp.obj[15].worldY = gp.tileSize * 26;

        gp.obj[16] = new objOrb(gp);
        gp.obj[16].worldX = gp.tileSize * 5 - 10;
        gp.obj[16].worldY = gp.tileSize * 27;

        gp.obj[17] = new objOrb(gp);
        gp.obj[17].worldX = gp.tileSize * 5 - 10;
        gp.obj[17].worldY = gp.tileSize * 28;

        gp.obj[18] = new objOrb(gp);
        gp.obj[18].worldX = gp.tileSize * 5 - 10;
        gp.obj[18].worldY = gp.tileSize * 29;


    }

    public void setNPC() {

        gp.npc[0] = new Prisoner1_NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 46;
        gp.npc[0].worldY = gp.tileSize * 45;

    }

    public void setMonster() {

        gp.monster[0] = new MON_Ghost(gp);
        gp.monster[0].worldX = gp.tileSize * 30;
        gp.monster[0].worldY = gp.tileSize * 36;

        gp.monster[1] = new MON_Ghost(gp);
        gp.monster[1].worldX = gp.tileSize * 30;
        gp.monster[1].worldY = gp.tileSize * 38;

    }
}
