package formation.xp;
import formation.xp.fenetre.Fenetre;
import formation.xp.fenetre.Panneau;
import formation.xp.game.Tetris;

public class Main
{
	public static void main(String[] args)
	{
		Tetris tetris = new Tetris(0, 0);
		
		Panneau panneau = new Panneau(tetris);
		Fenetre fenetre = new Fenetre(panneau);
		
		while (!fenetre.isGenere());
		
		long tempsDebut = System.currentTimeMillis();
		long tempsActuel;
		double lastTemps = tempsDebut;
		int fpsMax = 100;
		double intervalle;
		
		if (fpsMax > 0)
			intervalle = (double) 1000 / fpsMax;
		else
			intervalle = 0;
		
		while (true)
		{
			tempsActuel = System.currentTimeMillis();
			
			if (tempsActuel - lastTemps >= intervalle)
			{
				lastTemps = tempsActuel;
				
				panneau.repaint();
				tetris.update();
			}
		}
	}
	
	public static void quit()
	{

	}
}
