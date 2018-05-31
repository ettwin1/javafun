import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MineWalkerPanel extends JPanel{
	JTextField gridSize;
	MineFieldPanel grid;
	JTextField level;
	char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
						'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	boolean stop = false;
	public MineWalkerPanel(){
		//Creating Buttons
		JButton[] button = new JButton[3];
		button[0] = new JButton("Show Mines");
		button[1] = new JButton("Show Path");
		button[2] = new JButton("Give Up?");
		button[2].addActionListener(new GiveUp());
		button[1].addActionListener(new ShowPath());
		button[0].addActionListener(new ShowMines());
		for (int i=0; i<3; i++) {
			super.add(button[i]);
		}
		//Creating Input
		gridSize = new JTextField("10");
		gridSize.setPreferredSize(new Dimension(50,20));
		gridSize.addActionListener(new TextEntered());
		super.add(gridSize);
		level = new JTextField("25");
		level.setPreferredSize(new Dimension(50,20));
		level.addActionListener(new TextEntered());
		super.add(level);
		JLabel lbl = new JLabel("% Chance of mines");
		super.add(lbl);
	}
	public Integer getGridSize() {
		boolean good = true;
		for (int i=0; i<alphabet.length; i++) {
			if (gridSize.getText().indexOf(alphabet[i]) != -1) {
				good = false;
			}
		}
		if (good) {
			return(Integer.parseInt(gridSize.getText()));
		}else {
			return(10);
		}	
	}
	public Integer getLevel() {
		boolean good = true;
		for (int i=0; i<alphabet.length; i++) {
			if (level.getText().indexOf(alphabet[i]) != -1) {
				good = false;
			}
		}
		if (good) {
			return(Integer.parseInt(level.getText()));
		}else {
			return(25);
		}
	}
	public void gettingClassInstances (MineFieldPanel a) {
		grid = a;
	}	
	private class TextEntered implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			grid.refreshGrid();
		}
	}
	private class GiveUp implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			stop = true;
			grid.Lose();
		}
	}
	private class ShowPath implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if (stop == false) {
				grid.showPath();
			}
		}
	}
	private class ShowMines implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if (stop==false) {
				grid.showMines();
			}
		}
	}
}
class ColorLabels extends JPanel{
	public ColorLabels() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		
		//Creating Labels
		JLabel[] colorKey = new JLabel[8];
		for (int i=0; i<8; i++) {
			colorKey[i] = new JLabel("");
			colorKey[i].setOpaque(true);
			colorKey[i].setPreferredSize(new Dimension(125,70));
			gbc.gridy = i;
			super.add(colorKey[i], gbc);	
		}
		colorKey[0].setText("0 Nearby Mines");
		colorKey[0].setBackground(Color.GREEN);
		colorKey[1].setText("1 Nearby Mines");
		colorKey[1].setBackground(Color.YELLOW);
		colorKey[2].setText("2 Nearby Mines");
		colorKey[2].setBackground(Color.ORANGE);
		colorKey[3].setText("3 Nearby Mines");
		colorKey[3].setBackground(Color.RED);
		colorKey[4].setText("Exploded Mines");
		colorKey[4].setBackground(Color.BLACK);
		colorKey[4].setForeground(Color.WHITE);
		colorKey[5].setText("Start");
		colorKey[5].setBackground(Color.CYAN);
		colorKey[6].setText("Destination");
		colorKey[6].setBackground(Color.MAGENTA);
		colorKey[7].setText("Star");
		colorKey[7].setBackground(Color.PINK);
	}
}

class ScoreBoard extends JPanel{
	public int lives = 5;
	public int score = 1000;
	JLabel scoreLabel;
	JLabel livesLabel;
	public ScoreBoard() {
		//Gridbag stuff
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		//Creating Labels
		livesLabel = new JLabel("Lives: "+lives);
		scoreLabel = new JLabel("Score: "+score);
		super.add(livesLabel, gbc);
		gbc.gridy = 1;
		super.add(scoreLabel, gbc);
	}
}
