package game;

import javax.swing.*;

public class Project {
    public static Project project;
    public Game game = new Game();
    public final static int WIDTH = 860;
    public final static int HEIGHT = 480;

    public Project() {
        JFrame window = new JFrame();

//        window.setUndecorated(true);
        window.add(game);
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        project = new Project();
        System.out.println("StartGame !");
    }
}
