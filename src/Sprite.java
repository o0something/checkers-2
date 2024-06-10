package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.nio.Buffer;

interface Sprite {
    public abstract void paint(JPanel f);
    public abstract void update();
    public abstract void event();
}


// class Mouse implements MouseListener {
 
//     Mouse()
//     {
//     }
 
//     public void mousePressed(MouseEvent e)
//     {
//         System.out.println("mouse pressed at point:"
//                        + e.getX() + " " + e.getY());
//     }

//     public void mouseReleased(MouseEvent e)
//     {
 
//         // show the point where the user released the mouse click
//         System.out.println("mouse released at point:"
//                        + e.getX() + " " + e.getY());
//     }
 
//     // this function is invoked when the mouse exits the component
//     public void mouseExited(MouseEvent e)
//     {
 
//         // show the point through which the mouse exited the frame
//         System.out.println("mouse exited through point:"
//                        + e.getX() + " " + e.getY());
//     }
 
//     // this function is invoked when the mouse enters the component
//     public void mouseEntered(MouseEvent e)
//     {
 
//         // show the point through which the mouse entered the frame
//         System.out.println("mouse entered at point:"
//                        + e.getX() + " " + e.getY());
//     }
 
//     // this function is invoked when the mouse is pressed or released
//     public void mouseClicked(MouseEvent e)
//     {
//         System.out.println("mouse clicked at point:"
//                        + e.getX() + " "
//                        + e.getY() + "mouse clicked :" + e.getClickCount());
//     }
// }