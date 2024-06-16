package src;

import java.util.ArrayList;

public class Currentsquers {
    private ArrayList<Square> currentsquers = new ArrayList<>(2);

    public Currentsquers() {}

    public void addSquare(Square square) {
        if (!currentsquers.contains(square)) {
            currentsquers.add(square);
        }
    }

    public void clear() {
        currentsquers.clear();
    }

    public ArrayList<Square> getCurrentSquares() {
        return currentsquers;
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

    public void update() {
        System.out.println("Current Squares: " + currentsquers);
    }
}
