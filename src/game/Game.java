package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game extends JPanel implements ActionListener, KeyListener{
    private static final long serialVersionUID = 1L;

    private Score scoreMenu;
    private StartMenu startMenu;
    private GameOver gameOverMenu;
    private Score scorePanel;
    private PlayGame playGamePanel;


    private Player player;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();

    private Random rand = new Random();
    private int score;
    private boolean play;
    private int startSpeed = 250;
    private int tickCount = 0, sumScore = 0, speed = 30;

    //private JLabel scoreLabel;
    enum STATE {
        MENU,
        GAME,
        GAME_RESTART,
        GAME_OVER,
        SCORE,
        EXIT
    };

    Timer timer = new Timer(20, this);
    static STATE state = STATE.MENU;
    public Game() {
        int score = 0;
        startMenu = new StartMenu(this);
        scoreMenu = new Score(this);
        gameOverMenu = new GameOver(this);
        scorePanel = new Score(this);
        playGamePanel = new PlayGame();

        timer.start();

        player = new Player(150, 360);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(startMenu);
        addMouseListener(scoreMenu);
        addMouseListener(gameOverMenu);
        setState(STATE.MENU);
    }

    public void setState(STATE newstate) {
        System.out.println("Change new state form "+state+" to "+newstate);
        state = newstate;
        switch (state) {
            case MENU:
                play = true;
                break;
            case GAME:
                obstacles.clear();
                tickCount = 0;
                break;
            case GAME_OVER:
                break;
            case EXIT:
                System.exit(0);
                break;
        }
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
                if (tickCount % speed == 0) {
                    tickCount = 0;
                    obstacles.add(new Obstacle(860, 360));
                }
                switch (sumScore){
                    case 10:
                        speed = 20;
                        break;
                    case 100:
                        speed = 10;
                        break;
                    default:
                        break;
                }

                playGamePanel.draw(g);

                player.draw(g);
                obstacles.forEach(obstacle -> {
                    obstacle.move();
                    obstacle.draw(g);
                    if (120 <= obstacle.getX() && 180 >= obstacle.getX() && player.getY() >= 300) {
                        setState(STATE.GAME_OVER);
                        score = 0;
                        sumScore = 0;
                    }
                });
                obstacles = obstacles.stream().filter(obstacle -> obstacle.getX() >= -60).collect(Collectors.toList());
                break;
            case SCORE:
               scorePanel.draw(g);
                break;
            case GAME_OVER:
                gameOverMenu.draw(g);
                break;
            case GAME_RESTART:
                player = new Player(150, 360);
                playGamePanel.draw(g);
                player.draw(g);
                break;
            default:
        }
        tickCount++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (state) {
            case GAME_RESTART:
            case GAME:
                if (play) {
                    score = score+2;
                    sumScore = score / 15;
                    System.out.println(" Score: "+sumScore);
                    player.update();
                    if (player.isFall() && player.getY() >= 360) {
                        player.setY(360);
                        player.setSpeedY(0);
                        player.setFall(false);
                        player.setJump(true);
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