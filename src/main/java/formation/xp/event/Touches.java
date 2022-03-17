package formation.xp.event;

import java.awt.event.KeyEvent;

public class Touches
{
	private int haut, gauche, bas, droite;

	public Touches()
	{
		this.haut = 0;
		this.gauche = 0;
		this.bas = 0;
		this.droite = 0;
	}

	public Touches(int haut, int gauche, int bas, int droite)
	{
		this.haut = haut;
		this.gauche = gauche;
		this.bas = bas;
		this.droite = droite;
	}

	public int getHaut()
	{
		return haut;
	}

	public void setHaut(int haut)
	{
		this.haut = haut;
	}

	public int getGauche()
	{
		return gauche;
	}

	public void setGauche(int gauche)
	{
		this.gauche = gauche;
	}

	public int getBas()
	{
		return bas;
	}

	public void setBas(int bas)
	{
		this.bas = bas;
	}

	public int getDroite()
	{
		return droite;
	}

	public void setDroite(int droite)
	{
		this.droite = droite;
	}

	public void preSet(int joueur)
	{
		switch (joueur)
		{
			case 0:
				haut = KeyEvent.VK_UP;
				gauche = KeyEvent.VK_LEFT;
				bas = KeyEvent.VK_DOWN;
				droite = KeyEvent.VK_RIGHT;
				break;
			case 1:
				haut = KeyEvent.VK_Z;
				gauche = KeyEvent.VK_Q;
				bas = KeyEvent.VK_S;
				droite = KeyEvent.VK_D;
				break;
			case 2:
				haut = KeyEvent.VK_U;
				gauche = KeyEvent.VK_H;
				bas = KeyEvent.VK_J;
				droite = KeyEvent.VK_K;
				break;
			/*default:
				haut = KeyEvent.VK_UP;
				gauche = KeyEvent.VK_LEFT;
				bas = KeyEvent.VK_DOWN;
				droite = KeyEvent.VK_RIGHT;
				break;*/
		}
	}
}
