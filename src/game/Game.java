package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

public class Game extends JPanel implements ActionListener, KeyListener{
    private static final long serialVersionUID = 1L;

    private Score scoreMenu;
    private StartMenu startMenu;
    private GameOver gameOverMenu;
    private Score scorePanel;
    private PlayGame playGamePanel;


    private Player player;
    private Obstacle obstacle,obstacle2,obstacle3;

    private Random rand = new Random();
    private int score;
    private boolean play;
    private int startSpeed = 250;

//    private JLabel scoreLabel;
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
        startMenu = new StartMenu();
        scoreMenu = new Score();
        gameOverMenu = new GameOver();
        scorePanel = new Score();
        playGamePanel = new PlayGame();

        obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);
//        obstacle2 = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);
//        obstacle3 = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);



        timer.start();

        player = new Player(150, 360);


        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(startMenu);
        addMouseListener(scoreMenu);
        addMouseListener(gameOverMenu);
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

                playGamePanel.draw(g);
                if(score < 200){
                    obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);
                } else {
                    obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 100, 360);
                }



                obstacle.draw(g);
                player.draw(g);
                break;
            case SCORE:
               scorePanel.draw(g);
                break;
            case GAME_OVER:
                new Game();
                play = true;
                gameOverMenu.draw(g);
                System.out.println("Game over");
//                repaint();
//                timer.restart();
                break;
            case GAME_RESTART:

//                score = 0;
                player = new Player(150, 360);
                playGamePanel.draw(g);
                if (score < 10){
                    obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 250, 360);
                }else{
                    obstacle = new Obstacle(rand.nextInt(Project.WIDTH) + 50, 360);

                }

                System.out.println("Case Game restart ");
                obstacle.draw(g);
                player.draw(g);
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
            case GAME_RESTART:
            case GAME:
                if (play) {
                    score = score+2;
                    int sumScore = score / 15;
                    System.out.println("Score" + score);
                    player.update();
                    if (player.isFall() && player.getY() >= 360) {
                        player.setY(360);
                        player.setSpeedY(0);
                        player.setFall(false);
                        player.setJump(true);


                    }
                    if (player.getX() + 30 >= obstacle.getX() - 30) {
                        Game.state = STATE.GAME_OVER;
                        System.out.println("Change to Game over !");
                    }
                }
            default:
                System.out.println(state + " " + new Date());
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