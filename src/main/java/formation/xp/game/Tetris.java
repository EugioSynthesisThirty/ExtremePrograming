package formation.xp.game;

public class Tetris
{
	public int x;
	public int y;
	
	public Tetris(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void update()
	{
		x += 2;
		y += 1;
	}
}
