package formation.xp.game.grid;

import formation.xp.game.piece.ColorPiece;

public class CaseGrid {
	public boolean filled;
	public boolean fixed;
	public ColorPiece color;

	public CaseGrid() {
		filled = false;
		fixed = false;
		this.color = ColorPiece.ROUGE;
	}

	public CaseGrid(boolean filled, boolean fixed, ColorPiece color) {
		this.filled = filled;
		this.fixed = fixed;
		this.color = color;
	}
}
