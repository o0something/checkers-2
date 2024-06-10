package src;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class BoardPanel {
    private Board board;
    private JPanel panel;

    public BoardPanel(Board board){
        this.board=board;
        panel = new JPanel();
        panel.setLayout(new GridLayout(8,8));
        for (Square square : board.getSquares()) {
            SquareSprite sprite = new SquareSprite(square);
            sprite.paint(panel);
            sprite.event();
        }
    }

    public JPanel getPanel(){
        return panel;
    }

    public void update(){
        //update the board
    }

    public void paint(JPanel panel){
        //paint the board
        for (Square square : board.getSquares()) {
            SquareSprite sprite = new SquareSprite(square);
            sprite.paint(panel);
            sprite.event();
        }
    }

}
