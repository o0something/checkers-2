package src;
public class Piece{
    public Position pos;
    private boolean isKing;
    public Player player;
    private static int Red_x;
    private static int Black_x;
    private String symbol;

    public Piece(Player player){
        // this.player.color=player.col
        this.isKing=false;
        if (player.color=="black"){
            this.symbol="✈";
        } else if(player.color=="white") {
            this.symbol="▍ ▌";
        }

    }
    public Piece(){
        this.isKing=false;
        this.symbol="e";
    }

    public void move(Square new_pos){
        if (new_pos.getX() == Red_x || new_pos.getX() == Black_x){
            isKing=true;
        }
        this.pos=new_pos.pos;
    };

    public Position getPos(){
        return pos;
    };

    public boolean getIsKing(){
        return isKing;
    };  

    public void setIsKing(boolean isKing){
        this.isKing=isKing;
    };

    public String getSymbol(){
       return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol=symbol;
    }

    
}