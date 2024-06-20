package src;

import javax.swing.*;
import java.awt.*;
/**
 * Main GUI class for the game.
 */
public class Gui {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkers Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        Currentsquers currentsquers = new Currentsquers();
        MyPanel myPanel = new MyPanel(currentsquers);
        frame.add(myPanel);
        frame.setVisible(true);
        Game game = new Game(currentsquers, myPanel.getBPanel(), myPanel.player1, myPanel.player2);
        game.start();
        while (true) {
            game.update();
            myPanel.move1.setText(currentsquers.getPosStart());
            myPanel.p1_points.setText("Player White: " + myPanel.player1.getPoints() + " ");
            myPanel.p2_points.setText("Player Black: " + myPanel.player2.getPoints() + " ");
            myPanel.currentplayer.setText("Current Player: " + "<" + game.getCurentPlayerName() + "> ");
        }

    }
}

/**
 * Represents a custom panel for the checkers game.
 * Extends the JPanel class.
 */
class MyPanel extends JPanel {
    private BoardPanel boardPanel;
    public Player player1;
    public Player player2;
    public JLabel move1;
    public JLabel p1_points;
    public JLabel p2_points;
    public JLabel currentplayer;

    public MyPanel(Currentsquers currentsquers) {
        setLayout(new BorderLayout());
        // create a player 1
        this.player1 = new Player("white");
        // create a player 2
        this.player2 = new Player("black");
        this.p1_points = new JLabel("Player White: " + player1.getPoints() + " ");
        this.p2_points = new JLabel("Player Black: " + player2.getPoints() + " ");
        this.currentplayer = new JLabel("Current Player: " + "<White>");
        // making a tab with cuurent squers selected
        JLabel moves = new JLabel("Selected : ");
        this.move1 = new JLabel(currentsquers.getPosStart());
        // create a new board
        Board board = new Board();
        // create a new squares with loop and and with the pieces

        // Create board panel
        this.boardPanel = new BoardPanel(board, currentsquers);
        JPanel panel = boardPanel.makJPanel(player1, player2);
        boardPanel.render();

        // Add buttons and board panel to the main panel
        add(panel, BorderLayout.CENTER);
        // add the points of the players
        JPanel points = new JPanel();
        p1_points.setFont(new Font("Ariel", Font.BOLD, 20));
        p2_points.setFont(new Font("Ariel", Font.BOLD, 20));
        currentplayer.setFont(new Font("Ariel", Font.BOLD, 20));
        points.add(p1_points, BorderLayout.NORTH);
        points.add(p2_points, BorderLayout.NORTH);
        points.add(currentplayer, BorderLayout.NORTH);
        add(points, BorderLayout.NORTH);
        // add the tab with the current squers
        JPanel movesPanel = new JPanel(new GridLayout(1, 2));
        moves.setFont(new Font("Ariel", Font.BOLD, 20));
        this.move1.setFont(new Font("Ariel", Font.BOLD, 20));
        movesPanel.add(moves);
        movesPanel.add(this.move1);
        points.add(movesPanel, BorderLayout.WEST);

    }

    public BoardPanel getBPanel() {
        return boardPanel;
    }
}
