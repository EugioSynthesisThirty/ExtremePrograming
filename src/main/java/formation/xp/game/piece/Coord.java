package formation.xp.game.piece;

public class Coord {
    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coord(final CoordFloat c) {
        this.x = (int) Math.ceil(c.x);
        this.y = (int) Math.ceil(c.y);
    }
    
    public String toString()
    {
    	return "(" + x + ", " + y + ")";
    }
}
