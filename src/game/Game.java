package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game extends JPanel implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;

    private Timer timer;
    private Player player;
    private Obstacle obstacle, obstacle2, obstacle3;

    private Random rand = new Random();

    private boolean play;

    public Game() {
        timer = new Timer(15, this);
        timer.start();

        player = new Player(150, 360);
        obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 200, 360);
        obstacle2 = new Obstacle(rand.nextInt(Project.WIDTH) + 200, 360);
        obstacle3 = new Obstacle(rand.nextInt(Project.WIDTH) + 200, 360);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        play = true;

        player.draw(g);
        obstacle.draw(g);
        obstacle2.draw(g);
        obstacle3.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (play) {
            player.update();
            obstacle.update();
            obstacle2.update();
            obstacle3.update();
            repaint();

            if (player.isFall() && player.getY() >= 360) {
                player.setY(360);
                player.setSpeedY(0);
                player.setFall(false);
                player.setJump(true);
            }

            if (player.getX() + 30 >= obstacle.getX() - 30) {
                System.out.println("Collide!!");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Jump
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
