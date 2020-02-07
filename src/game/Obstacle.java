package game;

import javax.swing.*;
import java.awt.*;

public class Obstacle {
    private int x;
    private int y;

    Image obstacleIcon;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x -= 10;
    }

    public void draw(Graphics g) {
        ImageIcon icon = new ImageIcon("image/cactus.png");
        obstacleIcon = icon.getImage();
        g.drawImage(obstacleIcon, x, y, 60, 60, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
