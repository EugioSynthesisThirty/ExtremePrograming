package formation.xp.game.piece;

public class CoordFloat {
    public float x;
    public float y;

    public CoordFloat(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString()
    {
    	return "(" + x + ", " + y + ")";
    }
}
