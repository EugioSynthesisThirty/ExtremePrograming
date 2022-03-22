package formation.xp.game.piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Piece implements Cloneable {
	private static LinkedList<TypePiece> buffer = new LinkedList<TypePiece>();
	private static final int N_CYCLES = 2;
	
    private Coord position;
    private int rotation;
    public ColorPiece color;
    private TypePiece typePiece;

    public Piece(int x, int y) {
        this.position = new Coord(x, y);
        this.rotation = 0;

        int colorIndex = (int) (Math.random() * ColorPiece.values().length);
        color = ColorPiece.values()[colorIndex];

        if (buffer.size() == 0) {
        	for (int i = 0; i < N_CYCLES; i++) {
        		buffer.addAll(Arrays.asList(TypePiece.values()));
        	}
        	
        	Collections.shuffle(buffer);
        }
        
        this.typePiece = buffer.removeLast();
    }

    private Piece(final Piece piece) {
        this.position = new Coord(piece.position.x, piece.position.y);
        this.rotation = piece.rotation;
        this.color = piece.color;
        this.typePiece = piece.typePiece;
    }

    public ArrayList<Coord> getAbsoluteCoords() {
        ArrayList<Coord> absoluteCoords = new ArrayList<Coord>();
        for (final CoordFloat coord : this.typePiece.coords) {
        	CoordFloat cf = new CoordFloat(coord.x, coord.y);
        	
        	for (int i = 0; i < rotation; i++)
        		cf = new CoordFloat(cf.y, -cf.x);
        	
        	Coord c = new Coord(cf);
            absoluteCoords.add(new Coord(c.x + position.x, c.y + position.y));
        }
        return absoluteCoords;
    }

    public void MoveLeft() {
        this.position.x--;
    }

    public void MoveRight() {
        this.position.x++;
    }
    
    public void MoveDown() {
    	this.position.y++;
    }
    
    public void Rotate() {
    	this.rotation = (this.rotation + 1) % 4;
    }

    @Override
    public Piece clone() {
        return new Piece(this);
    }
}
