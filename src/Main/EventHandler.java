package Main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    // --- CHANGE 1: ADD THESE VARIABLES ---
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    // -------------------------------------

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void CheckEvent() {

        // --- CHANGE 2: CHECK DISTANCE TO RESET EVENT ---
        // This checks if the player is more than 1 tile away from the last event
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if(distance > 20) {
            canTouchEvent = true;
        }

        if(canTouchEvent) {
            // We pass the col/row (20, 23) into damagePit so we can remember location
            if(hit(20, 23, "up")){ damagePit(20, 23, gp.dialogueState); }
        }

    }

    public boolean hit(int eventCol, int eventRow, String reqDirection){

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

    // --- CHANGE 3: UPDATE METHOD TO HANDLE COOLDOWN ---
    public void damagePit(int col, int row, int gameState){

        gp.gameState = gameState;
        gp.ui.currentDialogue = "Something scratches on your arm";
        gp.player.life -= 1;

        // Disable touch so it doesn't happen again immediately
        canTouchEvent = false;
    }
}