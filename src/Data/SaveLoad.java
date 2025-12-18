package Data;

import Main.GamePanel;
import java.io.*;

public class SaveLoad {

    GamePanel gp;

    public SaveLoad(GamePanel gp){
        this.gp = gp;
    }

    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            dataStorage ds = new dataStorage();

            // 1. SAVE PLAYER DATA
            ds.maxLife = gp.player.maxLife;
            ds.life = gp.player.life;
            ds.stamina = gp.player.stamina;
            ds.maxStamina = gp.player.maxStamina;
            ds.normalSpeed = gp.player.normalSpeed;
            ds.orbCount = gp.player.orbCount;
            ds.hasKey = gp.player.hasKey;
            ds.killCount = gp.killCount;

            // 2. SAVE OBJECT DATA (1D Array)
            ds.mapObjectNames = new String[gp.obj.length];
            ds.mapObjectWorldX = new int[gp.obj.length];
            ds.mapObjectWorldY = new int[gp.obj.length];

            for(int i = 0; i < gp.obj.length; i++) {
                if(gp.obj[i] == null) {
                    ds.mapObjectNames[i] = "NA";
                }
                else {
                    ds.mapObjectNames[i] = gp.obj[i].name;
                    ds.mapObjectWorldX[i] = gp.obj[i].worldX;
                    ds.mapObjectWorldY[i] = gp.obj[i].worldY;
                }
            }
            // SAVE MONSTERS
            ds.monsterNames = new String[gp.monster.length];
            ds.monsterWorldX = new int[gp.monster.length];
            ds.monsterWorldY = new int[gp.monster.length];
            ds.monsterLife = new int[gp.monster.length];

            for(int i = 0; i < gp.monster.length; i++){
                if(gp.monster[i] == null){
                    ds.monsterNames[i] = "NA"; // Monster is dead/doesn't exist
                }
                else {
                    ds.monsterNames[i] = gp.monster[i].name;
                    ds.monsterWorldX[i] = gp.monster[i].worldX;
                    ds.monsterWorldY[i] = gp.monster[i].worldY;
                    ds.monsterLife[i] = gp.monster[i].life;
                }
            }

            // Inside save() method:

// ... (code for saving objects) ...

// SAVE MONSTERS
            ds.monsterNames = new String[gp.monster.length];
            ds.monsterWorldX = new int[gp.monster.length];
            ds.monsterWorldY = new int[gp.monster.length];
            ds.monsterLife = new int[gp.monster.length];

            for(int i = 0; i < gp.monster.length; i++){
                if(gp.monster[i] == null){
                    ds.monsterNames[i] = "NA"; // Monster is dead/doesn't exist
                }
                else {
                    ds.monsterNames[i] = gp.monster[i].name;
                    ds.monsterWorldX[i] = gp.monster[i].worldX;
                    ds.monsterWorldY[i] = gp.monster[i].worldY;
                    ds.monsterLife[i] = gp.monster[i].life;
                }
            }

            oos.writeObject(ds);
            oos.close();

        } catch(Exception e) {
            System.out.println("Save Exception!");
            e.printStackTrace();
        }
    }

    public void load(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            dataStorage ds = (dataStorage)ois.readObject();

            // 1. LOAD PLAYER DATA
            gp.player.maxLife = ds.maxLife;
            gp.player.life = ds.life;
            gp.player.stamina = ds.stamina;
            gp.player.maxStamina = ds.maxStamina;
            gp.player.normalSpeed = ds.normalSpeed;
            gp.player.orbCount = ds.orbCount;
            gp.player.hasKey = ds.hasKey;
            gp.killCount = ds.killCount;

            // 2. LOAD OBJECT DATA (1D Array)
            for(int i = 0; i < gp.obj.length; i++) {

                if(ds.mapObjectNames[i].equals("NA")) {
                    gp.obj[i] = null;
                }
                else {
                    // Create object from name
                    gp.obj[i] = gp.eGenerator.getObject(ds.mapObjectNames[i]);
                    gp.obj[i].worldX = ds.mapObjectWorldX[i];
                    gp.obj[i].worldY = ds.mapObjectWorldY[i];
                }
            }

            // LOAD MONSTERS
            for(int i = 0; i < gp.monster.length; i++){

                if(ds.monsterNames[i].equals("NA")){
                    gp.monster[i] = null; // Keep the slot empty (dead monster)
                }
                else {
                    // 1. Create the monster using the Generator
                    gp.monster[i] = gp.eGenerator.getObject(ds.monsterNames[i]);

                    // 2. Set its position and HP
                    gp.monster[i].worldX = ds.monsterWorldX[i];
                    gp.monster[i].worldY = ds.monsterWorldY[i];
                    gp.monster[i].life = ds.monsterLife[i];
                }
            }

            ois.close();

        } catch(Exception e) {
            System.out.println("Load Exception!");
            e.printStackTrace();
        }
    }
}