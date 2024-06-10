package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Square {
    private Piece piece;
    public Position pos;
    public SquareState state;
    public JButton buttonSquare;
    public String color;
    
    public Square(Position pos, String color){
        this.pos=pos;
        buttonSquare = new JButton();
        buttonSquare.setFont(new Font("Ariel", Font.PLAIN, 50));
        if (color=="black"){
            buttonSquare.setBackground(new Color(255,255,255));
        }else{  
            buttonSquare.setBackground(new Color(0,0,0));
        }
    }

    public SquareState getState(){
        return state;
    }

    public void changState(SquareState newState){
        this.state=newState;
    }

    public void add_piece(Piece piece){
        this.piece=piece;
        buttonSquare.setText(piece.getSymbol());
    }   

    // public void remove_piece(){
    //     this.piece=null;
    // }

    public Square getSquare(){
        return this;
    }

    public JButton getButton(){
        return buttonSquare;
    }

    public int getX(){
        return pos.getX();
    }

    public int getY(){
        return pos.getY();
    }
}
