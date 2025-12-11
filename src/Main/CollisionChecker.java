package Main;

import Entity.Entity;

import java.awt.*;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){

        this.gp = gp;

    }

    public void checkTile(Entity entity) {

        // Calculate the entity's position in the world + their solid area offset
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.normalSpeed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                // We must check if these tiles are actually solid
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {

                    // If we found a solid tile, we now check exact collision rectangle intersection
                    if(checkSolid(entity, tileNum1, entityLeftCol, entityTopRow) ||
                            checkSolid(entity, tileNum2, entityRightCol, entityTopRow)) {
                        entity.collisionOn = true;
                    }
                }
                break;

            case "down":
                entityBottomRow = (entityBottomWorldY + entity.normalSpeed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    if(checkSolid(entity, tileNum1, entityLeftCol, entityBottomRow) ||
                            checkSolid(entity, tileNum2, entityRightCol, entityBottomRow)) {
                        entity.collisionOn = true;
                    }
                }
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.normalSpeed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    if(checkSolid(entity, tileNum1, entityLeftCol, entityTopRow) ||
                            checkSolid(entity, tileNum2, entityLeftCol, entityBottomRow)) {
                        entity.collisionOn = true;
                    }
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.normalSpeed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    if(checkSolid(entity, tileNum1, entityRightCol, entityTopRow) ||
                            checkSolid(entity, tileNum2, entityRightCol, entityBottomRow)) {
                        entity.collisionOn = true;
                    }
                }
                break;
        }
    }

    // HELPER METHOD TO CHECK EXACT RECTANGLE INTERSECTION
// Add this method inside CollisionChecker class
    public boolean checkSolid(Entity entity, int tileNum, int col, int row) {

        // If the tile isn't solid, ignore it
        if(gp.tileM.tile[tileNum].collision == false) {
            return false;
        }

        // Get the position of the tile in the world
        int tileWorldX = col * gp.tileSize;
        int tileWorldY = row * gp.tileSize;

        // Create the Tile's rectangle (using the custom solidArea we made!)
        Rectangle tileRect = new Rectangle(
                tileWorldX + gp.tileM.tile[tileNum].solidArea.x,
                tileWorldY + gp.tileM.tile[tileNum].solidArea.y,
                gp.tileM.tile[tileNum].solidArea.width,
                gp.tileM.tile[tileNum].solidArea.height
        );

        // Create the Entity's predicted rectangle
        Rectangle entityRect = new Rectangle(
                entity.worldX + entity.solidArea.x,
                entity.worldY + entity.solidArea.y,
                entity.solidArea.width,
                entity.solidArea.height
        );

        // Apply speed prediction based on direction
        switch(entity.direction) {
            case "up": entityRect.y -= entity.normalSpeed; break;
            case "down": entityRect.y += entity.normalSpeed; break;
            case "left": entityRect.x -= entity.normalSpeed; break;
            case "right": entityRect.x += entity.normalSpeed; break;
        }

        // Check if they touch
        return entityRect.intersects(tileRect);
    }

    public int checkObject(Entity entity, boolean player){

        int index = 999;

        for(int i = 0; i < gp.obj.length; i++){

             if(gp.obj[i] != null){

                //Get entity solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                //Get object solid position area
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                 gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                 switch(entity.direction){

                     case "up":
                         entity.solidArea.y -= entity.normalSpeed;
                         if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision){
                                entity.collisionOn = true;
                            }
                            if(player){
                                index = i;
                            }
                         }
                         break;
                     case "down":
                         entity.solidArea.y += entity.normalSpeed;
                         if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                             if(gp.obj[i].collision){
                                 entity.collisionOn = true;
                             }
                             if(player){
                                 index = i;
                             }

                         }
                         break;
                     case "left":
                         entity.solidArea.x -= entity.normalSpeed;
                         if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                             if(gp.obj[i].collision){
                                 entity.collisionOn = true;
                             }
                             if(player){
                                 index = i;
                             }

                         }
                         break;
                     case "right":
                         entity.solidArea.x += entity.normalSpeed;
                         if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                             if(gp.obj[i].collision){
                                 entity.collisionOn = true;
                             }
                             if(player){
                                 index = i;
                             }

                             break;
                         }
                 }
                 entity.solidArea.x = entity.solidAreaDefaultX;
                 entity.solidArea.y = entity.solidAreaDefaultY;
                 gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                 gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }

        }
        return index;
    }
    //NPC OR MONSTER COLLISION
    public int checkEntity(Entity entity, Entity[] target){

        int index = 999;

        for(int i = 0; i < target.length; i++){

            if(target[i] != null){

                //Get entity solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                //Get object solid position area
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                switch(entity.direction){

                    case "up":
                        entity.solidArea.y -= entity.normalSpeed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.normalSpeed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;


                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.normalSpeed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;


                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.normalSpeed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                            break;
                        }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }

        }
        return index;
    }

    public void checkPlayer(Entity entity){

        //Get entity solid area position
        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;

        //Get object solid position area
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        switch(entity.direction){

            case "up":
                entity.solidArea.y -= entity.normalSpeed;
                if(entity.solidArea.intersects(gp.player.solidArea)){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entity.solidArea.y += entity.normalSpeed;
                if(entity.solidArea.intersects(gp.player.solidArea)){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.solidArea.x -= entity.normalSpeed;
                if(entity.solidArea.intersects(gp.player.solidArea)){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entity.solidArea.x += entity.normalSpeed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                    break;
                }
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;

    }
}
