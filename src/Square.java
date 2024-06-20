package src;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Square {
    private Piece piece;
    public Position pos;
    public SquareState state;
    private Currentsquers currentsquers;
    public JButton buttonSquare;
    public String color;

    public Square(Position pos, String color, Currentsquers currentsquers) {
        this.pos = pos;
        this.color = color;
        buttonSquare = new JButton();
        buttonSquare.setFont(new Font("Ariel", Font.PLAIN, 45));
        if (color == "black") {
            buttonSquare.setBackground(new Color(66, 245, 230));
        } else {
            buttonSquare.setBackground(new Color(255, 219, 246));
        }
        this.currentsquers = currentsquers;
    }

    public SquareState getState() {
        return state;
    }

    public void add_piece(Piece piece) {
        this.piece = piece;
        buttonSquare.setText(piece.getSymbol());
    }

    public void remove_piece() {
        this.piece = new Piece();
        buttonSquare.setText(this.piece.getSymbol());
    }

    public Square getSquare() {
        return this;
    }

    public JButton getButton() {
        return buttonSquare;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getX() {
        return pos.getX();
    }

    public int getY() {
        return pos.getY();
    }

    public Position getPos() {
        return pos;
    }

    public void update() {
        buttonSquare.setText(piece.getSymbol());
    }

    public void setext(Piece piece) {
        buttonSquare.setText(piece.getSymbol());
    }

    public void event() {
        buttonSquare.addMouseListener(new SquareState(this, this.currentsquers));
    }

    public void render(JPanel f) {
        getButton().setBounds(pos.getX(), pos.getY(), 50, 50);
        f.add(getButton());
    }
}
