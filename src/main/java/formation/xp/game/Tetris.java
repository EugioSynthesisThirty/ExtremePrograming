package formation.xp.game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import formation.xp.event.Clavier;
import formation.xp.game.grid.CaseGrid;
import formation.xp.game.grid.Grid;
import formation.xp.game.piece.Coord;
import formation.xp.game.piece.Piece;

public class Tetris {
    private static final Coord SIZE_GRID = new Coord(10, 21);
    private static final Coord POS_CURRENT = new Coord(5, 0);
    private static final Coord POS_NEXT = new Coord(12, 8);
    
    private Clavier clavier;
    private Grid grid;
    private Piece currentPiece;
    private Piece nextPiece;
    private ArrayList<Piece> pieces;
    
    private boolean timeInitialised;
    private double lastTimeDown;
    private double durationDown;

    public Tetris() {
        clavier = null;
        this.grid = new Grid(SIZE_GRID);
        pieces = new ArrayList<Piece>();
        currentPiece = new Piece(POS_CURRENT);
        nextPiece = new Piece(POS_NEXT);
        
        timeInitialised = false;
        lastTimeDown = 0;
        durationDown = 1000;

        grid.clear();
        grid.update(pieces);
        grid.update(currentPiece, false);
    }

    public void update(double time) {
        if (!timeInitialised)
        {
        	lastTimeDown = time;
        	timeInitialised = true;
        }
        
        updateKeys(time);
        
        if (time - lastTimeDown >= durationDown)
        {
        	MoveDown();
        	lastTimeDown = time;
        }

        grid.clear();
        grid.update(pieces);
        grid.update(currentPiece, false);
    }
    
    private void updateKeys(double time) {
        if (clavier != null) {
            if (clavier.isTyped(KeyEvent.VK_LEFT, time)) {
                MoveLeft();
            }

            if (clavier.isTyped(KeyEvent.VK_RIGHT, time)) {
                MoveRight();
            }

            if (clavier.isTyped(KeyEvent.VK_UP, time)) {
                Rotate();
            }

            if (clavier.isTyped(KeyEvent.VK_DOWN, time)) {
            	MoveDown();
            }
        }
    }

    private boolean MoveLeft() {
        Piece tmpPiece = currentPiece.clone();
        tmpPiece.MoveLeft();
        if (!grid.checkCollision(tmpPiece)) {
            currentPiece = tmpPiece;
            return true;
        }
        return false;
    }

    private boolean MoveRight() {
        Piece tmpPiece = currentPiece.clone();
        tmpPiece.MoveRight();
        if (!grid.checkCollision(tmpPiece)) {
            currentPiece = tmpPiece;
            return true;
        }
        return false;
    }
    
    private boolean MoveDown() {
        Piece tmpPiece = currentPiece.clone();
        tmpPiece.MoveDown();
        if (!grid.checkCollision(tmpPiece)) {
            currentPiece = tmpPiece;
            return true;
        }
        
    	pieces.add(currentPiece);
    	currentPiece = nextPiece;
    	currentPiece.setPosition(POS_CURRENT);
    	nextPiece = new Piece(POS_NEXT);
        durationDown *= 0.96;
        return false;
    }

    private boolean Rotate() {
        Piece tmpPiece = currentPiece.clone();
        tmpPiece.Rotate();
        if (!grid.checkCollision(tmpPiece)) {
            currentPiece = tmpPiece;
            return true;
        }

        tmpPiece.MoveLeft();
        
        if (grid.checkCollision(tmpPiece)) {
            tmpPiece.MoveRight();
            tmpPiece.MoveRight();
            
            if (grid.checkCollision(tmpPiece))
            	return false;
        }

        currentPiece = tmpPiece;
        return true;
    }

    public Piece getNextPiece() {
    	return nextPiece;
    }
    
    public void setClavier(Clavier clavier) {
        this.clavier = clavier;
    }
    
    public int getWidth() {
    	return grid.width;
    }
    
    public int getHeight() {
    	return grid.height;
    }
    
    public CaseGrid getCase(int x, int y) {
    	return grid.getCase(x, y);
    }
}
