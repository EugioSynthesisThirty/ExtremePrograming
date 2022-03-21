package formation.xp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import formation.xp.game.grid.Grid;
import formation.xp.game.piece.Coord;
import formation.xp.game.piece.Piece;

public class GridTest {
	@Test
	public void createGridTest() {
		Grid grid = new Grid(5, 4);

		for (int y = 0; y < grid.height; y++) {
			for (int x = 0; x < grid.width; x++) {
				assertFalse(grid.getCase(x, y).filled);
			}
		}
	}

	@Test
	public void addOnePieceTest() {
		Grid grid = new Grid(5, 4);
		grid.update(new Piece(1, 1), false);

		ArrayList<Coord> parts = new ArrayList<Coord>();
		parts.add(new Coord(0, 1));
		parts.add(new Coord(1, 1));
		parts.add(new Coord(2, 1));
		parts.add(new Coord(1, 2));

		for (int y = 0; y < grid.height; y++) {
			for (int x = 0; x < grid.width; x++) {
				boolean found = false;
				for (Coord coord : parts) {
					if (coord.x == x && coord.y == y) {
						found = true;
					}
				}
				assertEquals(found, grid.getCase(x, y).filled);
			}
		}
	}

	@Test
	public void noCollisionTest() {
		Grid grid = new Grid(5, 4);
		Piece piece = new Piece(1, 1);

		assertFalse(grid.checkCollision(piece));
	}

	@Test
	public void outOfBoundsTest() {
		Grid grid = new Grid(5, 4);
		Piece piece = new Piece(0, 1);

		assertTrue(grid.checkCollision(piece));
	}

	@Test
	public void collisionWithFixedTest() {
		Grid grid = new Grid(5, 4);
		Piece fixedPiece = new Piece(1, 1);
		Piece piece = new Piece(3, 1);

		grid.update(fixedPiece, true);
		assertTrue(grid.checkCollision(piece));
	}
}
