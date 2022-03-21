package formation.xp.game.piece;

import java.util.ArrayList;

public enum TypePiece {
    I(new CoordFloat(0, 1.5f), new CoordFloat(0, 0.5f), new CoordFloat(0, -0.5f), new CoordFloat(0, -1.5f)), //bon
    J(new CoordFloat(1, 0.5f), new CoordFloat(1, -0.5f), new CoordFloat(0, -0.5f), new CoordFloat(-1, -0.5f)), 
    L(new CoordFloat(-1, 0.5f), new CoordFloat(-1, -0.5f), new CoordFloat(0, -0.5f), new CoordFloat(1, -0.5f)), // bon
    O(new CoordFloat(-0.5f, -0.5f), new CoordFloat(-0.5f, 0.5f), new CoordFloat(0.5f, 0.5f), new CoordFloat(0.5f, -0.5f)), //bon
    S(new CoordFloat(-1, 0.5f), new CoordFloat(0, 0.5f), new CoordFloat(0, -0.5f), new CoordFloat(1, -0.5f)),
    T(new CoordFloat(-1, -0.5f), new CoordFloat(0, -0.5f), new CoordFloat(0, 0.5f), new CoordFloat(1, -0.5f)), //bon
    Z(new CoordFloat(1, 0.5f), new CoordFloat(0, 0.5f), new CoordFloat(0, -0.5f), new CoordFloat(-1, -0.5f)); //bon

    public final ArrayList<CoordFloat> coords;

    private TypePiece(final CoordFloat c1, final CoordFloat c2, final CoordFloat c3, final CoordFloat c4) {
        coords = new ArrayList<CoordFloat>();
        coords.add(c1);
        coords.add(c2);
        coords.add(c3);
        coords.add(c4);
    }
}
