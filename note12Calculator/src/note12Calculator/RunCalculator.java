package note12Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.lang.Math;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RunCalculator {

	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setVisible(true);

	}

}

class MainFrame extends JFrame {
	public MainFrame() {
		super("Best Calculator Evah");
		super.setSize(240,150);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Screen north = new Screen();
		super.add(north, BorderLayout.NORTH);
		
		Numbers west = new Numbers();
		super.add(west, BorderLayout.WEST);
		
		Operators center = new Operators();
		super.add(center, BorderLayout.CENTER);
		
		Other east = new Other();
		super.add(east, BorderLayout.EAST);
		
		center.registerClasses(north, east);
		west.registerClasses(north, center, east);
		east.registerClasses(north, center);
		
	}
}

class Screen extends JPanel {
	JTextField screen;
	public Screen() {
		screen = new JTextField();
		screen.setPreferredSize(new Dimension(220,30));
		super.add(screen);
		//screen.setText("0");
	}
	public double getValue() {
		String text = screen.getText();
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i=0; i<alphabet.length; i++) {
			if (text.equals("") || text.indexOf(alphabet[i]) != -1 ) {
				return(0.0);
			}else if (text.equals("0.")) {
				return(0.1);
			}else if ((text.length()-1)-text.indexOf('.') == 0) {
				Double value = Double.parseDouble(text.substring(0, text.indexOf('.')));
				return(value);
			}
		}
		Double value = Double.parseDouble(text);
		return(value);
		
	}
	public void postDigit(String digit) {
		String text = screen.getText();
		if (digit == ".") {
			//Making sure you can't input more than one dot
			int dots = 0;
			for (int i=0; i<text.length(); i++) {
				if (text.charAt(i) == '.') {
					dots += 1;
				}
			}
			if (dots < 1) {
				screen.setText(text+digit);
			}
		}else {
			screen.setText(text+digit);
		}
	}
	public void postResult(String result) {
		screen.setText(result);
	}
}

class Numbers extends JPanel {
	JButton one,two,three,four,five,six,seven,eight,nine,zero,dot,clear;
	JButton[] button = {seven,eight,nine,four,five,six,one,two,three,zero,dot,clear};
	String[] button_text = {"7", "8", "9", "4", "5", "6", "1", "2","3","0","."};
	Screen display;
	Operators ops;
	Other others;
	public Numbers() {
		super(new GridBagLayout());
		//Creating button with an array
		
		for(int i=0; i<button.length; i++) {
			if (i <= 2) {
				button[i] = new JButton(Integer.toString(7+i));
			}else if (i <= 5) {
				button[i] = new JButton(Integer.toString(1+i));
			}else if (i <= 8) {
				button[i] = new JButton(Integer.toString(-5+i));
			}else {
				if (i==9) button[i] = new JButton("0");
				if (i==10) button[i] = new JButton(".");
				if (i==11) button[i] = new JButton("C");
			}
		}
		
		//Putting buttons in grid
		GridBagConstraints gbc = new GridBagConstraints();
		int j = 0;
		for(int i=0; i<button.length; i++) {
			if (i <= 2) {
				gbc.gridy = 0;
				gbc.gridx = j;
				super.add(button[i], gbc);
			}else if (i <= 5) {
				gbc.gridy = 1;
				gbc.gridx = j;
				super.add(button[i], gbc);
			}else if (i <= 8) {
				gbc.gridy = 2;
				gbc.gridx = j;
				super.add(button[i], gbc);
			}else if (i <= 11) {
				gbc.gridy = 3;
				gbc.gridx = j;
				super.add(button[i], gbc);
			}
			if (j != 2) j ++;
			else j = 0;
		}
		
		//Adding listeners to buttons
		for(int i=0; i<button.length-1; i++) {
			button[i].addActionListener(new ButtonListener());
		}
		button[11].addActionListener(new ClearListener());
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if (display.getValue() == ops.value1) {
				display.postResult("");
			}
			JButton currentButton = (JButton) evt.getSource();
			int button_index = Arrays.asList(button).indexOf(currentButton);
			String button_digit = button_text[button_index];
			display.postDigit(button_digit);
		}
	}
	private class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			display.postResult("0");
			ops.value1 = 0.0;
			ops.value2 = null;
			others.result = null;
		}
	}
	public void registerClasses(Screen scrn, Operators opratr, Other othrs) {
		display = scrn;
		ops = opratr;
		others = othrs;
	}
	
}


