package formation.xp.game.piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Piece implements Cloneable {
	private static LinkedList<TypePiece> bufferType = new LinkedList<TypePiece>();
	private static LinkedList<ColorPiece> bufferColor = new LinkedList<ColorPiece>();
	private static final int N_CYCLES = 2;
	
    private Coord position;
    private int rotation;
    public ColorPiece color;
    private TypePiece typePiece;

    public Piece(int x, int y) {
        this.position = new Coord(x, y);
        this.rotation = 0;

        if (bufferType.size() == 0) {
        	for (int i = 0; i < N_CYCLES; i++) {
        		bufferType.addAll(Arrays.asList(TypePiece.values()));
        	}
        	
        	Collections.shuffle(bufferType);
        }

        if (bufferColor.size() == 0) {
        	for (int i = 0; i < N_CYCLES; i++) {
        		bufferColor.addAll(Arrays.asList(ColorPiece.values()));
        	}
        	
        	Collections.shuffle(bufferColor);
        }
        
        this.typePiece = bufferType.removeLast();
        this.color = bufferColor.removeLast();
    }
    
    public Piece(Coord pos) {
    	this(pos.x, pos.y);
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
    
    public void setPosition(Coord pos) {
    	this.position = pos;
    }
    
    public Coord getPosition() {
    	return this.position;
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
