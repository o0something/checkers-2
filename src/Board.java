package src;

import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares;

    public Board() {
        squares = new ArrayList<Square>();
    }

    public void remove_piece(Position pos) {
        for (Square square : squares) {
            if (square.pos.getX() == pos.getX() && square.pos.getY() == pos.getY()) {
                square.remove_piece();
            }
        }
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public void add_square(Square square) {
        squares.add(square);
    }

    public void add_piece(Piece piece, Position pos) {
        for (Square square : squares) {
            if (square.pos.getX() == pos.getX() && square.pos.getY() == pos.getY()) {
                square.add_piece(piece);
            }
        }
    }

    public boolean isAttackMovePossible(Position source, Position target) {
        Square sourceSquare = null;
        Square targetSquare = null;
        Square middleSquare = null;

        // Find the source and target squares on the board
        for (Square square : squares) {
            if (square.getPos().getX() == source.getX() && square.getPos().getY() == source.getY()) {
                sourceSquare = square;
            }
            if (square.getPos().getX() == target.getX() && square.getPos().getY() == target.getY()) {
                targetSquare = square;
            }
            if (square.getPos().getX() == (source.getX() + target.getX()) / 2
                    && square.getPos().getY() == (source.getY() + target.getY()) / 2) {
                middleSquare = square;
            }
        }

        // Check if both squares are found
        if (sourceSquare == null || targetSquare == null || middleSquare == null) {
            return false;
        }

        Piece sourcePiece = sourceSquare.getPiece();
        Piece targetPiece = targetSquare.getPiece();
        Piece middlePiece = middleSquare.getPiece();

        // Check if the source square has a piece and the target square has an
        // opponent's piece
        if (sourcePiece == null || sourcePiece.player.equals(targetPiece.player)) {
            return false;
        }

        // Implement specific game rules for attack move here
        // Example: Check if the move is diagonal (assuming a game like checkers)
        if (middlePiece.player == null) {
            return false;
        }
        if (sourcePiece.player.equals(middlePiece.player)) {
            return false;
        }

        if (targetPiece.player != null) {
            return false;
        }

        return true;
    }

    public boolean check_king_move(Position start_pos, Position end_pos, Player currentPlayer) {
        int deltaX = end_pos.getX() - start_pos.getX();
        int deltaY = end_pos.getY() - start_pos.getY();

        if (Math.abs(deltaX) != Math.abs(deltaY)) {
            return false; // King must move diagonally
        }

        int stepX = deltaX / Math.abs(deltaX);
        int stepY = deltaY / Math.abs(deltaY);

        int x = start_pos.getX() + stepX;
        int y = start_pos.getY() + stepY;

        boolean opponentPieceFound = false;
        while (x != end_pos.getX() && y != end_pos.getY()) {
            Square square = getSquareAt(x, y);
            if (square.getPiece().player != null) {
                if (square.getPiece().player == currentPlayer) {
                    return false; // Cannot jump over own piece
                } else if (opponentPieceFound) {
                    return false; // Cannot jump over more than one opponent piece
                } else {
                    opponentPieceFound = true;
                }
            }
            x += stepX;
            y += stepY;
        }

        return true;
    }

    public Square getSquareAt(int x, int y) {
        for (Square square : squares) {
            if (square.getPos().getX() == x && square.getPos().getY() == y) {
                return square;
            }
        }
        return null;
    }

    public boolean isWithinBounds(Position pos) {
        return pos.getX() >= 0 && pos.getX() < 8 && pos.getY() >= 0 && pos.getY() < 8;
    }
}
