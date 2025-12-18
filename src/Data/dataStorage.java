package Data;

import java.io.Serializable;

public class dataStorage implements Serializable {

    // PLAYER STATUS
    int maxLife, life, stamina, maxStamina, normalSpeed, orbCount, hasKey, killCount;

    // OBJECTS (Single Map = 1D Arrays)
    String mapObjectNames[];
    int mapObjectWorldX[];
    int mapObjectWorldY[];

    // MONSTER DATA
    String monsterNames[];
    int monsterWorldX[];
    int monsterWorldY[];
    int monsterLife[];
}