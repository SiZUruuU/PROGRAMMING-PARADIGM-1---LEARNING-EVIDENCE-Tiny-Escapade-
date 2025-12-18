package Main;

import Entity.KeyHolder_NPC;
import Entity.Prisoner1_NPC;
import Entity.Room_NPC;
import Monster.MON_Ghost;
import Objects.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){

        this.gp = gp;
    }

    public void setObject(){

        //Creates Object in Game

        gp.obj[0] = new objFinalDoor(gp);
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

        gp.obj[19] = new objOrb(gp);
        gp.obj[19].worldX = gp.tileSize * 5 - 10;
        gp.obj[19].worldY = gp.tileSize * 30;

        gp.obj[20] = new objOrb(gp);
        gp.obj[20].worldX = gp.tileSize * 7 - 10;
        gp.obj[20].worldY = gp.tileSize * 36;

        gp.obj[21] = new objOrb(gp);
        gp.obj[21].worldX = gp.tileSize * 13 - 10;
        gp.obj[21].worldY = gp.tileSize * 38;

        gp.obj[22] = new objOrb(gp);
        gp.obj[22].worldX = gp.tileSize * 11 - 10;
        gp.obj[22].worldY = gp.tileSize * 37;

        gp.obj[23] = new objOrb(gp);
        gp.obj[23].worldX = gp.tileSize * 5 - 10;
        gp.obj[23].worldY = gp.tileSize * 11;

        gp.obj[24] = new objOrb(gp);
        gp.obj[24].worldX = gp.tileSize * 5 - 10;
        gp.obj[24].worldY = gp.tileSize * 17;

        gp.obj[25] = new objDoor(gp);
        gp.obj[25].worldX = gp.tileSize * 4;
        gp.obj[25].worldY = gp.tileSize * 30;

        gp.obj[27] = new objOrb(gp);
        gp.obj[27].worldX = gp.tileSize * 30 - 10;
        gp.obj[27].worldY = gp.tileSize * 15;

        gp.obj[28] = new objOrb(gp);
        gp.obj[28].worldX = gp.tileSize * 31 - 10;
        gp.obj[28].worldY = gp.tileSize * 15;

        gp.obj[29] = new objOrb(gp);
        gp.obj[29].worldX = gp.tileSize * 32 - 10;
        gp.obj[29].worldY = gp.tileSize * 15;

        gp.obj[30] = new objOrb(gp);
        gp.obj[30].worldX = gp.tileSize * 33 - 10;
        gp.obj[30].worldY = gp.tileSize * 15;

        gp.obj[31] = new objOrb(gp);
        gp.obj[31].worldX = gp.tileSize * 34 - 10;
        gp.obj[31].worldY = gp.tileSize * 15;

        gp.obj[32] = new objOrb(gp);
        gp.obj[32].worldX = gp.tileSize * 35 - 10;
        gp.obj[32].worldY = gp.tileSize * 15;

        gp.obj[33] = new objOrb(gp);
        gp.obj[33].worldX = gp.tileSize * 30 - 10;
        gp.obj[33].worldY = gp.tileSize * 15;

        gp.obj[34] = new objOrb(gp);
        gp.obj[34].worldX = gp.tileSize * 31 - 10;
        gp.obj[34].worldY = gp.tileSize * 30;

        gp.obj[35] = new objOrb(gp);
        gp.obj[35].worldX = gp.tileSize * 32 - 10;
        gp.obj[35].worldY = gp.tileSize * 31;

        gp.obj[36] = new objOrb(gp);
        gp.obj[36].worldX = gp.tileSize * 33 - 10;
        gp.obj[36].worldY = gp.tileSize * 31;

        gp.obj[37] = new objOrb(gp);
        gp.obj[37].worldX = gp.tileSize * 34 - 10;
        gp.obj[37].worldY = gp.tileSize * 31;

        gp.obj[38] = new objOrb(gp);
        gp.obj[38].worldX = gp.tileSize * 35 - 10;
        gp.obj[38].worldY = gp.tileSize * 31;

        gp.obj[39] = new objOrb(gp);
        gp.obj[39].worldX = gp.tileSize * 30 - 10;
        gp.obj[39].worldY = gp.tileSize * 15;

        gp.obj[40] = new objOrb(gp);
        gp.obj[40].worldX = gp.tileSize * 31 - 10;
        gp.obj[40].worldY = gp.tileSize * 30;

        gp.obj[41] = new objOrb(gp);
        gp.obj[41].worldX = gp.tileSize * 32 - 10;
        gp.obj[41].worldY = gp.tileSize * 31;

        gp.obj[42] = new objOrb(gp);
        gp.obj[42].worldX = gp.tileSize * 33 - 10;
        gp.obj[42].worldY = gp.tileSize * 31;

        gp.obj[43] = new objOrb(gp);
        gp.obj[43].worldX = gp.tileSize * 34 - 10;
        gp.obj[43].worldY = gp.tileSize * 31;

        gp.obj[44] = new objOrb(gp);
        gp.obj[44].worldX = gp.tileSize * 35 - 10;
        gp.obj[44].worldY = gp.tileSize * 31;

        gp.obj[45] = new objOrb(gp);
        gp.obj[45].worldX = gp.tileSize * 33 - 10;
        gp.obj[45].worldY = gp.tileSize * 43;

        gp.obj[46] = new objOrb(gp);
        gp.obj[46].worldX = gp.tileSize * 34 - 10;
        gp.obj[46].worldY = gp.tileSize * 43;

        gp.obj[47] = new objOrb(gp);
        gp.obj[47].worldX = gp.tileSize * 35 - 10;
        gp.obj[47].worldY = gp.tileSize * 43;

        gp.obj[48] = new objOrb(gp);
        gp.obj[48].worldX = gp.tileSize * 34 - 10;
        gp.obj[48].worldY = gp.tileSize * 47;

        gp.obj[49] = new objOrb(gp);
        gp.obj[49].worldX = gp.tileSize * 35 - 10;
        gp.obj[49].worldY = gp.tileSize * 47;

        gp.obj[50] = new objOrb(gp);
        gp.obj[50].worldX = gp.tileSize * 33 - 10;
        gp.obj[50].worldY = gp.tileSize * 47;

        gp.obj[51] = new objOrb(gp);
        gp.obj[51].worldX = gp.tileSize * 34 - 10;
        gp.obj[51].worldY = gp.tileSize * 47;

        gp.obj[52] = new objOrb(gp);
        gp.obj[52].worldX = gp.tileSize * 35 - 10;
        gp.obj[52].worldY = gp.tileSize * 47;

        gp.obj[53] = new objOrb(gp);
        gp.obj[53].worldX = gp.tileSize * 33 - 10;
        gp.obj[53].worldY = gp.tileSize * 42;

        gp.obj[54] = new objOrb(gp);
        gp.obj[54].worldX = gp.tileSize * 34 - 10;
        gp.obj[54].worldY = gp.tileSize * 42;

        gp.obj[55] = new objOrb(gp);
        gp.obj[55].worldX = gp.tileSize * 35 - 10;
        gp.obj[55].worldY = gp.tileSize * 42;

        gp.obj[56] = new objOrb(gp);
        gp.obj[56].worldX = gp.tileSize * 33 - 10;
        gp.obj[56].worldY = gp.tileSize * 5;

        gp.obj[57] = new objOrb(gp);
        gp.obj[57].worldX = gp.tileSize * 34 - 10;
        gp.obj[57].worldY = gp.tileSize * 5;

        gp.obj[58] = new objOrb(gp);
        gp.obj[58].worldX = gp.tileSize * 35 - 10;
        gp.obj[58].worldY = gp.tileSize * 5;

        gp.obj[58] = new objKey(gp);
        gp.obj[58].worldX = gp.tileSize * 4;
        gp.obj[58].worldY = gp.tileSize * 27;

        gp.obj[59] = new objDoor(gp);
        gp.obj[59].worldX = gp.tileSize * 39;
        gp.obj[59].worldY = gp.tileSize * 19;

        gp.obj[60] = new objKey(gp);
        gp.obj[60].worldX = gp.tileSize * 39;
        gp.obj[60].worldY = gp.tileSize * 17;

        gp.obj[61] = new objHealingWisp(gp);
        gp.obj[61].worldX = gp.tileSize * 25;
        gp.obj[61].worldY = gp.tileSize * 43;

        gp.obj[62] = new objHealingWisp(gp);
        gp.obj[62].worldX = gp.tileSize * 25;
        gp.obj[62].worldY = gp.tileSize * 15;

    }

    public void setNPC() {

        //Creates NPC in Game

        gp.npc[0] = new Prisoner1_NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 46;
        gp.npc[0].worldY = gp.tileSize * 45;

        gp.npc[1] = new KeyHolder_NPC(gp);
        gp.npc[1].worldX = gp.tileSize * 23;
        gp.npc[1].worldY = gp.tileSize * 34;

        gp.npc[2] = new Room_NPC(gp);
        gp.npc[2].worldX = gp.tileSize * 23;
        gp.npc[2].worldY = gp.tileSize * 25;


    }

    public void setMonster() {

        //Creates Monster in Game

        gp.monster[0] = new MON_Ghost(gp);
        gp.monster[0].worldX = gp.tileSize * 30;
        gp.monster[0].worldY = gp.tileSize * 36;

        gp.monster[1] = new MON_Ghost(gp);
        gp.monster[1].worldX = gp.tileSize * 30;
        gp.monster[1].worldY = gp.tileSize * 38;

        gp.monster[2] = new MON_Ghost(gp);
        gp.monster[2].worldX = gp.tileSize * 17;
        gp.monster[2].worldY = gp.tileSize * 25;

        gp.monster[3] = new MON_Ghost(gp);
        gp.monster[3].worldX = gp.tileSize * 43;
        gp.monster[3].worldY = gp.tileSize * 38;

        gp.monster[4] = new MON_Ghost(gp);
        gp.monster[4].worldX = gp.tileSize * 30;
        gp.monster[4].worldY = gp.tileSize * 45;

        gp.monster[5] = new MON_Ghost(gp);
        gp.monster[5].worldX = gp.tileSize * 14;
        gp.monster[5].worldY = gp.tileSize * 10;

        gp.monster[6] = new MON_Ghost(gp);
        gp.monster[6].worldX = gp.tileSize * 43;
        gp.monster[6].worldY = gp.tileSize * 38;

        gp.monster[7] = new MON_Ghost(gp);
        gp.monster[7].worldX = gp.tileSize * 11;
        gp.monster[7].worldY = gp.tileSize * 25;

        gp.monster[8] = new MON_Ghost(gp);
        gp.monster[8].worldX = gp.tileSize * 26;
        gp.monster[8].worldY = gp.tileSize * 31;

        gp.monster[9] = new MON_Ghost(gp);
        gp.monster[9].worldX = gp.tileSize * 3;
        gp.monster[9].worldY = gp.tileSize * 45;

        gp.monster[10] = new MON_Ghost(gp);
        gp.monster[10].worldX = gp.tileSize * 3;
        gp.monster[10].worldY = gp.tileSize * 4;

        gp.monster[11] = new MON_Ghost(gp);
        gp.monster[11].worldX = gp.tileSize * 40;
        gp.monster[11].worldY = gp.tileSize * 8;

        gp.monster[12] = new MON_Ghost(gp);
        gp.monster[12].worldX = gp.tileSize * 26;
        gp.monster[12].worldY = gp.tileSize * 9;

        gp.monster[13] = new MON_Ghost(gp);
        gp.monster[13].worldX = gp.tileSize * 31;
        gp.monster[13].worldY = gp.tileSize * 17;
    }

    public void finalStage_Monster(){

        //Creates more Monster for Final Stage

        gp.monster[14] = new MON_Ghost(gp);
        gp.monster[14].worldX = gp.tileSize * 3;
        gp.monster[14].worldY = gp.tileSize * 3;

        gp.monster[15] = new MON_Ghost(gp);
        gp.monster[15].worldX = gp.tileSize * 4;
        gp.monster[15].worldY = gp.tileSize * 3;

        gp.monster[16] = new MON_Ghost(gp);
        gp.monster[16].worldX = gp.tileSize * 5;
        gp.monster[16].worldY = gp.tileSize * 3;

        gp.monster[17] = new MON_Ghost(gp);
        gp.monster[17].worldX = gp.tileSize * 6;
        gp.monster[17].worldY = gp.tileSize * 3;

        gp.monster[18] = new MON_Ghost(gp);
        gp.monster[18].worldX = gp.tileSize * 7;
        gp.monster[18].worldY = gp.tileSize * 3;

        gp.monster[19] = new MON_Ghost(gp);
        gp.monster[19].worldX = gp.tileSize * 8;
        gp.monster[19].worldY = gp.tileSize * 3;

        gp.monster[20] = new MON_Ghost(gp);
        gp.monster[20].worldX = gp.tileSize * 9;
        gp.monster[20].worldY = gp.tileSize * 3;

        gp.monster[21] = new MON_Ghost(gp);
        gp.monster[21].worldX = gp.tileSize * 10;
        gp.monster[21].worldY = gp.tileSize * 3;

        gp.monster[22] = new MON_Ghost(gp);
        gp.monster[22].worldX = gp.tileSize * 11;
        gp.monster[22].worldY = gp.tileSize * 3;

        gp.monster[23] = new MON_Ghost(gp);
        gp.monster[23].worldX = gp.tileSize * 12;
        gp.monster[23].worldY = gp.tileSize * 3;

        gp.monster[24] = new MON_Ghost(gp);
        gp.monster[24].worldX = gp.tileSize * 13;
        gp.monster[24].worldY = gp.tileSize * 3;

        gp.monster[25] = new MON_Ghost(gp);
        gp.monster[25].worldX = gp.tileSize * 14;
        gp.monster[25].worldY = gp.tileSize * 3;

        gp.monster[26] = new MON_Ghost(gp);
        gp.monster[26].worldX = gp.tileSize * 15;
        gp.monster[26].worldY = gp.tileSize * 3;

        gp.monster[27] = new MON_Ghost(gp);
        gp.monster[27].worldX = gp.tileSize * 16;
        gp.monster[27].worldY = gp.tileSize * 3;

        gp.monster[28] = new MON_Ghost(gp);
        gp.monster[28].worldX = gp.tileSize * 30;
        gp.monster[28].worldY = gp.tileSize * 3;

        gp.monster[29] = new MON_Ghost(gp);
        gp.monster[29].worldX = gp.tileSize * 31;
        gp.monster[29].worldY = gp.tileSize * 3;

        gp.monster[30] = new MON_Ghost(gp);
        gp.monster[30].worldX = gp.tileSize * 32;
        gp.monster[30].worldY = gp.tileSize * 3;

        gp.monster[31] = new MON_Ghost(gp);
        gp.monster[31].worldX = gp.tileSize * 33;
        gp.monster[31].worldY = gp.tileSize * 3;

        gp.monster[32] = new MON_Ghost(gp);
        gp.monster[32].worldX = gp.tileSize * 34;
        gp.monster[32].worldY = gp.tileSize * 3;

        gp.monster[33] = new MON_Ghost(gp);
        gp.monster[33].worldX = gp.tileSize * 35;
        gp.monster[33].worldY = gp.tileSize * 3;

        gp.monster[34] = new MON_Ghost(gp);
        gp.monster[34].worldX = gp.tileSize * 5;
        gp.monster[34].worldY = gp.tileSize * 37;

        gp.monster[35] = new MON_Ghost(gp);
        gp.monster[35].worldX = gp.tileSize * 7;
        gp.monster[35].worldY = gp.tileSize * 37;

        gp.monster[36] = new MON_Ghost(gp);
        gp.monster[36].worldX = gp.tileSize * 9;
        gp.monster[36].worldY = gp.tileSize * 37;

        gp.monster[37] = new MON_Ghost(gp);
        gp.monster[37].worldX = gp.tileSize * 11;
        gp.monster[37].worldY = gp.tileSize * 37;

        gp.monster[38] = new MON_Ghost(gp);
        gp.monster[38].worldX = gp.tileSize * 13;
        gp.monster[38].worldY = gp.tileSize * 37;

        gp.monster[39] = new MON_Ghost(gp);
        gp.monster[39].worldX = gp.tileSize * 15;
        gp.monster[39].worldY = gp.tileSize * 37;

        gp.monster[40] = new MON_Ghost(gp);
        gp.monster[40].worldX = gp.tileSize * 17;
        gp.monster[40].worldY = gp.tileSize * 37;

        gp.monster[41] = new MON_Ghost(gp);
        gp.monster[41].worldX = gp.tileSize * 19;
        gp.monster[41].worldY = gp.tileSize * 37;

        gp.monster[42] = new MON_Ghost(gp);
        gp.monster[42].worldX = gp.tileSize * 21;
        gp.monster[42].worldY = gp.tileSize * 37;

        gp.monster[43] = new MON_Ghost(gp);
        gp.monster[43].worldX = gp.tileSize * 23;
        gp.monster[43].worldY = gp.tileSize * 37;

        gp.monster[44] = new MON_Ghost(gp);
        gp.monster[44].worldX = gp.tileSize * 25;
        gp.monster[44].worldY = gp.tileSize * 37;

        gp.monster[45] = new MON_Ghost(gp);
        gp.monster[45].worldX = gp.tileSize * 27;
        gp.monster[45].worldY = gp.tileSize * 37;

        gp.monster[46] = new MON_Ghost(gp);
        gp.monster[46].worldX = gp.tileSize * 29;
        gp.monster[46].worldY = gp.tileSize * 37;

        gp.monster[47] = new MON_Ghost(gp);
        gp.monster[47].worldX = gp.tileSize * 31;
        gp.monster[47].worldY = gp.tileSize * 37;

        gp.monster[48] = new MON_Ghost(gp);
        gp.monster[48].worldX = gp.tileSize * 33;
        gp.monster[48].worldY = gp.tileSize * 37;

        gp.monster[49] = new MON_Ghost(gp);
        gp.monster[49].worldX = gp.tileSize * 35;
        gp.monster[49].worldY = gp.tileSize * 37;

        gp.monster[51] = new MON_Ghost(gp);
        gp.monster[51].worldX = gp.tileSize * 29;
        gp.monster[51].worldY = gp.tileSize * 37;

        gp.monster[52] = new MON_Ghost(gp);
        gp.monster[52].worldX = gp.tileSize * 31;
        gp.monster[52].worldY = gp.tileSize * 37;

        gp.monster[53] = new MON_Ghost(gp);
        gp.monster[53].worldX = gp.tileSize * 33;
        gp.monster[53].worldY = gp.tileSize * 37;

        gp.monster[54] = new MON_Ghost(gp);
        gp.monster[54].worldX = gp.tileSize * 35;
        gp.monster[54].worldY = gp.tileSize * 37;

        gp.monster[55] = new MON_Ghost(gp);
        gp.monster[55].worldX = gp.tileSize * 35;
        gp.monster[55].worldY = gp.tileSize * 37;

        gp.monster[56] = new MON_Ghost(gp);
        gp.monster[56].worldX = gp.tileSize * 29;
        gp.monster[56].worldY = gp.tileSize * 38;

        gp.monster[57] = new MON_Ghost(gp);
        gp.monster[57].worldX = gp.tileSize * 31;
        gp.monster[57].worldY = gp.tileSize * 38;

        gp.monster[58] = new MON_Ghost(gp);
        gp.monster[58].worldX = gp.tileSize * 33;
        gp.monster[58].worldY = gp.tileSize * 38;

        gp.monster[59] = new MON_Ghost(gp);
        gp.monster[59].worldX = gp.tileSize * 35;
        gp.monster[59].worldY = gp.tileSize * 38;

        gp.monster[60] = new MON_Ghost(gp);
        gp.monster[60].worldX = gp.tileSize * 35;
        gp.monster[60].worldY = gp.tileSize * 38;

        gp.monster[61] = new MON_Ghost(gp);
        gp.monster[61].worldX = gp.tileSize * 29;
        gp.monster[61].worldY = gp.tileSize * 38;

        gp.monster[62] = new MON_Ghost(gp);
        gp.monster[62].worldX = gp.tileSize * 31;
        gp.monster[62].worldY = gp.tileSize * 39;

        gp.monster[63] = new MON_Ghost(gp);
        gp.monster[63].worldX = gp.tileSize * 33;
        gp.monster[63].worldY = gp.tileSize * 39;

        gp.monster[64] = new MON_Ghost(gp);
        gp.monster[64].worldX = gp.tileSize * 35;
        gp.monster[64].worldY = gp.tileSize * 39;

        gp.monster[65] = new MON_Ghost(gp);
        gp.monster[65].worldX = gp.tileSize * 45;
        gp.monster[65].worldY = gp.tileSize * 30;

        gp.monster[66] = new MON_Ghost(gp);
        gp.monster[66].worldX = gp.tileSize * 44;
        gp.monster[66].worldY = gp.tileSize * 30;

        gp.monster[67] = new MON_Ghost(gp);
        gp.monster[67].worldX = gp.tileSize * 43;
        gp.monster[67].worldY = gp.tileSize * 30;

        gp.monster[68] = new MON_Ghost(gp);
        gp.monster[68].worldX = gp.tileSize * 43;
        gp.monster[68].worldY = gp.tileSize * 31;

        gp.monster[69] = new MON_Ghost(gp);
        gp.monster[69].worldX = gp.tileSize * 43;
        gp.monster[69].worldY = gp.tileSize * 32;

    }
}
