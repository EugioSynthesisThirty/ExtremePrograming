package formation.xp.fenetre;

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