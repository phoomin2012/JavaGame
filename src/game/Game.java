package game;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.TimerTask;

public class Game extends JPanel implements ActionListener, KeyListener{
    private static final long serialVersionUID = 1L;

    private Score scoreMenu;
    private StartMenu startMenu;
    private Restart restartMenu;
    private Score scorePanel;

    private Player player;
    private Obstacle obstacle,obstacle2,obstacle3;

    private Random rand = new Random();
    private int score;
    private boolean play;

//    private JLabel scoreLabel;
    enum STATE {
        MENU,
        GAME,
        GAME_RESTART,
        SCORE,
        EXIT
    };

    Timer timer = new Timer(15, this);
    static STATE state = STATE.MENU;
    public Game() {
        int score = 0;
        startMenu = new StartMenu();
        scoreMenu = new Score();
        restartMenu = new Restart();
        scorePanel = new Score();

        obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);
        obstacle2 = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);
        obstacle3 = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);



        timer.start();

        player = new Player(150, 360);


        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(startMenu);
        addMouseListener(scoreMenu);
        addMouseListener(restartMenu);
    }

    public void background(Graphics g,String filepath){
        ImageIcon imageIcon = new ImageIcon(filepath);
        Image image = imageIcon.getImage();
        g.drawImage(image,0,0,Project.WIDTH,Project.HEIGHT,null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        switch (state) {
            case MENU:
                startMenu.draw(g);
                play = true;

                break;
            case GAME:
                background(g,"image/Play.png");

                if (score < 10){
                    obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);
                }else{
                    obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 50, 360);

                }

                obstacle.draw(g);
                player.draw(g);
                break;
            case SCORE:
               scorePanel.draw(g);

                break;
            case GAME_RESTART:
                new Game();
                play = true;
//                timer.restart();
                restartMenu.draw(g);
                break;
            case EXIT:
                    System.exit(0);
                break;
            default:
                // do nothing
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (state) {
            case GAME:
                if (play) {
                    score = score+2;
                    int sumScore = score / 15;

//                    System.out.println("Score:" + sumScore);
                    player.update();
                    if (player.isFall() && player.getY() >= 360) {
                        player.setY(360);
                        player.setSpeedY(0);
                        player.setFall(false);
                        player.setJump(true);


                    }
                    if (player.getX() + 30 >= obstacle.getX() - 30) {
                        Game.state = STATE.GAME_RESTART;
                    }
                }
            default:
                repaint();
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