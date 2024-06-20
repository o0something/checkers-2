package src;    
/**
 * Represents the state of a square on the board.
/* */

import java.awt.event.MouseListener;
/**
 * The SquareState class represents the state of a square in a checkers game.
 * It implements the MouseListener interface to handle mouse events on the square.
 */
public class SquareState implements MouseListener {
    private Square square;
    private Currentsquers currentsquers;

    /**
     * Constructs a SquareState object with the specified square and currentsquers.
     * It also adds the current object as a mouse listener to the square's button.
     *
     * @param square The square object associated with this state.
     * @param currentsquers The Currentsquers object to store the selected squares.
     */
    public SquareState(Square square, Currentsquers currentsquers){
        square.buttonSquare.addMouseListener(this);
        this.square=square;
        this.currentsquers=currentsquers;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on the square.
     * Prints the position of the selected square and adds it to the currentsquers if there is space.
     *
     * @param e The MouseEvent object containing information about the mouse event.
     */
    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("selected square is "+square.pos.getX()+","+square.pos.getY());
        if (currentsquers.size()<3){
            currentsquers.addSquare(square);
        }
    }

    /**
     * Invoked when the mouse enters the square.
     *
     * @param e The MouseEvent object containing information about the mouse event.
     */
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when the mouse exits the square.
     *
     * @param e The MouseEvent object containing information about the mouse event.
     */
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when a mouse button has been pressed on the square.
     *
     * @param e The MouseEvent object containing information about the mouse event.
     */
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when a mouse button has been released on the square.
     *
     * @param e The MouseEvent object containing information about the mouse event.
     */
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }
}
