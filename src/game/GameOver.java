package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class GameOver implements MouseListener {

    private Game IGame;

    public GameOver(Game game) {
        IGame = game;
    }

    public void draw(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("image/GameOver.png");
        Image image = imageIcon.getImage();
        g.drawImage(image,0,0,Project.WIDTH,Project.HEIGHT,null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if(IGame.state == Game.STATE.GAME_OVER) {
            /* Button Play Again */
            if(mouseX >= 263  && mouseY >= 284 && mouseX <= 395 && mouseY <= 332) {
                IGame.setState(Game.STATE.GAME);
                /* Exit */
            } else if(mouseX >= 484  && mouseY >= 285 && mouseX <= 613 && mouseY <= 332) {
                IGame.setState(Game.STATE.EXIT);
            }
        }
    }




    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}