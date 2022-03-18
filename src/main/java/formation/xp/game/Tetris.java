package formation.xp.game;

import java.util.ArrayList;

import formation.xp.game.grid.Grid;
import formation.xp.game.piece.Piece;

public class Tetris {
	public Grid grid;
	private Piece currentPiece;
	private ArrayList<Piece> pieces;

	public Tetris() {
		this.grid = new Grid(9, 9);
		pieces = new ArrayList<Piece>();
		currentPiece = new Piece(1, 1);

		grid.update(pieces);
		grid.update(currentPiece);
	}

	public void MoveLeft() {

	}
}
