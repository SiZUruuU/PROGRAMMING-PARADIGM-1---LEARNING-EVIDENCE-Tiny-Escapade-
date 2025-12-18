package Entity;

import Main.GamePanel;
import Objects.objKey;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Random;

public class KeyHolder_NPC extends Entity{

    public KeyHolder_NPC(GamePanel gp){
        super(gp);

        name = "Keyholder";

        int plus = 0;
        plus++;

        //Adjust Collision Area of NPC
        solidArea = new Rectangle(14,30,20, 15);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        //Set Default Attributes
        direction = "still";
        normalSpeed = 1;

        getImage();
        setDialogue();

    }

    public void getImage(){

        still = setUp("/npc/Dude_Monster");

    }

    public void setDialogue(){

            dialogues[0] = "The souls continue to run free...Unable \n to escape their torment...";
            dialogues[1] = "Presence that lingers and yet fails to wander";
            dialogues[2] = "The essence of one, how does it feel to hold it all?";
            dialogues[3] = "The agony in the air has dissipated...You have freed them.";
            dialogues[4] = "You know the dungeon well now...I'm impressed";
            dialogues[5] = "Your soul is now the host of thousands that lived before.";
            dialogues[6] = "Mighty warrior, worthy of such a final task...\nOne would think the anomaly would never face such an enemy again...";
    }


    public void speak() {

        //Adjust Dialogue Index depending on conditions met
        if(gp.player.orbCount >= 30){
            enoughOrb = true;
            gp.ui.currentDialogue = dialogues[dialogueIndex = 5];
        }
        else if(gp.player.orbCount < 30){
            gp.ui.currentDialogue = dialogues[dialogueIndex = 2];
        }
        if(gp.player.hasKey == 3){
            enoughKey = true;
            gp.ui.currentDialogue = dialogues[dialogueIndex = 4];
        }
        else if(gp.player.hasKey < 3){
            gp.ui.currentDialogue = dialogues[dialogueIndex = 1];
        }
        if(gp.killCount == 10){
            enoughSoul = true;
            gp.ui.currentDialogue = dialogues[dialogueIndex = 3];
        }
        else if(gp.killCount < 10){
            gp.ui.currentDialogue = dialogues[dialogueIndex = 0];
        }
        if(enoughOrb && enoughKey && enoughSoul){
            completeProgress = true;
            gp.ui.currentDialogue = dialogues[dialogueIndex = 6];

            // *** DYNAMIC SPAWNING FIX ***
            if (completeProgress && !keySpawned) {
                int keyIndex = 26;

                // Creates new object once conditions are met
                gp.obj[keyIndex] = new objKey(gp);
                gp.obj[keyIndex].worldX = gp.tileSize * 22;
                gp.obj[keyIndex].worldY = gp.tileSize * 34;

                //Allows key to be only spawned once
                keySpawned = true;
                //SFX for object spawn
                gp.playSE(5);
            }
        }

    }
}
