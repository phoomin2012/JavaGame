package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

public class StartMenu implements MouseListener {


    public void draw(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("image/Menu.png");
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
        System.out.println("X : " + mouseX + " Y : " + mouseY);


    if(Game.state == Game.STATE.MENU){
//        Button Play
        if(mouseX >= 358 && mouseY >= 330 && mouseX <= 505 && mouseY <= 410){
            Game.state = Game.STATE.GAME;
//            System.out.println("Button 1");
        }
//        Button Score
        if(mouseX >= 85 && mouseY >= 330 && mouseX <= 235 && mouseY <= 410){
            Game.state = Game.STATE.SCORE;
            System.out.println(Game.state);
//            System.out.println("Button 2");
        }
        //        Button Exit
        if(mouseX >= 633  && mouseY >= 330 && mouseX <= 788 && mouseY <= 410){
           Game.state = Game.STATE.EXIT;
//            System.out.println("Button 3");
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