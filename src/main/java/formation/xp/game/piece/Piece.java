package formation.xp.game.piece;

import java.util.ArrayList;

public class Piece implements Cloneable {
    public ArrayList<Coord> coords;
    public Coord position;
    public ColorPiece color;

    public Piece(int x, int y) {
        this.position = new Coord(x, y);

        this.coords = new ArrayList<Coord>();
        this.coords.add(new Coord(-1, 0));
        this.coords.add(new Coord(0, 0));
        this.coords.add(new Coord(1, 0));
        this.coords.add(new Coord(0, 1));

        int colorIndex = (int) (Math.random() * ColorPiece.values().length);
        color = ColorPiece.values()[colorIndex];
    }

    public ArrayList<Coord> getAbsoluteCoords() {
        ArrayList<Coord> absoluteCoords = new ArrayList<Coord>();
        for (Coord coord : this.coords) {
            absoluteCoords.add(new Coord(coord.x + position.x, coord.y + position.y));
        }
        return absoluteCoords;
    }

    public void MoveLeft() {
        this.position.x--;
    }

    public void MoveRight() {
        this.position.x++;
    }

    @Override
    public Piece clone() {
        return new Piece(this.position.x, this.position.y);
    }
}
