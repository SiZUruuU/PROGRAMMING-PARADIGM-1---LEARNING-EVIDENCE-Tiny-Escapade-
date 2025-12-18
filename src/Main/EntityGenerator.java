package Main;

import Entity.Entity;
import Monster.MON_Ghost;
import Objects.*;


public class EntityGenerator {

    GamePanel gp;

    public EntityGenerator(GamePanel gp){
        this.gp = gp;
    }

    public Entity getObject(String itemName){

        //Entity Generation for Save and Load

        Entity obj = null;

        switch(itemName){
            case "Key":
                obj = new objKey(gp);
                break;
            case "Door":
                obj = new objDoor(gp);
                break;
            case "Final Door":
                obj = new objFinalDoor(gp);
                break;
            case "Orb":
                obj = new objOrb(gp);
                break;
            case "Wisp":
                obj = new objHealingWisp(gp);
                break;
            case "Ghost":
                obj = new MON_Ghost(gp);
                break;
        }
        return obj;
    }
}