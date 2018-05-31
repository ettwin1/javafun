import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Swing2/*extended class*/ extends JFrame/*base class*/{
	public Swing2() {
		//call the base constructor
		super("Some Panel thing"); //this constructor sets the window title

		setSize(800, 600);//Sets the size of window
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Closes when exited
		setVisible(true);//makes sure it's set to visible
		
		//Creating top Panel
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setBackground(Color.RED);
		super.add(panel1, BorderLayout.NORTH);
		
		//Creating middle Panel
		JPanel panel3 = new JPanel(new GridBagLayout());//adding grid to center panel
		panel3.setBackground(Color.BLUE);
		super.add(panel3, BorderLayout.CENTER);
		
		//Creating bottom Panel
		JPanel panel2 = new JPanel(new GridBagLayout());
		panel2.setBackground(Color.GREEN);
		super.add(panel2, BorderLayout.SOUTH);
		
		//Creating left Panel
		JPanel panel4 = new JPanel(new GridBagLayout());
		panel4.setBackground(Color.MAGENTA);
		super.add(panel4, BorderLayout.WEST);
		
		//Creating right Panel
		JPanel panel5 = new JPanel(new GridBagLayout());
		panel5.setBackground(Color.ORANGE);
		super.add(panel5, BorderLayout.EAST);
		
		//Creating a button - on top panel
		JButton button1 = new JButton("Heyoo");//putting label on button
		button1.setBackground(Color.ORANGE);
		
		
		//Creating a button - on bottom panel
		JButton button2 = new JButton("I'm on the bottom");//putting label on button
		button2.setBackground(Color.MAGENTA);
		panel2.add(button2);
		
		//Create a check box
		JCheckBox cbox1 = new JCheckBox("Doo you like my window?");
		
		
		//Create a Label
		JLabel label1 = new JLabel("This is a checkbox! (I don't like being a label)");
		label1.setForeground(Color.WHITE);
		
		
		//Create a label in a GridBag
		JLabel label2 = new JLabel("This label is in a grid!");
		JLabel label3 = new JLabel("This label is in a grid also!");
		JLabel label4 = new JLabel("This label is in a grid also also!");
		label2.setForeground(Color.WHITE);
		label3.setForeground(Color.WHITE);
		label4.setForeground(Color.WHITE);
		//panel3.add(label2);
		
		//Intro to Grids!
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right margins
		gbc.gridx = 0;//where to place our label, like a 2d array
		gbc.gridy = 0;
		panel3.add(label2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel3.add(label3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel3.add(label4, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel3.add(cbox1, gbc);
		gbc.gridx = 1;	
		gbc.gridy = 2;
		panel3.add(label1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		JCheckBox cbox3 = new JCheckBox("I am too!");
		panel2.add(cbox3, gbc);
		
		//An array of buttons
		JButton[] middleButtons = new JButton[4];
		gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right margins
		for (int i=0; i<4; i++) {
			middleButtons[i] = new JButton("I'm button "+i);
		}
		
		gbc.gridy = 3;
		for (int i=0; i<2; i++) {
			gbc.gridx = i;
			panel3.add(middleButtons[i], gbc);
		}
		gbc.gridy = 4;
		for (int i=0; i<2; i++) {
			gbc.gridx = i;
			panel3.add(middleButtons[i+2], gbc);
		}
		
		
		
		//Top Grid
		gbc.gridx = 0;
		gbc.gridy = 0;
		JCheckBox cbox2 = new JCheckBox("CLICK ME");
		panel1.add(cbox2, gbc);
		JLabel label5 = new JLabel("Your face!");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel1.add(label5, gbc);
		gbc.gridx = 1;
		//gbc.gridheight = 0;
		//button1.setSize(50, 10);
		//panel1.add(button1, gbc);
		
		//Left Grid
		JButton but1 = new JButton("Click Me!");
		JLabel but2 = new JLabel("Catch me if you can");
		JLabel but3 = new JLabel("Show me what you got");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel4.add(but1, gbc);
		//gbc.gridx = 0;
		gbc.gridy = 1;
		panel4.add(but2, gbc);
		//gbc.gridx = 0;
		gbc.gridy = 2;
		panel4.add(but3, gbc);
		
		//Right Grid
		JButton but4 = new JButton("Buttons are cool");
		JButton but5 = new JButton("You see me now");
		JButton but6 = new JButton("You don't");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel5.add(but4, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel5.add(but5, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel5.add(but6, gbc);	
		
		setVisible(true);//makes sure it's set to visible

	}
	
	

}
