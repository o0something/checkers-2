package src;
/**
 * Represents a piece in the game.
 */
/**
 * The Piece class represents a game piece in a checkers game.
 */
public class Piece {
    public Position pos;
    private boolean isKing;
    public Player player;
    private static int White_y = 7;
    private static int Black_y = 0;
    private String symbol;

    /**
     * Constructs a new Piece object with the specified player.
     * 
     * @param player the player who owns the piece
     */
    public Piece(Player player) {
        this.player = player;
        this.isKing = false;
        if (player.color == "black") {
            this.symbol = "♥";
        } else if (player.color == "white") {
            this.symbol = "♡";
        }
    }

    /**
     * Constructs a new empty Piece object.
     */
    public Piece() {
        this.isKing = false;
        this.symbol = " ";
        this.player = null;
    }

    /**
     * Moves the piece to the specified position.
     * 
     * @param new_pos the new position to move the piece to
     */
    public void move(Square new_pos) {
        if ((new_pos.getY() == White_y && player.color.equals("white")) || (new_pos.getY() == Black_y && player.color.equals("black"))) {
            setIsKing(true);
        }
        this.pos = new_pos.pos;
    };

    /**
     * Returns the current position of the piece.
     * 
     * @return the current position of the piece
     */
    public Position getPos() {
        return pos;
    };

    /**
     * Returns whether the piece is a king.
     * 
     * @return true if the piece is a king, false otherwise
     */
    public boolean getIsKing() {
        return isKing;
    };

    /**
     * Sets whether the piece is a king.
     * 
     * @param isKing true if the piece is a king, false otherwise
     */
    public void setIsKing(boolean isKing) {
        this.isKing = isKing;
        if (player.color == "black") {
            this.symbol = "♛";
        } else if (player.color == "white") {
            this.symbol = "♕";
        }
    };

    /**
     * Returns the symbol representing the piece.
     * 
     * @return the symbol representing the piece
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the symbol representing the piece.
     * 
     * @param symbol the symbol representing the piece
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}