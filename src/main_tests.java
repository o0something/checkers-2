// package src;

// import java.awt.*; 
// import java.awt.event.WindowAdapter; 
// import java.awt.event.WindowEvent; 
// import javax.swing.JFrame;

// public class main_tests  extends Frame{
//     public static void main(String[] args) 
//     {
//       JFrame f = new JFrame(); 
//       f.setLayout(new GridLayout(10,9));
//       f.setVisible(true); 
//       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       f.setSize(400, 400); 
//       for (int i = 0; i < 8; i++) {
//       Square nam2= new Square(new Position(0, 0),40);
//       SquareSprite s1 = new SquareSprite(nam2);
//       s1.paint(f);
//     }

//       // Player p1= new Player("black");
//       // PieceSprite t=new PieceSprite(new Piece(p1, new Position(30, 50)),"assets\\black_checkers1_2.png");
//       Integer color=255;
//       for (int i = 0; i < 8; i++) {
//         for (int j = 0; j < 8; j++) {
//           if ((i+j)%2==0){
//             color=255;
//           }
//           Square nam= new Square(new Position(j*50, i*50),color);
//           SquareSprite s2 = new SquareSprite(nam);
//           color=000;
//           s2.paint(f);
//           s2.event();
//         }
      
//       }
//       for (int i = 0; i < 8; i++) {
//         Square nam2= new Square(new Position(0, 0),40);
//         SquareSprite s1 = new SquareSprite(nam2);
//         s1.paint(f);
//       }
//       // PieceSprite t2=new PieceSprite(new Piece(p1, new Position(30, 100)),"assets\\black_checkers1_2.png");
//     }
// }
