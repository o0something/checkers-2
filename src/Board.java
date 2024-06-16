package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<Square> squares;
    
    public Board(){
        squares = new ArrayList<Square>();
    }

    public void remove_piece(Piece piece, Position pos){
        for (Square square : squares){
            if (square.pos.getX() == pos.getX() && square.pos.getY() == pos.getY()){
                square.remove_piece();
            }
        }
    }   

    public ArrayList<Square> getSquares(){
        return squares;
    }

    public void add_square(Square square){
        squares.add(square);
    }

    public void add_piece(Piece piece, Position pos){
        for (Square square : squares){
            if (square.pos.getX() == pos.getX() && square.pos.getY() == pos.getY()){
                square.add_piece(piece);
            }
        }
    }

}
