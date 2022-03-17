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
		
		for (int y = 0; y < grid.height; y++)
		{
			for (int x = 0; x < grid.width; x++)
			{
				assertFalse(grid.getCase(x, y).filled);
			}
		}
	}
}
