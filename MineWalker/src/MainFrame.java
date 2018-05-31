import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame(){
		super("Mine Walker, the Game! Created by Ethan A");
		super.setVisible(true);
		super.setSize(750,600);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MineWalkerPanel controls = new MineWalkerPanel();
		super.add(controls, BorderLayout.SOUTH);
		
		ColorLabels labels = new ColorLabels();
		super.add(labels, BorderLayout.WEST);
		
		ScoreBoard scoreboard = new ScoreBoard();
		super.add(scoreboard, BorderLayout.EAST);
		
		MineFieldPanel grid = new MineFieldPanel(controls);
		super.add(grid, BorderLayout.CENTER);
		
		grid.gettingClassInstances(controls, scoreboard);
		controls.gettingClassInstances(grid);
		
		
		super.setVisible(true);
	}
}
