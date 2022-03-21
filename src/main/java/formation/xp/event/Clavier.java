package formation.xp.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener
{
	private boolean[] pressed;
	private boolean[] typed;
	private double[] lastTimeTyped;
	private double durationNoRepeat;
	private double durationRepeat;

	public Clavier()
	{
		pressed = new boolean[KeyEvent.KEY_LAST];
		typed = new boolean[KeyEvent.KEY_LAST];
		lastTimeTyped = new double[KeyEvent.KEY_LAST];
		durationNoRepeat = 500;
		durationRepeat = 70;
	}

	public void keyTyped(final KeyEvent k)
	{
		
	}

	public void keyPressed(final KeyEvent k)
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

	public void keyReleased(final KeyEvent k)
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

	public boolean isTyped(int k, double time)
	{
		if (typed[k])
		{
			lastTimeTyped[k] = time - durationRepeat + durationNoRepeat;
			typed[k] = false;
			return true;
		}
		
		if (!isPressed(k))
			return false;
		
		if (time - lastTimeTyped[k] < durationRepeat)
			return false;
		
		lastTimeTyped[k] = time;
		return true;
	}
}
