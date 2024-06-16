package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkers Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        Currentsquers currentsquers = new Currentsquers();
        MyPanel myPanel = new MyPanel(currentsquers);
        frame.add(myPanel);
        frame.setVisible(true);
        Game game = new Game(currentsquers,myPanel.getBPanel());
        game.start();
        while (true) {
            game.update();
        }
        
    }
}
    class MyPanel extends JPanel {
        private BoardPanel boardPanel;
        public MyPanel(Currentsquers currentsquers) {
            setLayout(new BorderLayout());

            // Create buttons
            JButton startButton = new JButton("Start");
            // JButton stopButton = new JButton("Stop");
            // JButton PauseButton = new JButton("Pause");
            //create a  player 1
            Player player1 = new Player("white");
            //create a player 2
            Player player2 = new Player("black");
            JLabel  p1_points = new JLabel("Player 1: "+player1.getPoints());
            JLabel  p2_points = new JLabel("Player 2: "+player2.getPoints());
            //create a new board
            Board board = new Board();
            //create a new squares with loop and and with the pieces

            
            // Create board panel
            BoardPanel boardPanel = new BoardPanel(board, currentsquers);
            JPanel panel = boardPanel.makJPanel(player1, player2);
            boardPanel.render();

            // Add buttons and board panel to the main panel
            JPanel buttons = new JPanel();
            buttons.setLayout(new GridLayout(1, 1));
            startButton.setBackground(new Color(207, 199, 245));
            // stopButton.setBackground(new Color(207, 199, 245));
            startButton.setFont(new Font("Ariel", Font.BOLD, 20));
            // stopButton.setFont(new Font("Ariel", Font.BOLD, 20));
            buttons.add(startButton);
            // buttons.add(stopButton);
            add(buttons, BorderLayout.SOUTH);
            add(panel, BorderLayout.CENTER);
            JPanel points= new JPanel();
            p1_points.setFont(new Font("Ariel", Font.BOLD, 20));
            p2_points.setFont(new Font("Ariel", Font.BOLD, 20));
            points.add(p1_points, BorderLayout.NORTH);
            points.add(p2_points, BorderLayout.NORTH);
            add(points, BorderLayout.NORTH);

            // Add action listeners to the buttons
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle start button click
                }
            });
        }

        public BoardPanel getBPanel() {
            return boardPanel;
        }
    }
