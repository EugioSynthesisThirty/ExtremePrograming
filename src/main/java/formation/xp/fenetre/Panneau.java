package formation.xp.fenetre;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import formation.xp.game.Tetris;

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

		if (this.tetris != null)
		{
			((Graphics2D) g).drawRect(tetris.x, tetris.y, 100, height);
		}
	}
}