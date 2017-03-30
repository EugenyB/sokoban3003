package sokoban.controller;

import sokoban.model.Level;

/**
 * Created by eugen on 30.03.2017.
 */
public class LevelManager {
    private int levelNum;
    private int totalLevels;

    public int getTotalLevels() {
        return totalLevels;
    }

    public void loadLevels(String filename) {
        //TODO Загрузка всех уровней при старте
    }

    public boolean isFinished() {
        return totalLevels == levelNum;
    }

    public Level nextLevel() {
        return findLevel(++levelNum);
    }

    private Level findLevel(int num) {
        return null;
    }
}
