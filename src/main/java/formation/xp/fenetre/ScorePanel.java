package formation.xp.fenetre;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScorePanel extends JPanel
{
	private class Score
	{
		public String pseudo;
		public int score;
		
		public Score(String pseudo, int score)
		{
			this.pseudo = pseudo;
			this.score = score;
		}
	}
	
	private static final long serialVersionUID = 1L;
	private final String fileName;
	private ArrayList<Score> scores;
	private JButton validerButton;
	private boolean finished;
	
	public ScorePanel(String fileName, Dimension dim, final int newScore) throws IOException {
		this.fileName = fileName;
		
		loadScores();
		setSize(dim);
		requestFocusInWindow();
		
		int n = scores.size() > 5 ? 5 : scores.size();
		setLayout(new GridLayout(n + 2, 1));

		Font font = new Font("Courier New", Font.BOLD, 45);

		for (int i = 0; i < n; i++) {
			Score score = scores.get(i);
			JTextField scoreField = new JTextField(score.pseudo + " " + score.score);
			scoreField.setHorizontalAlignment(JTextField.CENTER);
			scoreField.setFont(font);
			scoreField.setEditable(false);
			add(scoreField);
		}

		final JTextField pseudoField = new JTextField("Entrez votre pseudo.");
		
		pseudoField.addFocusListener(new FocusListener() {
			private boolean firstTime = true;
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				if (firstTime) {
					firstTime = false;
					pseudoField.setText("");
				}
			}
		});

		pseudoField.setHorizontalAlignment(JTextField.CENTER);
		pseudoField.setFont(font);
		add(pseudoField);
		
		validerButton = new JButton("valider");
		validerButton.setHorizontalAlignment(JButton.CENTER);
		validerButton.setFont(font);
		validerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					scores.add(new Score(pseudoField.getText(), newScore));
					saveScores();
					finished = true;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		add(validerButton);
	}
	
	private void loadScores() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		
		scores = new ArrayList<Score>();

		while (line != null) {
			String pseudo = line.substring(0, line.lastIndexOf(' '));
			int score = Integer.parseInt(line.substring(line.lastIndexOf(' ') + 1));
			scores.add(new Score(pseudo, score));
			line = reader.readLine();
		}
		
		sortScores();
		reader.close();
	}
	
	private void sortScores() {
		Collections.sort(scores, new Comparator<Score>() {
			public int compare(Score a, Score b) {
				if (a.score == b.score)
					return 0;
				if (a.score < b.score)
					return 1;
				return -1;
			}
		});
	}
	
	private void saveScores() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		sortScores();
		
		for (Score score : scores) {
			writer.write(score.pseudo + " " + score.score);
			writer.newLine();
		}
		
		writer.close();
	}

	public boolean hasFinished()
	{
		return finished;
	}
}
