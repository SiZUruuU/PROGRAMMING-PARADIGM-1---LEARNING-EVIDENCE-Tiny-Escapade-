package Entity;

import Main.AssetSetter;
import Main.GamePanel;
import Objects.objKey;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Random;

public class Room_NPC extends Entity{
    public AssetSetter aSetter = new AssetSetter(gp);

    public Room_NPC(GamePanel gp){
        super(gp);

        name = "Room Guy";

        solidArea = new Rectangle(14,30,20, 15);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        direction = "still";
        normalSpeed = 1;

        getImage();
        setDialogue();

    }

    public void getImage(){
        still = setUp("/final npc/1");
    }

    public void setDialogue(){

        dialogues[0] = "Prove yourself worthy of the Dragonov.";
        dialogues[1] = "Very well...Complete this trial!\nProve your worth! Stand at the pinnacle of all life!";
        dialogues[2] = "Good luck.";

    }


    public void speak() {

        if(gp.player.talkCount == 1){
            gp.ui.currentDialogue = dialogues[dialogueIndex = 0];
            aSetter.finalStage_Monster();
            gp.player.talkCount++;
        }
        else if(gp.player.talkCount == 2){
            gp.ui.currentDialogue = dialogues[dialogueIndex = 1];
        }

        direction = "still";
    }
}
