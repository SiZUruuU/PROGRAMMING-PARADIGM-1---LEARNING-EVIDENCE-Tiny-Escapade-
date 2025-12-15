package Main;

import Entity.Entity;
import Entity.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768px
    public final int screenHeight = tileSize * maxScreenRow; //576px

    //World settings

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    int FPS = 60;

    //SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public Sound music = new Sound();
    public Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;

    //ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public Entity obj[] = new Entity[20];
    public Entity npc[] = new Entity[20];
    public Entity monster[] = new Entity[10];
    ArrayList<Entity> entityList = new ArrayList<>();

    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int guideState = 1;
    public final int playState = 2;
    public final int pauseState = 3;
    public final int dialogueState = 4;

    //GUIDE STATE PAGES
    public int guidePage = 0;
    public int guideTimer = 0;

    //Default PLAYER position

    int playerX = 100;
    int playerY = 100;
    int normalSpeed = 4;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {

        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
//        playMusic(0);
        gameState = titleState;
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 / FPS;
        double nextDrawTime = System.nanoTime () + drawInterval;

        while(gameThread != null) {

            update();

            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


    public void update() {

        if (gameState == guideState) {
            guideTimer++;
        }


        if(gameState == playState){
            //PLAYER
            player.update();
            //NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            for(int i=0; i < monster.length; i++){
                if(monster[i] != null){
                    monster[i].update();
                }
            }
        }
        if(gameState == pauseState){

        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Debug
        long drawStart = 0;
        if(keyH.checkDrawTime) {
            drawStart = System.nanoTime();
        }

        //TITLE SCREEN

        if(gameState == titleState){
            ui.draw(g2);
        }else{

            //HIND TILES
            tileM.draw(g2, false);

            //ADD ENTITY TO LIST
            entityList.add(player);

            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    entityList.add(npc[i]);
                }
            }

            for(int i = 0; i < obj.length; i++){
                if(obj[i] != null){
                    entityList.add(obj[i]);
                }
            }

            for(int i = 0; i < monster.length; i++){
                if(monster[i] != null){
                    entityList.add(monster[i]);
                }
            }

            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY );
                    return result;
                }
            });

            //DRAW Entity
            for(int i = 0; i < entityList.size(); i++){
                entityList.get(i).draw(g2);
            }

            //EMPTY ENTITY LIST
            entityList.clear();

            //FORE TILES
            tileM.draw(g2, true);
            eHandler.draw(g2);
            //UI
            ui.draw(g2);
        }

        //Debug
        if(keyH.checkDrawTime) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }

        g2.dispose();

    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();

    }

    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
