package formation.xp.game.piece;

import java.awt.Color;

public enum ColorPiece
{
	ROUGE(222, 49, 99),
	ORANGE(255, 127, 80),
	ORANGE_CLAIR(255, 191, 0),
	JAUNE(223, 255, 0),
	KAKI(159, 226, 191),
	CYAN(64, 224, 208),
	BLEU(100, 149, 237),
	VIOLET(204, 204, 255);
	
	public Color color;
	
	private ColorPiece(int r, int g, int b)
	{
		color = new Color(r, g, b);
	}
}
