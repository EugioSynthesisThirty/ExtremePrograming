package formation.xp;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import formation.xp.game.grid.Grid;

public class GridTest
{
	@Test
	public void createGridTest()
	{
		Grid grid = new Grid(5, 4);
		
		assertFalse(grid.getCase(4, 3).filled);
	}
}
