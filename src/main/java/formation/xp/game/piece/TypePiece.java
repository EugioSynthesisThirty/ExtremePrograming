package formation.xp.game.piece;

import java.util.ArrayList;

public enum TypePiece {
    I(new Coord(0, -1), new Coord(0, 0), new Coord(0, 1), new Coord(0, 2)),
    J(new Coord(-1, -1), new Coord(-1, 0), new Coord(0, 0), new Coord(1, 0)),
    L(new Coord(-1, 0), new Coord(0, 0), new Coord(1, 0), new Coord(1, -1)),
    O(new Coord(-1, -1), new Coord(-1, 0), new Coord(0, 0), new Coord(0, -1)),
    S(new Coord(-1, 0), new Coord(0, 0), new Coord(0, -1), new Coord(1, -1)),
    T(new Coord(0, -1), new Coord(0, 0), new Coord(1, 0), new Coord(0, 1)),
    Z(new Coord(-1, -1), new Coord(0, -1), new Coord(0, 0), new Coord(1, 0));

    public final ArrayList<Coord> coords;

    private TypePiece(Coord c1, Coord c2, Coord c3, Coord c4) {
        coords = new ArrayList<Coord>();
        coords.add(c1);
        coords.add(c2);
        coords.add(c3);
        coords.add(c4);
    }
}
