package src;
import java.util.HashMap;

public class Player {
    public String color;
    private int points;
    private HashMap<Piece, Position> Pieces = new HashMap<Piece,Position>();
    public Player(String color){
        this.color=color;
    }

    public void addPiece(Piece piece, Position pos){
        Pieces.put(piece, pos);
    }

    public HashMap<Piece, Position> getPieces(){
        return Pieces;
    }

    public void addPoints(int points){
        this.points+=points;
    }

    public int getPoints(){
        return points;
    }

    public void makeMove(Piece piece, Square new_pos){
        piece.move(new_pos);
    }
}
