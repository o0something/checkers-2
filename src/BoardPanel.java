package src;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
/**
 * A panel that displays the game board.
 */
/**
 * The BoardPanel class represents a panel that displays the game board and handles rendering and updating of the squares.
 */
public class BoardPanel {
    // instance variables
    private Board board;
    private JPanel panel;
    private Currentsquers currentsquers;
    private ArrayList<Square> squares = new ArrayList<Square>();

    /**
     * Constructs a new BoardPanel object with the specified board and current squares.
     * 
     * @param board the board to display
     * @param currentsquers the current squares
     */
    public BoardPanel(Board board, Currentsquers currentsquers) {
        this.board = board;
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        this.currentsquers = currentsquers;
    }

    /**
     * Retrieves the board associated with this BoardPanel.
     * 
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Retrieves the panel associated with this BoardPanel.
     * 
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Updates the squares on the board.
     */
    public void update() {
        // update the board
        for (Square sprite : squares) {
            sprite.update();
        }
    }

    /**
     * Renders the squares on the board.
     */
    public void render() {
        // paint the board
        for (Square square : board.getSquares()) {
            squares.add(square);
            square.render(panel);
            square.event();
        }
    }

    /**
     * Creates and initializes the board with squares and pieces.
     * 
     * @param player1 the first player
     * @param player2 the second player
     * @return the panel containing the board
     */
    public JPanel makJPanel(Player player1, Player player2) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String color;
                if ((i + j) % 2 == 0) {
                    color = "white";
                } else {
                    color = "black";
                }
                Square square = new Square(new Position(j, i), color, currentsquers);
                if (color.equals("black")) {
                    if (i < 3) {
                        Piece piece = new Piece(player1);
                        player1.addPiece(piece, new Position(j, i));
                        square.add_piece(piece);
                    } else if (i > 4) {
                        Piece piece = new Piece(player2);
                        player2.addPiece(piece, new Position(j, i));
                        square.add_piece(piece);
                    } else {
                        square.add_piece(new Piece());
                    }
                } else {
                    square.add_piece(new Piece());
                }
                board.add_square(square.getSquare());
            }
        }
        return panel;
    }

    /**
     * Retrieves the list of squares on the board.
     * 
     * @return the list of squares
     */
    public ArrayList<String> getSquares() {
        ArrayList<String> positions = new ArrayList<>();
        for (Square square : squares) {
            positions.add("(" + square.getPos().getX() + " , " + square.getPos().getY() + ") " + " )");
        }
        return positions;
    }

    /**
     * Retrieves the square at the specified position.
     * 
     * @param x the x-coordinate of the position
     * @param y the y-coordinate of the position
     * @return the square at the specified position, or null if not found
     */
    public Square getSquare(int x, int y) {
        Position pos = new Position(x, y);
        for (Square square : squares) {
            if (square.getPos().equals(pos)) {
                return square;
            }
        }
        return null;
    }
}
