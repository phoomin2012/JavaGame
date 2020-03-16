package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Random;

public class Obstacle {
    private int x;
    private int y;
    Image obstacleIcon;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
        Hashtable<Integer, String> imageDict = new Hashtable<Integer, String>();

        imageDict.put(0, "image/cactus.png");
        imageDict.put(1, "image/car1.png");
        imageDict.put(2, "image/car2.png");

        Random rand = new Random();

        ImageIcon icon = new ImageIcon(imageDict.get(rand.nextInt(imageDict.size())));
        obstacleIcon = icon.getImage();
    }

    public void move() {
        x -= 15;
    }

    public void draw(Graphics g) {

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