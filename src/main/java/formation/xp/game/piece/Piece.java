package formation.xp.game.piece;

import java.util.ArrayList;

public class Piece implements Cloneable {
    public Coord position;
    public ColorPiece color;
    public TypePiece typePiece;

    public Piece(int x, int y) {
        this.position = new Coord(x, y);

        int colorIndex = (int) (Math.random() * ColorPiece.values().length);
        color = ColorPiece.values()[colorIndex];

        int pieceIndex = (int) (Math.random() * TypePiece.values().length);
        this.typePiece = TypePiece.values()[pieceIndex];
    }

    private Piece(final Piece piece) {
        this.position = new Coord(piece.position.x, piece.position.y);
        this.color = piece.color;
        this.typePiece = piece.typePiece;
    }

    public ArrayList<Coord> getAbsoluteCoords() {
        ArrayList<Coord> absoluteCoords = new ArrayList<Coord>();
        for (Coord coord : this.typePiece.coords) {
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
        return new Piece(this);
    }
}
