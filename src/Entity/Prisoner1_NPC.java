package Entity;

import Main.GamePanel;

import java.util.Random;

public class Prisoner1_NPC extends Entity{

    public Prisoner1_NPC(GamePanel gp){
        super(gp);

        int plus = 0;
        plus++;

        direction = "down";
        normalSpeed = 1;

        getImage();
        setDialogue();

    }

    public void getImage(){

        left1 = setUp("/npc/left0");
        left2 = setUp("/npc/left1");
        left3 = setUp("/npc/left2");
        left4 = setUp("/npc/left3");
        left5 = setUp("/npc/left4");
        left6 = setUp("/npc/left5");

        right1 = setUp("/npc/right0");
        right2 = setUp("/npc/right1");
        right3 = setUp("/npc/right2");
        right4 = setUp("/npc/right3");
        right5 = setUp("/npc/right4");
        right6 = setUp("/npc/right5");

    }

    public void setDialogue(){

        dialogues[0] = "I have been trapped in here for 20 years...";
        dialogues[1] = "I remember your face...\nyes I know it well...\nThe resemblance is very similar to HIM";
        dialogues[2] = "I feel death behind me...";
        dialogues[3] = "THE ANNOYANCE!!! I BEG YOU TO STOP!";

    }

    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    public void speak() {

        super.speak();

//        if(dialogueIndex == 3){
//            dialogueIndex = 0;
//        }
//
//        if(dialogueCount == 6){
//            System.out.println("index= " + dialogueIndex);
//            gp.ui.currentDialogue = dialogues[dialogueIndex = 3];
//            dialogueIndex = 0;
//            dialogueCount = 0;
//        }
//        else {
//            gp.ui.currentDialogue = dialogues[dialogueIndex];
//            System.out.println("index= " + dialogueIndex);
//            dialogueIndex++;
//            dialogueCount++;
//        }
//        System.out.println(dialogueCount);


    }

}
