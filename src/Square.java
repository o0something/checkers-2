package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Square {
    private Piece piece;
    public Position pos;
    public SquareState state;
    private String stateName;
    private Currentsquers currentsquers;
    public JButton buttonSquare;
    public String color;
    
    public Square(Position pos, String color, Currentsquers currentsquers){
        this.pos=pos;
        buttonSquare = new JButton();
        buttonSquare.setFont(new Font("Ariel", Font.PLAIN, 45));
        if (color=="black"){
            buttonSquare.setBackground(new Color(255,255,255));
        }else{  
            buttonSquare.setBackground(new Color(0,0,0));
        }
        this.currentsquers=currentsquers;
    }

    public SquareState getState(){
        return state;
    }

    public void changState(String newState){
        this.stateName=newState;
    }

    public void add_piece(Piece piece){
        if(piece!=null){
            this.piece=piece;
            buttonSquare.setText(piece.getSymbol());
        }
    }   

    public void remove_piece(){
        this.piece=null;
    }

    public Square getSquare(){
        return this;
    }

    public JButton getButton(){
        return buttonSquare;
    }

    public Piece getPiece(){
        return piece;
    }
    
    public int getX(){
        return pos.getX();
    }

    public int getY(){
        return pos.getY();
    }

    public void update(){
        if (this.piece!=null){
            buttonSquare.setText(piece.getSymbol());
        }else{
            buttonSquare.setText("");
        }
    }

    public void setext(Piece piece){
        buttonSquare.setText(piece.getSymbol());
    }

    public void event(){
        buttonSquare.addMouseListener(new SquareState(this, this.currentsquers));
        changState("unselected");
    }

    public void render(JPanel f) {
        getButton().setBounds(pos.getX(), pos.getY(), 50, 50);
        f.add(getButton());
    }
}
