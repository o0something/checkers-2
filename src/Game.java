package src;

import java.lang.reflect.Array;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class Game {
    private BoardPanel boardPanel;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isRunning;
    private Currentsquers currentsquers;
    
    public Game(Currentsquers currentsquers,BoardPanel boardPanel){
        // this.player1 = player1;
        // this.player2 = player2;
        // this.currentPlayer = player1;
        this.boardPanel = boardPanel;
        this.currentsquers=currentsquers;
        this.isRunning = true;
    }

    public void make_move(){
        if (currentsquers.size() == 2) {
            Square start = currentsquers.getStart();
            Square end = currentsquers.getEnd();
            if (start.getPiece() != null) {
                end.add_piece(start.getPiece());
                start.remove_piece();
                end.changState("unselected");
                start.changState("unselected");
                currentsquers.clear();
                switch_player();
            } else {
                System.out.println("No piece at the start square.");
            }
        }
        currentsquers.update();
    }

    public void switch_player(){
        if (currentPlayer == player1){
            currentPlayer = player2;
        }else{
            currentPlayer = player1;
        }
    }

    public boolean check_move(Square start, Square end){
        return true;
    }

    public void start(){
        isRunning = true;
    }

    public void update(){
        if (isRunning){
            System.out.println( );
            // //update the board
            make_move();

        }

    }
}
