import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MineFieldPanel extends JPanel{
	MineWalkerPanel controls;
	ScoreBoard scoreboard;
	GridBagConstraints gbc;
	MineFieldButton[][] tiles = new MineFieldButton[10][10];
	RandomWalk rw = new RandomWalk(10);
	Random rando = new Random();
	
	public MineFieldPanel(MineWalkerPanel a){
		super(new GridBagLayout());
		gbc = new GridBagConstraints();
		controls = a;
		refreshGrid();
	}
	
	
	public void refreshGrid() {
		//making the grid
		Integer size = controls.getGridSize();
		rw = new RandomWalk(size);
		rw.createWalk();
		ArrayList<Point> path = rw.getPath();	
		
		super.setVisible(false);
		super.removeAll();
		tiles = new MineFieldButton[size][size];
		for (int i=0; i<tiles.length; i++) {
			for (int j=0; j<tiles[0].length; j++) {
				gbc.gridx = j;
				gbc.gridy = i;
				if (i == size-1 && j == 0) {
					tiles[i][j] = new MineFieldButton(j, i, 0, size);//0 = start, 1 = normal, 2 = path, 3 = bomb, 4 = finish, 5 = star
				}else if (i == 0 && j == size-1) {
					tiles[i][j] = new MineFieldButton(j, i, 4, size);//0 = start, 1 = normal, 2 = path, 3 = bomb, 4 = finish, 5 = star
				}else if (path.indexOf(new Point(j,i)) != -1) {
					tiles[i][j] = new MineFieldButton(j, i, 2, size);//0 = start, 1 = normal, 2 = path, 3 = bomb, 4 = finish, 5 = star
				}else {
					if (rando.nextInt(100) > controls.getLevel()) {
						tiles[i][j] = new MineFieldButton(j, i, 1, size);
					}else {
						tiles[i][j] = new MineFieldButton(j, i, 3, size);
					}
				}
				tiles[i][j].addActionListener(new ButtonListener());
				super.add(tiles[i][j], gbc);
			}
		}
		int times = 0;
		boolean temp = false;
		while (temp == false && times < 10) {
			int x = rando.nextInt(size);
			int y = rando.nextInt(size);
			if (tiles[y][x].indx == 1) {
				tiles[y][x].indx = 5;
				temp = true;
			}
			times ++;
		}
		super.setVisible(true);
		controls.stop = false;
	}
	
	
	public void Lose() {
		for (int i=0; i<tiles.length; i++) {
			for (MineFieldButton button : tiles[i]) {
				button.MakeVisible();
			}
		}
	}
	
	public void showPath() {
		for (int i=0; i<tiles.length; i++) {
			for (MineFieldButton button : tiles[i]) {
				if (button.indx == 2) {
					button.setBackground(Color.BLUE);
				}
			}
		}
		scoreboard.score -= 400;
		scoreboard.scoreLabel.setText("Score: "+scoreboard.score);
	}
	
	public void showMines() {
		for (int i=0; i<tiles.length; i++) {
			for (MineFieldButton button : tiles[i]) {
				if (button.indx == 3) {
					button.setBackground(Color.BLACK);
				}
			}
		}
		scoreboard.score -= 400;
		scoreboard.scoreLabel.setText("Score: "+scoreboard.score);
	}
	
	public void gettingClassInstances(MineWalkerPanel a, ScoreBoard b) {
		controls = a;
		scoreboard = b;
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			MineFieldButton currentButton = (MineFieldButton) evt.getSource();
			if (currentButton.isClickable() && controls.stop == false) {
				if (currentButton.indx != 3 && currentButton.indx != 4) {
					int x = currentButton.getx();
					int y = currentButton.gety();
					int bombs = 0;
					currentButton.clickable = false;
					currentButton.lastClicked = true;
					//currentButton.clicked = true;
					
					//Lowering score
					scoreboard.score -= 1;
					scoreboard.scoreLabel.setText("Score: "+scoreboard.score);
					
					//Making other tiles clickable
					//The Right Square
					if (x+1 < tiles.length) {
						if (tiles[y][x+1].clicked == false) {
							tiles[y][x+1].clickable = true;
							if (tiles[y][x+1].indx != 0 && tiles[y][x+1].lastClicked == false) {
								tiles[y][x+1].setBackground(Color.lightGray);
							}
						}
						if (tiles[y][x+1].indx == 3) {
							bombs += 1;
						}
					}
					//The Left Square
					if (x-1 >= 0) {
						if (tiles[y][x-1].clicked == false) {
							tiles[y][x-1].clickable = true;
							if (tiles[y][x-1].indx != 0 && tiles[y][x-1].lastClicked == false) {
								tiles[y][x-1].setBackground(Color.lightGray);
							}
						}
						if (tiles[y][x-1].indx == 3) {
							bombs += 1;
						}
					}
					//The Bottom Square
					if (y+1 < tiles.length) {
						if (tiles[y+1][x].clicked == false) {
							tiles[y+1][x].clickable = true;
							if (tiles[y+1][x].indx != 0 && tiles[y+1][x].lastClicked == false) {
								tiles[y+1][x].setBackground(Color.lightGray);
							}
						}
						if (tiles[y+1][x].indx == 3) {
							bombs += 1;
						}
					}	
					//The Top Square
					if (y-1 >= 0) {
						if (tiles[y-1][x].clicked == false) {
							tiles[y-1][x].clickable = true;
							if (tiles[y-1][x].indx != 0 && tiles[y-1][x].lastClicked == false) {
								tiles[y-1][x].setBackground(Color.lightGray);
							}
						}
						if (tiles[y-1][x].indx == 3) {
							bombs += 1;
						}
					}
					
					//Setting color of current button
					if (bombs == 0) {currentButton.setBackground(Color.GREEN);}
					else if (bombs == 1) {currentButton.setBackground(Color.YELLOW);}
					else if (bombs == 2) {currentButton.setBackground(Color.ORANGE);}
					else if (bombs == 3) {currentButton.setBackground(Color.RED);}
					
					//Cleaning up other buttons that shouldn't be clickable
					
					for (int i=0; i<tiles.length; i++) {
						for (MineFieldButton btn : tiles[i]) {
							if (btn.clickable == true) {
								if (btn.getx() == (x+1) && btn.gety() == y) {} 
								else if (btn.getx() == (x-1) && btn.gety() == y) {}
								else if (btn.getx() == x && btn.gety() == (y+1)) {} 
								else if (btn.getx() == x && btn.gety() == (y-1)) {}
								else {
									btn.clickable = false;
									if (btn.lastClicked == false) {
										btn.setBackground(Color.WHITE);
									}
								}
							}
						}
					}
				}else if (currentButton.indx == 3){
					//If it is a bomb
					currentButton.setBackground(Color.BLACK);
					scoreboard.lives -= 1;
					scoreboard.score -= 20;
					scoreboard.livesLabel.setText("Lives: "+scoreboard.lives);
					scoreboard.scoreLabel.setText("Score: "+scoreboard.score);
					currentButton.clickable = false;
					currentButton.clicked = true;
					//Check for lose
					if (scoreboard.lives <= 0) {
						controls.stop = true;
						JOptionPane.showMessageDialog(null, "Whelp, you lost");
						//Showing Path and Bombs
						for (int i=0; i<tiles.length; i++) {
							for (MineFieldButton button : tiles[i]) {
								if (button.getBackground() == Color.lightGray) {
									button.setBackground(Color.WHITE);
								}
								if (button.getBackground() == Color.WHITE) {
									if (button.indx == 2) {
										button.setBackground(Color.BLUE);
									}else if (button.indx == 3) {
										button.setBackground(Color.BLACK);
									}else if (button.indx == 5) {
										button.setBackground(Color.PINK);
									}
								}
							}
						}
					}
				}else if (currentButton.indx == 4){
					controls.stop = true;
					JOptionPane.showMessageDialog(null, "You win with "+scoreboard.lives+" lives left and a score of "+scoreboard.score);
					//Showing Path and Bombs
					for (int i=0; i<tiles.length; i++) {
						for (MineFieldButton button : tiles[i]) {
							if (button.getBackground() == Color.lightGray) {
								button.setBackground(Color.WHITE);
							}
							if (button.getBackground() == Color.WHITE) {
								if (button.indx == 2) {
									button.setBackground(Color.BLUE);
								}else if (button.indx == 3) {
									button.setBackground(Color.BLACK);
								}
							}
						}
					}
				}else if (currentButton.indx == 5) {
					//If it is a star
					currentButton.setBackground(Color.PINK);
					scoreboard.lives += 1;
					scoreboard.score += 20;
					scoreboard.livesLabel.setText("Lives: "+scoreboard.lives);
					scoreboard.scoreLabel.setText("Score: "+scoreboard.score);
					currentButton.clickable = false;
					currentButton.clicked = true;
				}
			}
		}
	}
} 
