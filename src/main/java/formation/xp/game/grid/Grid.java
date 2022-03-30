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
			for (int x = 0; x < width; x++) {
				this.setCase(x, y, new CaseGrid());				
			}
		}
	}
	
	public boolean isInGrid(final Coord coord) {
		return coord.x >= 0 && coord.x < width && coord.y >= 0 && coord.y < height;
	}
	
	public void pushPiece(final Piece piece) {
		for (Coord coord : piece.getAbsoluteCoords()) {
			if (this.isInGrid(coord)) {
				this.setCase(coord, new CaseGrid(true, piece.color));
			}
		}
	}

	public boolean checkCollision(final Piece piece) {
		for (Coord coord : piece.getAbsoluteCoords()) {
			if (coord.x < 0 || coord.x >= width || coord.y >= height) {
				return true;
			}
			
			if (coord.y < 0)
				continue;

			CaseGrid caseGrid = this.getCase(coord);
			if (caseGrid.filled) {
				return true;
			}
		}
		return false;
	}
	
	public int clearLines() {
		int score = 0;
		int scoreParLigne = 100;

		for (int y = 0; y < height; y++) {
			boolean filled = true;
			
			for (int x = 0; x < width; x++) {
				if (!this.getCase(x, y).filled) {
					filled = false;
					break;
				}
			}
			
			if (filled) {
				score += scoreParLigne;
				scoreParLigne *= 2;

				for (int y2 = y; y2 > 0; y2--) {
					for (int x2 = 0; x2 < width; x2++) {
						setCase(x2, y2, getCase(x2, y2 - 1));
					}
				}

				for (int x2 = 0; x2 < width; x2++) {
					setCase(x2, 0, new CaseGrid());
				}
			}
		}
		
		return score;
	}
}
