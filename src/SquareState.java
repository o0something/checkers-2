package src;

import java.awt.event.MouseListener;

public class SquareState implements MouseListener {
    private Square square;
    private Currentsquers currentsquers;

    public SquareState(Square square, Currentsquers currentsquers){
        square.buttonSquare.addMouseListener(this);
        this.square=square;
        this.currentsquers=currentsquers;
        
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("selected square is "+square.pos.getX()+","+square.pos.getY());
        if (currentsquers.size()<3){
            currentsquers.addSquare(square);
        }   

    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

}
