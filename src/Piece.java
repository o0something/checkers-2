package src;

public class Piece {
    public Position pos;
    private boolean isKing;
    public Player player;
    private static int White_y = 7;
    private static int Black_y = 0;
    private String symbol;

    public Piece(Player player) {
        // this.player.color=player.col
        this.player = player;
        this.isKing = false;
        if (player.color == "black") {
            this.symbol = "♥";
        } else if (player.color == "white") {
            this.symbol = "♡";
        }

    }

    public Piece() {
        this.isKing = false;
        this.symbol = " ";
        this.player = null;
    }

    public void move(Square new_pos) {
        if ((new_pos.getY() == White_y && player.color.equals("white") ) || (new_pos.getY() == Black_y && player.color.equals("black")) ){
            setIsKing(true);;
        }
        this.pos = new_pos.pos;
    };

    public Position getPos() {
        return pos;
    };

    public boolean getIsKing() {
        return isKing;
    };

    public void setIsKing(boolean isKing) {
        this.isKing = isKing;
        if (player.color == "black") {
            this.symbol = "♛";
        } else if (player.color == "white" ){
            this.symbol = "♕";
        }
    };

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}