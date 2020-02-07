package game;

import javax.swing.*;
import java.awt.*;

public class Player {
    private int x;
    private int y;
    private double speedY = 0;
    private double gravity = 1.55; // Can tune
    private boolean canJump = true;
    private boolean canFall = false;

    private Image playerImage;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
//        System.out.println("Update");
//        if (canJump == false) {
//            jump();
//        }
        if (y < Project.HEIGHT / 2 + 100) {
            canFall = true;
            fall();
        }

        y += speedY;
    }

    public void draw(Graphics g) {
//        g.setColor(Color.WHITE);
//        g.drawRect(x, y, 60, 60);
        ImageIcon icon = new ImageIcon("image/t-rex.png");
        playerImage = icon.getImage();
        g.drawImage(playerImage, x, y, 60, 60, null);
    }

    public void jump() {
        if (canJump) {
            speedY = -22;
            canJump = false;
        }
    }

    public void fall() {
        if (canFall) {
            speedY += gravity;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFall() {
        return canFall;
    }

    public boolean isJump() {
        return canJump;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setFall(boolean canFall) {
        this.canFall = canFall;
    }

    public void setJump(boolean canJump) {
        this.canJump = canJump;
    }
}
