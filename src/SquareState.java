package src;

import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;

public class SquareState implements ActionListener {
    private Square square;
    public SquareState(Square square){
        square.buttonSquare.addActionListener(this);
        this.square=square;
    }
    
    public void actionPerformed(ActionEvent ae) {
        System.out.println("selected square is "+square.pos.getX()+","+square.pos.getY());
    } 
    
    

}
