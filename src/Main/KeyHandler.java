
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
        //Method has no use but is required by KeyListener
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode(); //Code for Pressed Key

        //TITLE STATE
        //Title Navigation
        if (gp.gameState == gp.titleState) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }

            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
            //For Title Screen Options
            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    gp.gameState = gp.guideState;
                    gp.guideTimer = 0;
                    gp.guidePage = 0;
                }
                if (gp.ui.commandNum == 1) {
                    gp.saveLoad.load();
                    gp.gameState = gp.playState;
                    gp.playMusic(2);
                }
                if (gp.ui.commandNum == 2) {
                    System.exit(0);
                }

            }
        } else if (gp.gameState == gp.guideState) {

            if (code == KeyEvent.VK_ENTER) {
            //For Page Flipping in Guide State
                if (gp.guideTimer > 180) {

                    if (gp.guidePage == 0) {
                        gp.guidePage = 1;
                        gp.guideTimer = 0;
                    } else if (gp.guidePage == 1) {
                        gp.guidePage = 2;
                        gp.guideTimer = 0;
                    } else if (gp.guidePage == 2) {
                        gp.guidePage = 3;
                        gp.guideTimer = 0;
                    }else if (gp.guidePage == 3) {
                        gp.gameState = gp.playState;
                        gp.playMusic(2);
                    }
                }
            }
        }

        //PLAY STATE
        if (gp.gameState == gp.playState) {
            //For Player Movement
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
        else if (gp.gameState == gp.pauseState) {

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }

        //DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_E || code == KeyEvent.VK_ENTER) { // Added ENTER as an option too

                // 1. Close the dialogue window
                gp.gameState = gp.playState;

                // 2. Check if we just finished the specific dialogue stage
                if (gp.player.talkCount == 2) {

                    // 3. Trigger the UI Message
                    gp.ui.showMessage("THE TRIAL HAS BEGUN");

                    // 4. Increment count so the message doesn't appear again next time
                    gp.player.talkCount++;
                }
            }
        }

        else if (gp.gameState == gp.gameOverState || gp.gameState == gp.endGameState) {
            gameOverState(code);
        }
    }

    public void gameOverState(int code) {

        // Navigation
        if (code == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                if(gp.gameState == gp.endGameState) {
                    gp.ui.commandNum = 0;
                } else {
                    gp.ui.commandNum = 1;
                }
            }
        }

        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;

            if(gp.gameState == gp.endGameState) {
                gp.ui.commandNum = 0;
            } else {
                if (gp.ui.commandNum > 1) {
                    gp.ui.commandNum = 0;
                }
            }
        }

        // Select Option
        if (code == KeyEvent.VK_ENTER) {

            if (gp.gameState == gp.endGameState) {
                // WIN LOGIC: Go back to title
                if (gp.ui.commandNum == 0) {
                    gp.gameState = gp.titleState;
                    gp.stopMusic();
                    gp.restart(); // Reset player HP/Pos for next game
                }
            }
            else {
                // LOSE LOGIC
                if (gp.ui.commandNum == 0) {
                    gp.retry();
                } else if (gp.ui.commandNum == 1) {
                    gp.restart(); // Quit to title
                }
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
