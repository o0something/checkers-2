// package src;
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import java.awt.event.*;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

// import java.awt.Color;


// public class SquareSprite implements Sprite{
//     private Position pos;
//     private Square square;
//     private JButton buttonSquare;
//     private Currentsquers currentsquers;

//     public SquareSprite(Square square, Currentsquers currentsquers){
//         this.square=square;
//         this.pos=square.pos;
//         this.buttonSquare=square.getButton();
//         this.currentsquers=currentsquers;
//     }

//     public JButton getButton(){
//         return buttonSquare;
//     }
//     public void update(){
//         if (square.getPiece()!=null){
//             buttonSquare.setText(square.getPiece().getSymbol());
//         }else{
//             buttonSquare.setText("");
//         }
//     }

//     public void setext(Piece piece){
//         buttonSquare.setText(piece.getSymbol());
//     }

//     public void event(){
//         buttonSquare.addActionListener(new SquareState(square, currentsquers));
//         square.changState("unselected");
//     }

//     @Override
//     public void paint(JPanel f) {
//         square.getButton().setBounds(pos.getX(), pos.getY(), 50, 50);
//         f.add(square.getButton());
//     }



// }
