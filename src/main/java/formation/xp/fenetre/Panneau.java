package formation.xp.fenetre;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
	private Font font = new Font("times", Font.PLAIN, 60);

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

	public void paintComponent(Graphics g)
	{
		if (this.tetris == null)
			return;
		
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

		g.setFont(font);
		g.setColor(new Color(0, 0, 0));
		
		drawTranslatedString(g, "" + tetris.getScore(),
				offset_x + lengthCase * (tetris.getWidth() + 1),
				offset_y,
				0, 1);
	}

	/**
	 * Ecrit un texte et réalise la translation désirée.
	 * 
	 * @param g
	 *            la destination
	 * @param text
	 *            le texte à écrire
	 * @param x
	 *            les coordonnées initiales du texte
	 * @param y
	 *            les coordonnées initiales du texte
	 * @param translate_x
	 *            le taux de décalage du texte en abscisse
	 * @param translate_y
	 *            le taux de décalage du texte en ordonnée
	 */
	public static void drawTranslatedString(Graphics g, String text, int x, int y, double translate_x, double translate_y)
	{
		Font font = g.getFont();
		FontMetrics metrics = g.getFontMetrics(font);
		int pos_x = x + (int) (metrics.stringWidth(text) * translate_x);
		int pos_y = y + (int) (metrics.getHeight() * translate_y);
		g.drawString(text, pos_x, pos_y);
	}

	/**
	 * Ecrit un texte centré dans la zone désirée.
	 * 
	 * @param g
	 *            la destination
	 * @param text
	 *            le texte à écrire
	 * @param rect
	 *            le rectangle dans lequel il dois être centré
	 */
	public static void drawCenteredString(Graphics g, String text, final Rectangle rect)
	{
		Font font = g.getFont();
		FontMetrics metrics = g.getFontMetrics(font);
		int x = (rect.width - metrics.stringWidth(text)) / 2;
		int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		g.drawString(text, x + rect.x, y + rect.y);
	}
}