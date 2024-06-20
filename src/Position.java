package src;
/**
 * Represents a position on the board.
 */

/**
 * The Position class represents a position on a two-dimensional grid.
 */
public class Position {
    private int x;
    private int y;

    /**
     * Constructs a new Position object with the specified x and y coordinates.
     * 
     * @param x the x-coordinate of the position
     * @param y the y-coordinate of the position
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the position.
     * 
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the position.
     * 
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }
}

