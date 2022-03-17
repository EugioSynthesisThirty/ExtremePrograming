package formation.xp.game.grid;

import formation.xp.game.piece.ColorPiece;

public class CaseGrid {
	public boolean filled;
	public ColorPiece color;

	public CaseGrid() {
		filled = false;
		this.color = ColorPiece.ROUGE;
	}

	public CaseGrid(boolean filled, ColorPiece color) {
		this.filled = filled;
		this.color = color;
	}
}
