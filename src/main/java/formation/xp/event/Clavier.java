package formation.xp.event;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener
{
	private boolean[] pressed;
	private boolean[] typed;

	public Clavier()
	{
		pressed = new boolean[KeyEvent.KEY_LAST];
		typed = new boolean[KeyEvent.KEY_LAST];
	}

	public Clavier(Component c)
	{
		pressed = new boolean[KeyEvent.KEY_LAST];
		typed = new boolean[KeyEvent.KEY_LAST];
		c.addKeyListener(this);
		c.requestFocusInWindow();
	}

	public void keyTyped(KeyEvent k)
	{
		
	}

	public void keyPressed(KeyEvent k)
	{
		try
		{
			if (!pressed[k.getKeyCode()])
				typed[k.getKeyCode()] = true;

			pressed[k.getKeyCode()] = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void keyReleased(KeyEvent k)
	{
		try
		{
			pressed[k.getKeyCode()] = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public boolean isPressed(int k)
	{
		return pressed[k];
	}

	public void setPressed(int k, boolean pressed)
	{
		this.pressed[k] = pressed;
	}

	public boolean isTyped(int k, boolean reset)
	{
		boolean retour = typed[k];
		try
		{
			if (reset)
				typed[k] = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		return retour;
	}

	public void setTyped(int k, boolean typed)
	{
		this.typed[k] = typed;
	}

	public void reset()
	{
		for (int i = 0; i < KeyEvent.KEY_LAST; i++)
		{
			pressed[i] = false;
			typed[i] = false;
		}
	}

	public void reset(int k)
	{
		pressed[k] = false;
		typed[k] = false;
	}

	public void reset(Touches touches)
	{
		pressed[touches.getHaut()] = false;
		typed[touches.getHaut()] = false;
		pressed[touches.getGauche()] = false;
		typed[touches.getGauche()] = false;
		pressed[touches.getBas()] = false;
		typed[touches.getBas()] = false;
		pressed[touches.getDroite()] = false;
		typed[touches.getDroite()] = false;
	}
}
