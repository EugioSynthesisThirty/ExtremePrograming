package formation.xp.game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import formation.xp.event.Clavier;
import formation.xp.game.grid.Grid;
import formation.xp.game.piece.Piece;

public class Tetris {
    private Clavier clavier;
    public Grid grid;
    private Piece currentPiece;
    private ArrayList<Piece> pieces;

    public Tetris() {
        clavier = null;
        this.grid = new Grid(10, 21);
        pieces = new ArrayList<Piece>();
        currentPiece = new Piece(5, 5);

        grid.clear();
        grid.update(pieces);
        grid.update(currentPiece, false);
    }

    public void update() {
        if (clavier != null) {
            if (clavier.isTyped(KeyEvent.VK_LEFT, true)) {
                MoveLeft();
            }

            if (clavier.isTyped(KeyEvent.VK_RIGHT, true)) {
                MoveRight();
            }
        }

        grid.clear();
        grid.update(pieces);
        grid.update(currentPiece, false);
    }

    private void MoveLeft() {
        Piece tmpPiece = currentPiece.clone();
        tmpPiece.MoveLeft();
        if (!grid.checkCollision(tmpPiece)) {
            currentPiece = tmpPiece;
        }
    }

    private void MoveRight() {
        Piece tmpPiece = currentPiece.clone();
        tmpPiece.MoveRight();
        if (!grid.checkCollision(tmpPiece)) {
            currentPiece = tmpPiece;
        }
    }

    public void setClavier(Clavier clavier) {
        this.clavier = clavier;
    }
}
