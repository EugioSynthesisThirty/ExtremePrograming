package formation.xp.fenetre;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import formation.xp.game.Tetris;
import formation.xp.game.grid.CaseGrid;

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
		
		int widthCase = (int) ((float) width / (float) tetris.grid.width);
		int heightCase = (int) ((float) height / (float) tetris.grid.height);
		int lengthCase = widthCase < heightCase ? widthCase : heightCase;
		int offset_x = (width - lengthCase * tetris.grid.width) / 2;
		int offset_y = (height - lengthCase * tetris.grid.height) / 2;
		int margin = 2;

		g.setColor(new Color(196, 196, 196));
		g.fillRect(0, 0, width, height);
		
		if (this.tetris != null)
		{
			for (int x = 0; x < tetris.grid.width; x++)
			{
				for (int y = 0; y < tetris.grid.height; y++)
				{
					CaseGrid c = tetris.grid.getCase(x, y);
					
					if (c.fixed)
					{
						g.setColor(new Color(0, 0, 0));
					}
					else if (c.filled)
					{
						g.setColor(c.color.color);
					}
					else
					{
						g.setColor(new Color(255, 255, 255));
					}

					g.fillRect(offset_x + lengthCase * x + margin / 2,
							offset_y + lengthCase * y + margin / 2,
							lengthCase - margin, lengthCase - margin);
				}
			}
		}
	}
}