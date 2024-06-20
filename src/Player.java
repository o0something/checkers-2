package src;

import java.util.HashMap;
/**
 * Represents a player in the game.
 */

/**
 * The Player class represents a player in a game.
 */
public class Player {
    public String color;
    private int points;
    private HashMap<Piece, Position> Pieces = new HashMap<Piece, Position>();

    /**
     * Constructs a new Player object with the specified color.
     *
     * @param color the color of the player
     */
    public Player(String color) {
        this.color = color;
    }

    /**
     * Adds a piece to the player's collection with the specified position.
     *
     * @param piece the piece to be added
     * @param pos   the position of the piece
     */
    public void addPiece(Piece piece, Position pos) {
        Pieces.put(piece, pos);
    }

    /**
     * Returns the collection of pieces owned by the player.
     *
     * @return the collection of pieces
     */
    public HashMap<Piece, Position> getPieces() {
        return Pieces;
    }

    /**
     * Adds the specified number of points to the player's score.
     *
     * @param points the number of points to be added
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Returns the player's current score.
     *
     * @return the player's score
     */
    public int getPoints() {
        return points;
    }
}
