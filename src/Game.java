package src;

public class Game {
    private BoardPanel boardPanel;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isRunning;
    private Currentsquers currentsquers;
    private boolean attack;

    public Game(Currentsquers currentsquers, BoardPanel boardPanel, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.boardPanel = boardPanel;
        this.currentsquers = currentsquers;
        this.isRunning = false;
    }

    public void make_move() {
        if (currentsquers.size() == 2) {
            Square start = currentsquers.getStart();
            Square end = currentsquers.getEnd();
            System.out.println("Start Piece: " + start.getPiece());
            System.out.println("End Square: " + end);

            if (check_move(start, end)) {
                Piece movingPiece = start.getPiece();
                end.add_piece(movingPiece);
                movingPiece.move(end);
                start.remove_piece();
                currentsquers.clear();
                if (attack == true) {
                    Position middle = new Position((start.getPos().getX() + end.getPos().getX()) / 2,
                            (start.getPos().getY() + end.getPos().getY()) / 2);
                    boardPanel.getBoard().remove_piece(middle);
                    currentPlayer.addPoints(1);
                    System.out.println("Piece removed at: " + middle.getX() + "," + middle.getY());
                    if (checkDoubleJump(end)) {
                        System.out.println("Another jump is possible.");
                    } else {
                        switch_player();
                    }
                } else {
                    switch_player();
                }

            } else {
                System.out.println("Illegal move detected. Please try again.");
                currentsquers.clear();
            }
        }
    }

    public void switch_player() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean check_move(Square start, Square end) {
        Position start_pos = start.getPos();
        Position end_pos = end.getPos();
        System.out.println("Checking move from " + "(" + start_pos.getX() + "," + start_pos.getY() + ")" + " to " + "("
                + end_pos.getX() + "," + end_pos.getY() + ")");
        System.out.println("Start piece: " + start.getPiece() + ", End piece: " + end.getPiece());

        if (start.getPiece().player != currentPlayer) {
            System.out.println("Illegal move: piece does not belong to the current player.");
            return false;
        }

        if (end.getPiece().player != null) {
            System.out.println("Illegal move: end position occupied.");
            return false;
        }

        if (end.color.equals("white") || start.color.equals("white")) {
            System.out.println("Illegal move: moving to or from a white square.");
            return false;
        }

        attack = attacking(start, end);
        if (attack) {
            System.out.println("Attack is valid.");
            return true;
        }

        if (start.getPiece().getIsKing()) {
            if (check_king_move(start, end, currentPlayer)) {
                return true;
            }
        }

        var start_modulo = (start_pos.getX() + start_pos.getY()) % 2;
        var end_modulo = (end_pos.getX() + end_pos.getY()) % 2;
        boolean x_true = Math.abs(start_pos.getX() - end_pos.getX()) == 1;
        boolean y_true = Math.abs(start_pos.getY() - end_pos.getY()) == 1;
        boolean backward_white = start_pos.getY() < end_pos.getY();
        boolean backward_black = start_pos.getY() > end_pos.getY();

        if (start_modulo != end_modulo) {
            System.out.println("Illegal move: modulo mismatch.");
            return false;
        }

        if (currentPlayer.color.equals("white")) {
            if (x_true && y_true && backward_white) {
                System.out.println("Move is valid.");
                return true;
            } else {
                System.out.println("Illegal move: white piece moving in wrong direction.");
            }
        } else {
            if (x_true && y_true && backward_black) {
                System.out.println("Move is valid.");
                return true;
            } else {
                System.out.println("Illegal move: black piece moving in wrong direction.");
            }
        }

        return false;
    }

    private boolean attacking(Square start, Square end) {
        Position start_pos = start.getPos();
        Position end_pos = end.getPos();
        if (boardPanel.getBoard().isAttackMovePossible(start_pos, end_pos)) {
            return true;
        }
        return false;
    }

    private boolean check_king_move(Square start, Square end, Player currentPlayer) {
        Position start_pos = start.getPos();
        Position end_pos = end.getPos();
        return boardPanel.getBoard().check_king_move(start_pos, end_pos, currentPlayer);
    }

    private boolean checkDoubleJump(Square end) {
        Position end_pos = end.getPos();
        int x = end_pos.getX();
        int y = end_pos.getY();
        Piece piece = end.getPiece();

        // Possible move directions for checking
        int[][] directions = { { 2, 2 }, { 2, -2 }, { -2, 2 }, { -2, -2 } };

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            Position newPos = new Position(newX, newY);
            if (boardPanel.getBoard().isWithinBounds(newPos)) {
                System.out.println("Checking for double jump at: " + newX + "," + newY);
                Square newSquare = boardPanel.getBoard().getSquareAt(newPos.getX(), newPos.getY());
                if (newSquare.getPiece().player == null && isEnemyPieceBetween(end_pos, newPos, piece)
                        && attacking(end, newSquare)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEnemyPieceBetween(Position start, Position end, Piece piece) {
        int midX = (start.getX() + end.getX()) / 2;
        int midY = (start.getY() + end.getY()) / 2;
        Square middleSquare = boardPanel.getBoard().getSquareAt(midX, midY);
        Piece middlePiece = middleSquare.getPiece();
        return middlePiece != null && middlePiece.player != piece.player;
    }

    public void start() {
        isRunning = true;
    }

    public void update() {
        if (isRunning) {
            // update the board
            make_move();
            boardPanel.update();

        }

    }

    public String getCurentPlayerName() {
        return currentPlayer.color;
    }
}
