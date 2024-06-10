package src;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;


public class SquareSprite implements Sprite{
    private Position pos;
    private Square square;
    private JButton buttonSquare;
    public SquareSprite(Square square){
        this.square=square;
        this.pos=square.pos;
        this.buttonSquare=square.getButton();

    }

    public JButton getButton(){
        return buttonSquare;
    }
    public void update(){
    }

    public void event(){
        SquareState squareState = new SquareState(square);
        square.getButton().addActionListener(squareState);
    }

    @Override
    public void paint(JPanel f) {
        square.getButton().setBounds(pos.getX(), pos.getY(), 50, 50);
        f.add(square.getButton());
    }


}
