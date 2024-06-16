package src;

import java.awt.event.MouseListener;

public class SquareState implements MouseListener {
    private Square square;
    private String state;
    private Currentsquers currentsquers;

    public SquareState(Square square, Currentsquers currentsquers){
        square.buttonSquare.addMouseListener(this);
        this.square=square;
        this.currentsquers=currentsquers;
        state="unselected";
        
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("selected square is "+square.pos.getX()+","+square.pos.getY());
        state="selected";
        if (state=="selected"&&currentsquers.size()<3){
            currentsquers.addSquare(square);
        }   
        else if (state=="unselected"){
           
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

    // state unselected

    public void unselected(){
        state="unselected";
    }

    public String getState(){
        return state;
    }

}
