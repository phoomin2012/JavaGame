package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

public class Score implements MouseListener {


    public void draw(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("image/Score.png");
        Image image = imageIcon.getImage();
        g.drawImage(image,0,0,Project.WIDTH,Project.HEIGHT,null);
        System.out.println(Game.state);
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


        if(Game.state == Game.STATE.SCORE){
//        Button Play
            if(mouseX >= 681  && mouseY >= 379 && mouseX <= 836 && mouseY <= 448){
                Game.state = Game.STATE.MENU;
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