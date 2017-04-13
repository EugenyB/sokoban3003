package sokoban.controller;

import sokoban.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eugen on 30.03.2017.
 */
public class LevelManager {
    private int levelNum;
//    private int totalLevels;
    List<String> leveLines;

    public LevelManager() {
        leveLines = loadLevels("soko.txt");
    }

    public int getTotalLevels() {
        return Integer.parseInt(leveLines.get(0).split(": ")[1]);
    }

    private List<String> loadLevels(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public boolean isFinished() {
        return getTotalLevels() == levelNum;
    }

    public Level nextLevel() {
        return findLevel(++levelNum);
    }

    private Level findLevel(int num) {
        String startLine = "Maze: " +num;
        int n=0;
        while (!startLine.equals(leveLines.get(n))) n++;
        int sizeX = Integer.parseInt(leveLines.get(n+1).split(": ")[1]);
        int sizeY = Integer.parseInt(leveLines.get(n+2).split(": ")[1]);
        Level level = new Level(sizeX,sizeY);
        return build(level, n);
    }

    private Level build(Level level, int n) {
        int k = n + 5;
        for (int i = 0; i < level.getSizeY(); i++) {
            String line = leveLines.get(k+1);
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                switch (c) {
                    case '@':
                        level.setPlayer(new Player(j, i));
                        break;
                    case 'X':
                        level.getWalls().add(new Wall(j,i));
                        break;
                    case '.':
                        level.getTargets().add(new Target(j,i));
                        break;
                    case '*':
                        level.getBoxes().add(new Box(j,i));
                        break;
                    case '&':
                        level.getBoxes().add(new Box(j,i));
                        level.getTargets().add(new Target(j,i));
                        break;
                }
            }
        }
        return level;
    }
}
