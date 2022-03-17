package formation.xp.game;

import java.util.ArrayList;

import formation.xp.game.grid.Grid;
import formation.xp.game.piece.Piece;

public class Tetris
{
	public Grid grid;
	
	public Tetris()
	{
		this.grid = new Grid(9, 9);
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece(1, 1));

		grid.update(pieces);
	}
	
	public void update()
	{

	}
}
