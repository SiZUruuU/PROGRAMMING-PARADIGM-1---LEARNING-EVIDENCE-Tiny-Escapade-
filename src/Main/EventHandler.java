package Main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    int encounterCount = 0;
    boolean trigger = false;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        //Event Box Values
        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 10;
        eventRect.height = 10;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void CheckEvent() {

        //Checks Player Distance from Event Box for Triggering

        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if(distance > 30) {
            //If Distance reaches past 30px, Event can be Re-Triggered
            canTouchEvent = true;
        }

        if(canTouchEvent) {
            if(hit(45, 44, "any")){damagePit(45, 44, gp.dialogueState); }
            if(hit(41, 45, "any")){damagePit(41, 45, gp.dialogueState); }
            if(hit(25, 43, "any")){HealingWisp(25,43, gp.dialogueState);}
            if(hit(25, 15, "any")){HealingWisp(25,43, gp.dialogueState);}

        }
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection){

        //Method for Event Interaction
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;

        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;
        return hit;
    }

    public void damagePit(int col, int row, int gameState){

        //Method for Damage Pit Event

        //Event Triggered
        gp.gameState = gameState;
        gp.ui.currentDialogue = "Something scratches on your arm";
        gp.playSE(3);

        if(encounterCount == 3){
            //Affects Player Vitals if Event encountered 3 times
            gp.ui.currentDialogue = "The thing burrows into your skin but you managed to swat it away";
            System.out.println("EVENT TRIGGERED");
            gp.player.life -= 1;
            encounterCount = 0;
        }
        else{
            //Increments EncounterCount for 2nd-level Triggering
            encounterCount++;
            System.out.println("Encounter Count: " + encounterCount);
        }
        canTouchEvent = false;
    }

    public void HealingWisp(int col, int row, int gameState){

        //Method for Healing Wisp Event

        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

            gp.gameState = gameState;
            if(gp.killCount >= gp.player.healRequirement){
                //Heals Player if Condition is Met
                gp.ui.currentDialogue = "The wisp grants you the aid you deserve." + "\n(Your progress has been saved!)";
                if(gp.player.life >= 3) {gp.player.life = 5;}
                else if(gp.player.life < 3){gp.player.life += 2;}
                if(gp.player.healRequirement > 50){
                    //Heal Requirement Capped at 50 if int value reaches 50
                    gp.player.healRequirement = 50;
                }
                else{
                    //Increments Heal Requirement(More kills for heal)
                    gp.player.healRequirement++;
                }
            }else if(gp.killCount < gp.player.healRequirement){
                //If killCount is less than HealRequirement(Condition not Met)
                gp.ui.currentDialogue = "You are not deserving of aid." + "\n(Your Progress has been saved!)";
            }
            gp.saveLoad.save();
            canTouchEvent = false;
        }

    public void draw(Graphics2D g2) {

        //Draw Method

        g2.setColor(Color.MAGENTA);

        int eventCol = 25;
        int eventRow = 43;

        // Calculate the position relative to the screen (same math as tiles)
        int worldX = eventCol * gp.tileSize + eventRectDefaultX;
        int worldY = eventRow * gp.tileSize + eventRectDefaultY;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Draw the rectangle
        // We use eventRect.width/height to see the exact trigger size
        if (gp.keyH.checkDrawTime) {
            g2.drawRect(screenX, screenY, eventRect.width, eventRect.height);
        }
    }
}