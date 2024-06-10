package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<Square> squares;
    
    public Board(){
        squares = new ArrayList<Square>();
    }
    public void add_square(Piece piece, Position pos){
        //logic to add a piece and i thik a will do its so a square changes from free to occupide
        // so from  thsi "" to "0"
    }
    public void remove_piece(Piece piece, Position pos){

    }   

    public ArrayList<Square> getSquares(){
        return squares;
    }

    public void add_square(Square square){
        squares.add(square);
    }
}
