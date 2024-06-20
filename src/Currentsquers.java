package src;

import java.util.ArrayList;
/**
 * Manages the current squares on the board.
 */
/**
 * The Currentsquers class represents a collection of squares that are currently selected.
 * It provides methods to add squares, clear the collection, and retrieve information about the selected squares.
 */
public class Currentsquers {
    private ArrayList<Square> currentsquers = new ArrayList<>(2);

    /**
     * Constructs an empty Currentsquers object.
     */
    public Currentsquers() {
    }

    /**
     * Adds a square to the collection if it meets the specified conditions.
     * The square must not already be in the collection, and the collection must have either no squares with a player or only one square without a player.
     * 
     * @param square the square to be added
     */
    public void addSquare(Square square) {
        if (!currentsquers.contains(square)) {
            if (square.getPiece().player != null && currentsquers.size() == 0) {
                System.out.println("Adding square: " + square);
                currentsquers.add(square);
            } else if (square.getPiece().player == null && currentsquers.size() == 1) {
                System.out.println("Adding square: " + square);
                currentsquers.add(square);
            }
        }
    }

    /**
     * Clears the collection of squares.
     */
    public void clear() {
        currentsquers.clear();
    }

    /**
     * Returns the number of squares in the collection.
     * 
     * @return the number of squares in the collection
     */
    public int size() {
        return currentsquers.size();
    }

    /**
     * Returns the first square in the collection.
     * 
     * @return the first square in the collection, or null if the collection is empty
     */
    public Square getStart() {
        return currentsquers.size() > 0 ? currentsquers.get(0) : null;
    }

    /**
     * Returns the second square in the collection.
     * 
     * @return the second square in the collection, or null if the collection has less than two squares
     */
    public Square getEnd() {
        return currentsquers.size() > 1 ? currentsquers.get(1) : null;
    }

    /**
     * Returns the position of the first square in the collection as a string in the format "x,y".
     * If the collection is empty, it returns "null".
     * 
     * @return the position of the first square in the collection, or "null" if the collection is empty
     */
    public String getPosStart() {
        if (size() == 0) {
            return "null";
        } else {
            return (currentsquers.get(0).getX() + "," + currentsquers.get(0).getY());
        }
    }

    /**
     * Returns the position of the second square in the collection as a string in the format "x,y".
     * If the collection has less than two squares, it returns "null".
     * 
     * @return the position of the second square in the collection, or "null" if the collection has less than two squares
     */
    public String getPosEnd() {
        if (size() <= 1) {
            return "null";
        } else {
            return (currentsquers.get(1).getX() + "," + currentsquers.get(1).getY());
        }
    }
}
