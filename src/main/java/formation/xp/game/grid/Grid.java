package formation.xp.game.grid;

import java.util.ArrayList;

public class Grid
{
	public final int width;
	public final int height;
	
	private ArrayList<ArrayList<CaseGrid>> cases;
	
	public Grid(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		cases = new ArrayList<ArrayList<CaseGrid>>();
		
		for (int i = 0; i < height; i++)
			cases.add(new ArrayList<CaseGrid>());

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
				cases.get(y).add(new CaseGrid());
		}
	}
	
	public CaseGrid getCase(int x, int y)
	{
		return cases.get(y).get(x);
	}
}
