package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui {
    public static void main(String[] args) {
        // Create a new game
        // Game game = new Game();
        // Start the game
        // game.start();
        // Create a new frame
        JFrame frame = new JFrame("Checkers Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new MyPanel());
        frame.setVisible(true);
        
    }

    public static class MyPanel extends JPanel {
        public MyPanel() {
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
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    String color;
                    if ((i + j) % 2 == 0) {
                        color = "white";
                    } else {
                        color = "black";
                    }
                    Square square = new Square(new Position(j, i), color);
                    if (color.equals("black")) {
                        if (i < 3) {
                            Piece piece = new Piece(player1);
                            square.add_piece(piece);
                        } else if (i > 4) {
                            Piece piece = new Piece(player2);
                            square.add_piece(piece);
                        }
                    }
                    board.add_square(square.getSquare());
                }
            }
            
            JPanel boardPanel = new BoardPanel(board).getPanel();

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
            add(boardPanel, BorderLayout.CENTER);
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
    }
    }
