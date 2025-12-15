
package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener{

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed, eKeyPressed;
    public boolean checkDrawTime = false; //debug boolean

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }

            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.guideState;
                    gp.guideTimer = 0;
                    gp.guidePage = 0;
                }
                if(gp.ui.commandNum == 1){

                }
                if(gp.ui.commandNum == 2){
                    System.exit(0);
                }

            }
        }
        else if (gp.gameState == gp.guideState) {

            if (code == KeyEvent.VK_ENTER) {

                if(gp.guideTimer > 180) {

                    if (gp.guidePage == 0) {
                        gp.guidePage = 1;
                        gp.guideTimer = 0;
                    } else if (gp.guidePage == 1) {
                        gp.guidePage = 2;
                        gp.guideTimer = 0;
                    } else if (gp.guidePage == 2) {
                        gp.gameState = gp.playState;
                        gp.playMusic(2);
                    }
                }
            }
        }

        //PLAY STATE
        if(gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_SHIFT) {
                shiftPressed = true;
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_E) {
                eKeyPressed = true;
            }

            //DEBUG
            if (code == KeyEvent.VK_T) {
                if (!checkDrawTime) {
                    checkDrawTime = true;
                } else if (checkDrawTime) {
                    checkDrawTime = false;
                }
            }
        }

        //PAUSE STATE
        else if(gp.gameState == gp.pauseState){

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }

        //DIALOGUE STATE
        else if(gp.gameState == gp.dialogueState){
            if(code == KeyEvent.VK_E){
                gp.gameState = gp.playState;
            }

        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_SHIFT){
            shiftPressed = false;
        }

    }

}
