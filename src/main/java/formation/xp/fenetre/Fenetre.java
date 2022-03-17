package formation.xp.fenetre;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import formation.xp.Main;
import formation.xp.event.Clavier;

public class Fenetre extends JFrame
{
	private static final long serialVersionUID = 1L;

	private static int surplus_x = 16, surplus_y = 38;
	public final static Rectangle DIM_DEFAULT = new Rectangle(1280, 720);
	private Clavier clavier = new Clavier();
	private boolean genere = false;

	public Fenetre(Panneau panneau)
	{
		super.setTitle("Tetris");
		super.setSize(DIM_DEFAULT.width + surplus_x, DIM_DEFAULT.height + surplus_y);
		super.setResizable(true);
		super.addWindowListener(new WindowListener()
		{
			public void windowActivated(WindowEvent arg0)
			{
			}

			public void windowClosed(WindowEvent arg0)
			{
			}

			public void windowDeactivated(WindowEvent arg0)
			{
			}

			public void windowDeiconified(WindowEvent arg0)
			{
			}

			public void windowIconified(WindowEvent arg0)
			{
			}

			public void windowOpened(WindowEvent arg0)
			{
			}

			public void windowClosing(WindowEvent arg0)
			{
				Main.quit();
				System.exit(0);
			}
		});

		super.setLocationRelativeTo(null);
		super.setContentPane(panneau);
		super.addKeyListener(clavier);
		super.requestFocusInWindow();
		super.setVisible(true);
		genere = true;
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
		long lastTemps = System.currentTimeMillis();
		FontMetrics metrics = g.getFontMetrics(font);
		int pos_x = x + (int) (metrics.stringWidth(text) * translate_x);
		int pos_y = y + (int) (metrics.getHeight() * translate_y);
		g.drawString(text, pos_x, pos_y);
		long tempsActuel = System.currentTimeMillis();
		if ((tempsActuel - lastTemps) > 100)
			System.out.println("bug : " + (tempsActuel - lastTemps) + "ms");
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
	public static void drawCenteredString(Graphics g, String text, Rectangle rect)
	{
		Font font = g.getFont();
		FontMetrics metrics = g.getFontMetrics(font);
		int x = (rect.width - metrics.stringWidth(text)) / 2;
		int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		g.drawString(text, x + rect.x, y + rect.y);
	}

	public Clavier getClavier()
	{
		return clavier;
	}

	public void setClavier(Clavier clavier)
	{
		super.getContentPane().removeKeyListener(super.getContentPane().getKeyListeners()[0]);
		super.getContentPane().addKeyListener(clavier);
		this.clavier = clavier;
	}

	public boolean isGenere()
	{
		return genere;
	}
}