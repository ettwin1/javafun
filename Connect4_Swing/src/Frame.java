import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	GridBagConstraints GBC;
	JPanel panel_1;
	//Creating Labels
	JLabel[][] labels_pieces = new JLabel[6][7];
	JLabel[][] labels_outline = new JLabel[7][8];
	public Frame(char[][] grid) {
		super("Connect 4!");
		super.setSize(640,480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//Main Panel
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel_1 = panel1;
		panel1.setBackground(Color.lightGray);
		super.add(panel1, BorderLayout.CENTER);
		
		//Grid Stuff
		GridBagConstraints gbc = new GridBagConstraints();
		GBC = gbc;
		gbc.insets = new Insets(2,4,2,4); //top, left, bottom, right margins
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		//Defining and adding labels
		for(int j=0; j<labels_pieces[0].length; j++) {
			labels_outline[0][j] = new JLabel(""+j);
			gbc.gridx = (j+1)*2;
			gbc.gridy = 0;
			panel1.add(labels_outline[0][j], gbc);
		}
		for(int i=0; i<labels_pieces.length; i++) {
			for (int j=0; j<labels_pieces[0].length; j++) {
				labels_pieces[i][j] = new JLabel(""+grid[i][j]);
				labels_outline[i+1][j] = new JLabel("|");
				gbc.gridx = (j+1)*2-1;
				gbc.gridy = (i+1)*2;
				panel1.add(labels_outline[i+1][j], gbc);
				gbc.gridx = (j+1)*2;
				gbc.gridy = (i+1)*2;
				panel1.add(labels_pieces[i][j], gbc);
				if (j == labels_pieces[0].length-1) {
					labels_outline[i+1][j+1] = new JLabel("|");
					gbc.gridx = (j+1)*2+1;
					gbc.gridy = (i+1)*2;
					panel1.add(labels_outline[i+1][j+1], gbc);
				}
			}
		}
		
	}
	
}
