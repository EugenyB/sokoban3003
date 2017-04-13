package sokoban.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eugen on 30.03.2017.
 */
public class Level {
    private int sizeX;
    private int sizeY;

    private Set<Wall> walls;
    private Set<Target> targets;
    private List<Box> boxes;
    private Player player;

    public Set<Wall> getWalls() {
        return walls;
    }

    public void setWalls(Set<Wall> walls) {
        this.walls = walls;
    }

    public Set<Target> getTargets() {
        return targets;
    }

    public void setTargets(Set<Target> targets) {
        this.targets = targets;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Level(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        walls = new HashSet<>();
        targets = new HashSet<>();
        boxes = new ArrayList<>();
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}
