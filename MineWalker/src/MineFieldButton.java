import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class MineFieldButton extends JButton{
	enum Type {START,NORMAL,PATH,BOMB,FINISH,STAR};
	Type[] type = {Type.START,Type.NORMAL,Type.PATH,Type.BOMB,Type.FINISH, Type.STAR};
	public int indx;
	boolean clickable = false;
	boolean lastClicked = false;
	boolean clicked = false;
	int xCoordinate;
	int yCoordinate;
	public MineFieldButton(int x, int y, int index, int size){
		indx = index;
		xCoordinate = x;
		yCoordinate = y;
		super.setPreferredSize(new Dimension(500/size, 500/size));
		if (type[index] == Type.START) {
			super.setBackground(Color.CYAN);
			clickable = true;
		}else if (type[index] == Type.FINISH) {
			super.setBackground(Color.MAGENTA);
		}else {
			super.setBackground(Color.WHITE);
		}
	}
	
	public void MakeVisible() {
		if (type[indx] == Type.START) {
			super.setBackground(Color.CYAN);
		}else if (type[indx] == Type.FINISH) {
			super.setBackground(Color.MAGENTA);
		}else if (type[indx] == Type.PATH) {
			super.setBackground(Color.BLUE);
		}else if (type[indx] == Type.BOMB) {
			super.setBackground(Color.BLACK);
		}else if (type[indx] == Type.NORMAL) {
			super.setBackground(Color.WHITE);
		}else if (type[indx] == Type.STAR) {
			super.setBackground(Color.PINK);
		}
	}
	
	public boolean isClickable() {
		return(clickable);
	}
	
	public boolean isClicked() {
		return(clicked);
	}
	
	public boolean isLastClicked() {
		return(lastClicked);
	}
	
	public int getx() {
		return(xCoordinate);
	}
	
	public int gety() {
		return(yCoordinate);
	}

}
