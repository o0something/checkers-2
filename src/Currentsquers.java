package src;

import java.util.ArrayList;

public class Currentsquers {
    private ArrayList<Square> currentsquers = new ArrayList<>(2);

    public Currentsquers() {
    }

    public void addSquare(Square square) {
        if (!currentsquers.contains(square)) {
            if (square.getPiece().player!=null && currentsquers.size() == 0) {
                System.out.println("Adding square: " + square);
                currentsquers.add(square);
            }
            else if (square.getPiece().player==null && currentsquers.size() == 1) {
                System.out.println("Adding square: " + square);
                currentsquers.add(square);
            }
        }
    }

    public void clear() {
        currentsquers.clear();
    }

    public int size() {
        return currentsquers.size();
    }

    public Square getStart() {
        return currentsquers.size() > 0 ? currentsquers.get(0) : null;
    }

    public Square getEnd() {
        return currentsquers.size() > 1 ? currentsquers.get(1) : null;
    }

    public String getPosStart() {
        if (size() == 0) {
            return "null";
        } else {
            return (currentsquers.get(0).getX() + "," + currentsquers.get(0).getY());
        }
    }

    public String getPosEnd() {
        if (size() <= 1) {
            return "null";
        } else {
            return (currentsquers.get(1).getX() + "," + currentsquers.get(1).getY());
        }
    }
}
