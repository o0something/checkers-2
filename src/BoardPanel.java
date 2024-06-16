package src;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;

public class BoardPanel {
    private Board board;
    private JPanel panel;
    private Currentsquers currentsquers;
    private ArrayList<Square> squares= new ArrayList<Square>();

    public BoardPanel(Board board, Currentsquers currentsquers){
        this.board=board;
        panel = new JPanel();
        panel.setLayout(new GridLayout(8,8));
        this.currentsquers=currentsquers;
    }

    public JPanel getPanel(){
        return panel;
    }

    public void update(){
        //update the board
        for (Square sprite : squares) {
            sprite.update();
        }
    }

    public void render(){
        //paint the board
        for (Square square : board.getSquares()) {
            squares.add(square);
            square.render(panel);
            square.event();
        }
    }

    public JPanel makJPanel(Player player1, Player player2){
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
                    }else{
                        square.add_piece(new Piece());
                    }
                }
                else{
                    square.add_piece(new Piece());
                }
                board.add_square(square.getSquare());
            }
        }
        return panel;
    }
}
