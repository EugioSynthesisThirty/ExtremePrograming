package formation.xp;

import java.awt.event.KeyEvent;
import java.io.IOException;

import formation.xp.event.Clavier;
import formation.xp.fenetre.Fenetre;
import formation.xp.fenetre.Panneau;
import formation.xp.fenetre.ScorePanel;
import formation.xp.game.Tetris;

public class Main
{
	public static void main(String[] args)
	{
		Tetris tetris = new Tetris();
		Panneau panneau = new Panneau(tetris);
		Fenetre fenetre = new Fenetre(panneau);
		
		Clavier clavier = fenetre.getClavier();
		tetris.setClavier(clavier);
		
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
		
		while (!tetris.isGameOver()) {
			tempsActuel = System.currentTimeMillis();
			
			if (tempsActuel - lastTemps >= intervalle) {
				lastTemps = tempsActuel;

				tetris.update(tempsActuel);
				panneau.repaint();
			}
		}
		
		while (!clavier.isPressed(KeyEvent.VK_ENTER)) {
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		ScorePanel score;
		try
		{
			score = new ScorePanel("scores.txt", fenetre.getSize(), tetris.getScore());
			fenetre.setContentPane(score);

			while (!score.hasFinished()) {
				fenetre.repaint();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		fenetre.dispose();
	}
	
	public static void quit()
	{
		
	}
}
