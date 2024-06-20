package src;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents a square on a checkers board.
 */
public class Square {
    private Piece piece;
    public Position pos;
    public SquareState state;
    private Currentsquers currentsquers;
    public JButton buttonSquare;
    public String color;

    /**
     * Constructs a Square object with the specified position, color, and current squares.
     *
     * @param pos            the position of the square
     * @param color          the color of the square
     * @param currentsquers  the current squares object
     */
    public Square(Position pos, String color, Currentsquers currentsquers) {
        this.pos = pos;
        this.color = color;
        buttonSquare = new JButton();
        buttonSquare.setFont(new Font("Ariel", Font.PLAIN, 45));
        if (color.equals("black")) {
            buttonSquare.setBackground(new Color(66, 245, 230));
        } else {
            buttonSquare.setBackground(new Color(255, 219, 246));
        }
        this.currentsquers = currentsquers;
    }

    /**
     * Returns the state of the square.
     *
     * @return the state of the square
     */
    public SquareState getState() {
        return state;
    }

    /**
     * Adds a piece to the square.
     *
     * @param piece  the piece to be added
     */
    public void add_piece(Piece piece) {
        this.piece = piece;
        buttonSquare.setText(piece.getSymbol());
    }

    /**
     * Removes the piece from the square.
     */
    public void remove_piece() {
        this.piece = new Piece();
        buttonSquare.setText(this.piece.getSymbol());
    }

    /**
     * Returns the current square.
     *
     * @return the current square
     */
    public Square getSquare() {
        return this;
    }

    /**
     * Returns the button associated with the square.
     *
     * @return the button associated with the square
     */
    public JButton getButton() {
        return buttonSquare;
    }

    /**
     * Returns the piece on the square.
     *
     * @return the piece on the square
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Returns the x-coordinate of the square.
     *
     * @return the x-coordinate of the square
     */
    public int getX() {
        return pos.getX();
    }

    /**
     * Returns the y-coordinate of the square.
     *
     * @return the y-coordinate of the square
     */
    public int getY() {
        return pos.getY();
    }

    /**
     * Returns the position of the square.
     *
     * @return the position of the square
     */
    public Position getPos() {
        return pos;
    }

    /**
     * Updates the button text with the symbol of the piece on the square.
     */
    public void update() {
        buttonSquare.setText(piece.getSymbol());
    }

    /**
     * Sets the button text with the symbol of the specified piece.
     *
     * @param piece  the piece to set the button text with
     */
    public void setext(Piece piece) {
        buttonSquare.setText(piece.getSymbol());
    }

    /**
     * Adds a mouse listener to the square button.
     */
    public void event() {
        buttonSquare.addMouseListener(new SquareState(this, this.currentsquers));
    }

    /**
     * Renders the square button on the specified panel.
     *
     * @param f  the panel to render the square button on
     */
    public void render(JPanel f) {
        getButton().setBounds(pos.getX(), pos.getY(), 50, 50);
        f.add(getButton());
    }
}
