package formation.xp.fenetre;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import formation.xp.game.Tetris;
import formation.xp.game.grid.CaseGrid;
import formation.xp.game.piece.Coord;
import formation.xp.game.piece.Piece;

public class Panneau extends JPanel
{
	private static final long serialVersionUID = 1L;

	private Tetris tetris;
	private int width, height;
	private Font font = new Font("times", Font.PLAIN, 30);
	private boolean initialized = false;

	public Panneau()
	{
		super();
		this.tetris = null;
	}

	public Panneau(Tetris tetris)
	{
		super();
		this.tetris = tetris;
	}

	private void init(Graphics g)
	{
		if (initialized)
			return;
		
		g.setFont(font);
		g.getFontMetrics(font);
		initialized = true;
	}

	public void paintComponent(Graphics g)
	{
		init(g);
		
		width = super.getWidth();
		height = super.getHeight();

		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int widthGrid = tetris.getWidth() + 5;
		int heightGrid = tetris.getHeight();
		
		int widthCase = (int) ((float) width / (float) widthGrid);
		int heightCase = (int) ((float) height / (float) heightGrid);
		int lengthCase = widthCase < heightCase ? widthCase : heightCase;
		
		int offset_x = (width - lengthCase * widthGrid) / 2;
		int offset_y = (height - lengthCase * heightGrid) / 2;
		int margin = 2;

		g.setColor(new Color(196, 196, 196));
		g.fillRect(0, 0, width, height);
		
		if (this.tetris != null) {
			for (int x = 0; x < tetris.getWidth(); x++) {
				for (int y = 0; y < tetris.getHeight(); y++) {
					final CaseGrid c = tetris.getCase(x, y);
					
					if (c.filled) {
						g.setColor(c.color.color);
					}
					else {
						g.setColor(new Color(255, 255, 255));
					}

					g.fillRect(offset_x + lengthCase * x + margin / 2,
							offset_y + lengthCase * y + margin / 2,
							lengthCase - margin, lengthCase - margin);
				}
			}
			
			Piece[] pieces = new Piece[]{tetris.getNextPiece(), tetris.getCurrentPiece()};
			
			for (final Piece piece : pieces) {
				g.setColor(piece.color.color);
				
				for (final Coord pos : piece.getAbsoluteCoords()) {
					g.fillRect(offset_x + lengthCase * pos.x + margin / 2,
							offset_y + lengthCase * pos.y + margin / 2,
							lengthCase - margin, lengthCase - margin);
				}
			}
		}
	}
}