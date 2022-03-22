package formation.xp.game.grid;

import java.util.ArrayList;

import formation.xp.game.piece.Coord;
import formation.xp.game.piece.Piece;

public class Grid {
	public final int width;
	public final int height;

	private ArrayList<ArrayList<CaseGrid>> cases;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;

		cases = new ArrayList<ArrayList<CaseGrid>>();

		for (int i = 0; i < height; i++)
			cases.add(new ArrayList<CaseGrid>());

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				cases.get(y).add(new CaseGrid());
		}
	}

	public Grid(Coord size) {
		this(size.x, size.y);
	}

	public CaseGrid getCase(int x, int y) {
		return cases.get(y).get(x);
	}

	public CaseGrid getCase(final Coord coord) {
		return cases.get(coord.y).get(coord.x);
	}

	public void setCase(int x, int y, final CaseGrid caseGrid) {
		cases.get(y).set(x, caseGrid);
	}

	public void setCase(final Coord coord, final CaseGrid caseGrid) {
		cases.get(coord.y).set(coord.x, caseGrid);
	}

	public void clear() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				this.setCase(x, y, new CaseGrid());
		}
	}

	public void update(final ArrayList<Piece> pieces) {
		for (Piece piece : pieces) {
			this.update(piece, true);
		}
	}

	public boolean isInGrid(final Coord coord) {
		return coord.x >= 0 && coord.x < width && coord.y >= 0 && coord.y < height;
	}

	public void update(final Piece piece, boolean fixed) {
		for (Coord coord : piece.getAbsoluteCoords()) {
			if (this.isInGrid(coord)) {
				this.setCase(coord, new CaseGrid(true, fixed, piece.color));
			}
		}
	}

	public boolean checkCollision(final Piece piece) {
		for (Coord coord : piece.getAbsoluteCoords()) {
			if (!this.isInGrid(coord)) {
				return true;
			}

			CaseGrid caseGrid = this.getCase(coord);
			if (caseGrid.filled && caseGrid.fixed) {
				return true;
			}
		}
		return false;
	}
}