class Operators extends JPanel{
	JButton divide, times, minus, plus;
	JButton[] button = {divide, times, minus, plus};
	Screen display;
	Other others;
	Double value1 = 0.0;
	Double value2 = null;
	int operator = 0; //1 = divide, 2 = times, 3 = minus, 4 = plus; 5 = exponent
	public Operators() {
		super(new GridBagLayout());
		
		button[0] = new JButton("/");
		button[1] = new JButton("*");
		button[2] = new JButton("-");
		button[3] = new JButton("+");
		
		GridBagConstraints gbc = new GridBagConstraints();
		for(int i=0; i<button.length; i++) {
			gbc.gridy = i;
			super.add(button[i], gbc);
		}
		
		for(int i=0; i<button.length; i++) {
			button[i].addActionListener(new ButtonListener());
		}
	}
	public void registerClasses(Screen screen, Other othrs) {
		display = screen;
		others = othrs;
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			JButton currentButton = (JButton) evt.getSource();
			int button_index = Arrays.asList(button).indexOf(currentButton);
			if (value1 == 0.0 && value2 == null) {
				value1 = display.getValue();
			}else if (value1 != 0.0 && value2 == null) {
				value2 = display.getValue();
				System.out.println("geting value2");
			}
			if (value1 != null && value2 != null && others.result == null) {
				value2 = display.getValue();
				if (operator == 1) {
					others.result = value1 / value2;
				}else if (operator == 2) {	
					others.result = value1 * value2;
				}else if (operator == 3) {	
					others.result = value1 - value2;
				}else if (operator == 4) {	
					others.result = value1 + value2;
				}else if (operator == 5) {	
					others.result = Math.pow(value1, value2);
				}
				others.single_operation = false;
				value1 = value2;
				value2 = null;
				System.out.println(others.result);
			}else if (value1 != null && value2 != null && others.result != null) {
				value2 = display.getValue();
				if (operator == 1) {
					others.result = others.result / value2;
				}else if (operator == 2) {	
					others.result = others.result  * value2;
				}else if (operator == 3) {	
					others.result = others.result  - value2;
				}else if (operator == 4) {	
					others.result = others.result  + value2;
				}else if (operator == 5) {	
					others.result = Math.pow(others.result , value2);
				}
				others.single_operation = false;
				value1 = value2;
				value2 = null;
			}
			operator = button_index + 1;
		}
	}
}

class Other extends JPanel{
	JButton get_memory, add_memory, power, equals;
	JButton[] button = {get_memory, add_memory, power, equals};
	Screen display;
	Operators ops;
	Double result;
	Double memory;
	Boolean single_operation = true;
	public Other() {
		super(new GridBagLayout());
		button[0] = new JButton("Rm");
		button[1] = new JButton("m+");
		button[2] = new JButton("^");
		button[3] = new JButton("=");
		
		GridBagConstraints gbc = new GridBagConstraints();
		for(int i=0; i<button.length; i++) {
			gbc.gridy = i;
			super.add(button[i], gbc);
		}
		
		button[3].addActionListener(new EqualsListener());
		button[2].addActionListener(new ExponentListener());
		button[0].addActionListener(new MemoryListener());
		button[1].addActionListener(new MemoryListener());
	}
	public void registerClasses(Screen scrn, Operators oprtr) {
		display = scrn;
		ops = oprtr;
	}
	private class EqualsListener implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			if (ops.operator != 0) {
				if (single_operation == true) {
					ops.value2 = display.getValue();
					if (ops.operator == 1) {
						result = ops.value1 / ops.value2;
					}else if (ops.operator == 2) {	
						result = ops.value1 * ops.value2;
					}else if (ops.operator == 3) {	
						result = ops.value1 - ops.value2;
					}else if (ops.operator == 4) {	
						result = ops.value1 + ops.value2;
					}else if (ops.operator == 5) {	
						result = Math.pow(ops.value1, ops.value2);
					}
					ops.operator = 0;
					ops.value1 = 0.0;
					ops.value2 = null;
					single_operation = true;
				}else if (single_operation == false){
					ops.value1 = display.getValue();
					System.out.println("success!");
					if (ops.operator == 1) {
						result = result / ops.value1;
					}else if (ops.operator == 2) {	
						result = result * ops.value1;
					}else if (ops.operator == 3) {	
						result = result - ops.value1;
					}else if (ops.operator == 4) {	
						result = result + ops.value1;
					}else if (ops.operator == 5) {	
						result = Math.pow(result, ops.value1);
					}
					ops.operator = 0;
					ops.value1 = 0.0;
					ops.value2 = null;
					single_operation = true;
				}
				display.postResult(Double.toString(result));
			}
			
		}
	}
	private class ExponentListener implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			ops.operator = 5;
			ops.value1 = display.getValue();
		}
	}
	private class MemoryListener implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			JButton currentButton = (JButton) evt.getSource();
			if (currentButton.getText().equals("Rm")) {
				display.postResult(Double.toString(memory));
			}else {
				memory = display.getValue();
			}
			
		}
	}
}